package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ProcurementPurchaseGoodEntity {

    @ManyToOne
    @JsonBackReference("ProcurementPurchaseEntity-ProcurementPurchaseGoodEntity")
    ProcurementPurchaseEntity procurementPurchase;
    @OneToOne
    ProcurementRequestGoodEntity procurementRequestGoodEntity;
    String vendor;
    String contact;
    String contactTelephone;
    double number; //个数
    String packageSpecification; //包装规格
    String packageUnit; //包装单位
    String otherRequirements;
    double pricePerUnit; //单价
    double totalPrice; //总价
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcurementRequestGoodEntity getProcurementRequestGoodEntity() {
        return procurementRequestGoodEntity;
    }

    public void setProcurementRequestGoodEntity(ProcurementRequestGoodEntity procurementRequestGoodEntity) {
        this.procurementRequestGoodEntity = procurementRequestGoodEntity;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
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
