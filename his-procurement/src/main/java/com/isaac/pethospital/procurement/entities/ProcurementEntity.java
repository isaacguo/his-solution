package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProcurementEntity {

    String orderNumber; //单号
    @ManyToOne
    VendorEntity vendor;
    @ManyToOne
    OperatorEntity operator;
    @ManyToOne
    ProcurementStatusEntity status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ProcurementStatusEntity getStatus() {
        return status;
    }

    public void setStatus(ProcurementStatusEntity status) {
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

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }


    public OperatorEntity getOperator() {
        return operator;
    }

    public void setOperator(OperatorEntity operator) {
        this.operator = operator;
    }
}
