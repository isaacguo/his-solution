package com.isaac.pethospital.finance.dtos;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class PriceOperationRequest {

    String priceItemUuid;
    String fromService;
    BigDecimal normalPrice; //普通价格
    BigDecimal memberPrice; //会员价格
    Long id;

    List<String> uuids = new LinkedList<>();
    String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
