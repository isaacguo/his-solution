package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "ProcurementRequests")
public class ProcurementRequestEntity {

    String requester;
    String requesterFullName;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
    @JsonManagedReference("request-vendorInfo")
    ProcurementRequestVendorInfoEntity vendorInfo;
    String explanation;
    Double totalPrice;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    @JsonManagedReference("request-goods")
    List<ProcurementRequestGoodEntity> goods = new LinkedList<>();
    LocalDateTime submittedData;
    @OneToOne
    @JsonBackReference("ProcurementEntity-ProcurementRequestEntity")
    ProcurementEntity procurement;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getRequesterFullName() {
        return requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public ProcurementRequestVendorInfoEntity getVendorInfo() {
        return vendorInfo;
    }

    public void setVendorInfo(ProcurementRequestVendorInfoEntity vendorInfo) {
        if(vendorInfo==null)
            throw new RuntimeException("Vendor Info is null.");
        vendorInfo.setRequest(this);
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

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public List<ProcurementRequestGoodEntity> getGoods() {
        return goods;
    }

    public void addGood(ProcurementRequestGoodEntity good) {
        if (good == null)
            throw new RuntimeException("Good is null.");
        good.setRequest(this);
        this.goods.add(good);
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
