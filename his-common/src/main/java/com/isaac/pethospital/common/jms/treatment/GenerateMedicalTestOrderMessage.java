package com.isaac.pethospital.common.jms.treatment;

public class GenerateMedicalTestOrderMessage {
    String treatmentCaseUuid;

    public GenerateMedicalTestOrderMessage() {
    }

    public GenerateMedicalTestOrderMessage(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }
}
