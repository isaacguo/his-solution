package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PriceEntity {

    String priceItemUuid;
    String fromService;
    BigDecimal normalPrice; //普通价格
    BigDecimal memberPrice; //会员价格
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonBackReference("PriceCategoryEntity-PriceEntity")
    private PriceCategoryEntity chargeCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriceItemUuid() {
        return priceItemUuid;
    }

    public void setPriceItemUuid(String priceItemUuid) {
        this.priceItemUuid = priceItemUuid;
    }

    public String getFromService() {
        return fromService;
    }

    public void setFromService(String fromService) {
        this.fromService = fromService;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public PriceCategoryEntity getChargeCategory() {
        return chargeCategory;
    }

    public void setChargeCategory(PriceCategoryEntity chargeCategory) {
        this.chargeCategory = chargeCategory;
    }


}
