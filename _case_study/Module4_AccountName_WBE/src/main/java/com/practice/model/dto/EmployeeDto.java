package com.practice.model.dto;

import com.practice.common.CheckDate;
import com.practice.model.entity.employee.Division;
import com.practice.model.entity.employee.EducationDegree;
import com.practice.model.entity.employee.Position;
import com.practice.model.entity.employee.User;
import com.practice.model.service.impl.MyUserDetailServieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;
import java.sql.Date;

@Component
public class EmployeeDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$",
            message = "Tên phải bắt đầu bằng chữ in hoa, không chứa ký tự số, chỉ để 1 khoảng trắng giữa các từ")
    private String name;

    private Date dayOfBirth;

    @Pattern(regexp = "^\\d{11}|\\d{9}$",
            message = "Vui lòng nhập theo định dạng: 'XXXXXXXXX' or 'XXXXXXXXX'  (X: 0-9)")
    private String idCard;

    private double salary;

    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$",
            message = "Vui lòng nhập theo định dạng: '090xxxxxxx' or '091xxxxxxx' or (84)+90xxxxxxx or (84)+91xxxxxxx  (x: 0-9)")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$",
            message = "Vui lòng nhập theo định dạng, VD: 'email23@gmail.com'")
    private String email;

    @NotBlank (message = "Không được để trống trường này")
    private String address;

//    @NotEmpty(message = "Không được để trống trường này")
    private User user;
    private Position position;
    private Division division;
    private EducationDegree eduDegree;

    public EmployeeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEduDegree() {
        return eduDegree;
    }

    public void setEduDegree(EducationDegree eduDegree) {
        this.eduDegree = eduDegree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    //
    @Autowired
    private MyUserDetailServieImpl myUserDetailServie;
    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        //date of birth
        if (!CheckDate.checkAge(employeeDto.getDayOfBirth())) {
            errors.rejectValue("dayOfBirth", "birthday.checkAge", "Tuổi phải >= 18 và <=100");
        }


//        //userName:  - NG: chưa check đc duplicate username
            String inputUserName = employeeDto.user.getUserName();
            UserDetails user = myUserDetailServie.loadUserByUsername(inputUserName);
            if (user != null) {
                errors.rejectValue("user","duplicate.userName","Tên người dùng đã tồn tại");
            }
    }
}
