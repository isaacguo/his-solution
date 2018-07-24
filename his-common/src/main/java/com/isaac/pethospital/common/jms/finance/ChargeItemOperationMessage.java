package com.isaac.pethospital.common.jms.finance;

import com.isaac.pethospital.common.enums.ChargeEventEnum;

import java.util.LinkedList;
import java.util.List;

public class ChargeItemOperationMessage {

    ChargeEventEnum chargeEventEnum;

    private String treatmentCaseUuid;
    private List<String> reportUuid=new LinkedList<>();


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

    public List<String> getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(List<String> reportUuid) {
        this.reportUuid = reportUuid;
    }

    public void addReportUuid(String reportUuid) {
        this.reportUuid.add(reportUuid);
    }
}
