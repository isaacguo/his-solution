package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementGoodEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProcurementRequestOperation {

    Long id;
    String requester;
    List<ProcurementGoodEntity> goods = new LinkedList<>();
    String vendorName;
    String contact;
    String contactTelephone;
    LocalDateTime submittedData;
    ProcurementEntity procurement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ProcurementRequestEntity toProcurementRequestEntity() {
        ProcurementRequestEntity pro=new ProcurementRequestEntity();
        assignValues(pro);
        return pro;
    }

    private void assignValues(ProcurementRequestEntity pro) {
        pro.setContact(this.contact);
        pro.setVendorName(this.vendorName);
        pro.setContactTelephone(this.contactTelephone);
        pro.setGoods(this.goods);
        pro.setRequester(this.requester);
    }
}
