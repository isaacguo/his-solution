package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ProcurementRequestGoodEntity {

    String number; //个数
    String packageSpecification; //包装规格
    String packageUnit; //包装单位
    String otherRequirements;
    String reason;
    String name;
    @ManyToOne
    @JsonBackReference("request-goods")
    ProcurementRequestEntity request;
    double pricePerUnit; //单价
    double totalPrice;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProcurementRequestEntity getRequest() {
        return request;
    }

    public void setRequest(ProcurementRequestEntity request) {
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public String getOtherRequirements() {
        return otherRequirements;
    }

    public void setOtherRequirements(String otherRequirements) {
        this.otherRequirements = otherRequirements;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}

