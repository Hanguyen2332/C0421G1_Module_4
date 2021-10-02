package com.practice.model.entity.employee;

import com.practice.model.entity.Contract;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date dayOfBirth;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;

    //OneToMany: contract
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> contractList;


    //1-1:userName
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private User user;

    //n-1: Position
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(referencedColumnName = "id")
    private Position position;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(referencedColumnName = "id")
    private Division division;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(referencedColumnName = "id")
    private EducationDegree eduDegree;

    public Employee() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
