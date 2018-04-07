package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestGoodEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestVendorInfoEntity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class ProcurementRequestOperation {

    Long id;
    String requester;
    VendorInfoOperationRequest vendorInfo;
    List<ProcurementRequestGoodEntity> goods = new LinkedList<>();
    LocalDateTime submittedData;
    ProcurementEntity procurement;
    String explanation;
    Double totalPrice;

    public VendorInfoOperationRequest getVendorInfo() {
        return vendorInfo;
    }

    public void setVendorInfo(VendorInfoOperationRequest vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

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

    public List<ProcurementRequestGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<ProcurementRequestGoodEntity> goods) {
        this.goods = goods;
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
        this.goods.forEach(r->{
            pro.addGood(r);
        });
        pro.setRequester(this.requester);
        pro.setTotalPrice(this.totalPrice);
        pro.setExplanation(this.explanation);

        ProcurementRequestVendorInfoEntity procurementRequestVendorInfoEntity =new ProcurementRequestVendorInfoEntity();
        procurementRequestVendorInfoEntity.setContact(this.vendorInfo.contact);
        procurementRequestVendorInfoEntity.setContactTelephone(this.vendorInfo.contactTelephone);
        procurementRequestVendorInfoEntity.setVendor(this.vendorInfo.vendor);
        procurementRequestVendorInfoEntity.setVendorId(this.vendorInfo.vendorId);
        pro.setVendorInfo(procurementRequestVendorInfoEntity);
    }
}
