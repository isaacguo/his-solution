package com.isaac.pethospital.common.jms.finance;

import com.isaac.pethospital.common.enums.ChargeStatusEnum;

import java.util.LinkedList;
import java.util.List;

public class ChargeReportOperationReplyMessage {

    private String treatmentCaseUuid;
    private String petOwnerUuid;
    private String petUuid;
    private List<String> reportUuidList=new LinkedList<>();
    private ChargeStatusEnum status;

    public List<String> getReportUuidList() {
        return reportUuidList;
    }

    public void setReportUuidList(List<String> reportUuidList) {
        this.reportUuidList = reportUuidList;
    }

    public void addReportUuidList(String reportUuid) {
        this.reportUuidList.add(reportUuid);
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

    public ChargeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ChargeStatusEnum status) {
        this.status = status;
    }
}
