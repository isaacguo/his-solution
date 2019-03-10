package com.isaac.pethospital.treatment.dtos;

public class CommentOperationRequest {

    String content;
    String treatmentCaseUuid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }
}
