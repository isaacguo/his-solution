package com.isaac.pethospital.finance.dtos;

import java.util.LinkedList;
import java.util.List;

public class ChargeOperationRequest {

    String chargeItemUuid;
    String fromService;
    Long normalPrice; //普通价格
    Long memberPrice; //会员价格
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
