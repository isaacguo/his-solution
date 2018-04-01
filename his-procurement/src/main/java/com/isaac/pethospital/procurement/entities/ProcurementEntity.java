package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProcurementEntity {

    String orderNumber; //单号
    String vendor;
    String contact;
    String contactTelephone;
    @ManyToOne
    OperatorEntity operator;
    String status;
    @OneToOne(mappedBy = "procurement")
    @JsonManagedReference("ProcurementEntity-ProcurementRequestEntity")
    ProcurementRequestEntity procurementRequest;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "procurement", cascade = CascadeType.ALL)
    @JsonManagedReference("ProcurementEntity-ProcurementApprovalEntity")
    List<ProcurementApprovalEntity> approvalList = new LinkedList<>();

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

    public ProcurementRequestEntity getProcurementRequest() {
        return procurementRequest;
    }

    public void setProcurementRequest(ProcurementRequestEntity procurementRequest) {
        if (procurementRequest == null)
            throw new RuntimeException("Procurement Request is null");
        procurementRequest.setProcurement(this);
        this.procurementRequest = procurementRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


    public OperatorEntity getOperator() {
        return operator;
    }

    public void setOperator(OperatorEntity operator) {
        this.operator = operator;
    }
}
