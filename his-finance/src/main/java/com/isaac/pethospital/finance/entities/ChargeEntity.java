package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ChargeEntity {

    String chargeItemUuid;
    String fromService;
    Long normalPrice; //普通价格
    Long memberPrice; //会员价格
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonBackReference("ChargeCategoryEntity-ChargeEntity")
    private ChargeCategoryEntity chargeCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChargeItemUuid() {
        return chargeItemUuid;
    }

    public void setChargeItemUuid(String chargeItemUuid) {
        this.chargeItemUuid = chargeItemUuid;
    }

    public String getFromService() {
        return fromService;
    }

    public void setFromService(String fromService) {
        this.fromService = fromService;
    }

    public Long getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Long normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Long getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Long memberPrice) {
        this.memberPrice = memberPrice;
    }

    public ChargeCategoryEntity getChargeCategory() {
        return chargeCategory;
    }

    public void setChargeCategory(ChargeCategoryEntity chargeCategory) {
        this.chargeCategory = chargeCategory;
    }


}
