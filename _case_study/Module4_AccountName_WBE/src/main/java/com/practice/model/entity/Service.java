package com.practice.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;      //bo sung-Service code
    private String serviceName;
    private double area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String otherConvenienceDes;
    private double poolArea;
    private int floors;

    //1-N: CONTRACT
    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    private List<Contract> contractList;

    //qhe 1-n: RentType
    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(referencedColumnName = "id")
    private RentType rentType;

    //qhe 1-n: ServiceType
    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(referencedColumnName = "id")
    private ServiceType serviceType;


    public Service() {
    }

    public Service(Integer id, String code, String serviceName, double area, double cost, int maxPeople, String standardRoom, String otherConvenienceDes, double poolArea, int floors, RentType rentType, ServiceType serviceType) {
        this.id = id;
        this.code = code;
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.otherConvenienceDes = otherConvenienceDes;
        this.poolArea = poolArea;
        this.floors = floors;
        this.rentType = rentType;
        this.serviceType = serviceType;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenienceDes() {
        return otherConvenienceDes;
    }

    public void setOtherConvenienceDes(String otherConvenienceDes) {
        this.otherConvenienceDes = otherConvenienceDes;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
