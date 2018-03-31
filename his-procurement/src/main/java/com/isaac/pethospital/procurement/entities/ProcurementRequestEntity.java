package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProcurementRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String requester;
    @OneToMany
    List<ProcurementGoodEntity> goods = new LinkedList<>();
    String vendorName;
    String contact;
    String contactTelephone;
    LocalDateTime submittedData;
    @OneToOne
    ProcurementEntity procurement;


    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public List<ProcurementGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<ProcurementGoodEntity> goods) {
        this.goods = goods;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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

    public LocalDateTime getSubmittedData() {
        return submittedData;
    }

    public void setSubmittedData(LocalDateTime submittedData) {
        this.submittedData = submittedData;
    }

    public ProcurementEntity getProcurement() {
        return procurement;
    }

    public void setProcurement(ProcurementEntity procurement) {
        this.procurement = procurement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
