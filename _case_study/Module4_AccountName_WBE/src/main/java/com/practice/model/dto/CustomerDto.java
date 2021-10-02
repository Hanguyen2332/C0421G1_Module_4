package com.practice.model.dto;

import com.practice.common.CheckDate;
import com.practice.model.entity.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;
import java.sql.Date;


public class CustomerDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "KH-[0-9]{4}", message = "Vui lòng nhập đúng định dạng: 'KH-XXXX' (Với X: 0-9)")
    private String code;

    @Pattern(regexp = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$",
            message = "Tên không chứa ký tự số,chỉ để 1 khoảng trắng giữa các từ")
    private String name;

    private Date dayOfBirth;

    private boolean gender;

    @Pattern(regexp = "^\\d{11}|\\d{9}$",
            message = "Vui lòng nhập theo định dạng: 'XXXXXXXXX' or 'XXXXXXXXX'  (X: 0-9)")
    private String idCard;

    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$",
            message = "Vui lòng nhập theo định dạng: '090xxxxxxx' or '091xxxxxxx' or (84)+90xxxxxxx or (84)+91xxxxxxx  (x: 0-9)")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$",
            message = "Vui lòng nhập theo định dạng, VD: 'email23@gmail.com'")
    private String email;

    @NotBlank(message = "Vui lòng không để trống trường này")
    private String address;


    private CustomerType customerType;


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    //checK age:
    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        Date birthDay = customerDto.getDayOfBirth();
        if (!CheckDate.checkAge(birthDay)) {  //không bắt được NullPoiter ???
            errors.rejectValue("dayOfBirth", "birthday.checkAge", "Tuổi phải >= 18 và <=100");
        }
//            try {
//            Date birthDay = customerDto.getDayOfBirth();
//            if (!checkAge(birthDay)) {  //không bắt được NullPoiter ???
//                errors.rejectValue("dayOfBirth","birthday.checkAge","Tuổi phải >= 18 và <=100");
//            }
//        }catch (NumberFormatException ex) {
//            errors.rejectValue("dayOfBirth","birthday.notNull","Vui lòng nhập ngày sinh");
//        }
    }
}
