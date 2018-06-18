package com.isaac.pethospital.medicaltest.enums;

public enum ReportSectionEnum {

    HEADER("HEADER"),
    FOOT("FOOT");

    ReportSectionEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
