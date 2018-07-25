package com.isaac.pethospital.common.jms.finance;

import com.isaac.pethospital.common.enums.ChargeEventEnum;

import java.util.LinkedList;
import java.util.List;

public class ChargeReportOperationMessage {

    ChargeEventEnum chargeEventEnum;

    private String treatmentCaseUuid;
    private String petOwnerUuid;
    private String petUuid;
    private List<ReportOperationMessage> reportOperationMessages = new LinkedList<>();


    public ChargeEventEnum getChargeEventEnum() {
        return chargeEventEnum;
    }

    public void setChargeEventEnum(ChargeEventEnum chargeEventEnum) {
        this.chargeEventEnum = chargeEventEnum;
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

    public List<ReportOperationMessage> getReportOperationMessages() {
        return reportOperationMessages;
    }

    public void addReportOperationMessages(ReportOperationMessage reportOperationMessage) {
        this.reportOperationMessages.add(reportOperationMessage);
    }
}
