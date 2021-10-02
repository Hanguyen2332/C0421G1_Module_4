package com.practice.model.entity;

import com.practice.model.entity.employee.Employee;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;      //bo sung-Service code
    private Date endDate;
    private double deposit;
    private double totalFee;

    //n-1: Employee
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(referencedColumnName = "id")
    private Employee employee;

    //n-1: Customer
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;

    //n-1: Service
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(referencedColumnName = "id")
    private Service service;

    //1-n: ContractDetail
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;

    public Contract(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract() {
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

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
