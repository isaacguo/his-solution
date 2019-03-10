package com.isaac.pethospital.medicaltest.enums;

public enum ReportStatusEnum {

    UNSUBMITTED("UNSUBMITTED"),
    UNPAID("UNPAID"),
    PAID("PAID"),
    TESTING("TESTING"),
    FINISHED("FINISHED");

    ReportStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
