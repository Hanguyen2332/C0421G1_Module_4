package com.practice.model.dto;


import com.practice.common.CheckDate;
import com.practice.model.entity.Customer;
import com.practice.model.entity.Service;
import com.practice.model.entity.employee.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

public class ContractDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //validate
    private Date startDate;
    private Date endDate;

    //
    private double deposit;
    private double totalFee;  //xu ly tai service

    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        Date startDate = contractDto.getStartDate();
        Date endDate = contractDto.getEndDate();
        if (!CheckDate.checkStartDate(startDate)) {
            errors.rejectValue("startDate","startDate.future","Ngày bắt đầu phải lớn hơn hoặc bằng ngày hiện tại");
        }
        if (!CheckDate.checkEndDate(endDate,startDate)) {
            errors.rejectValue("endDate","endDate.past","Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu");
        }
    }
}
