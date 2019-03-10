package com.isaac.pethospital.common.jms.finance;

import com.isaac.pethospital.common.enums.ChargeStatusEnum;

import java.util.LinkedList;
import java.util.List;

public class ChargeOrderStatusChangedMessage {

    ChargeStatusEnum previousStatus;
    ChargeStatusEnum newStatus;

    String chargeUuid;
    String treatmentCaseUuid;
    String petOwnerUuid;
    String petUuid;
    String fromService;
    String requestUuidFromService;
    List<String> chargeItemUuid=new LinkedList<>() ;

    public String getRequestUuidFromService() {
        return requestUuidFromService;
    }

    public void setRequestUuidFromService(String requestUuidFromService) {
        this.requestUuidFromService = requestUuidFromService;
    }

    public ChargeStatusEnum getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(ChargeStatusEnum previousStatus) {
        this.previousStatus = previousStatus;
    }

    public ChargeStatusEnum getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(ChargeStatusEnum newStatus) {
        this.newStatus = newStatus;
    }

    public String getChargeUuid() {
        return chargeUuid;
    }

    public void setChargeUuid(String chargeUuid) {
        this.chargeUuid = chargeUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public String getPetOwnerUuid() {
        return petOwnerUuid;
    }

    public void setPetOwnerUuid(String petOwnerUuid) {
        this.petOwnerUuid = petOwnerUuid;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getFromService() {
        return fromService;
    }

    public void setFromService(String fromService) {
        this.fromService = fromService;
    }

    public List<String> getChargeItemUuid() {
        return chargeItemUuid;
    }

    public void setChargeItemUuid(List<String> chargeItemUuid) {
        this.chargeItemUuid = chargeItemUuid;
    }
}
