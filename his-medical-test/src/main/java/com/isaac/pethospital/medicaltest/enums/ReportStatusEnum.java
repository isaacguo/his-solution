package com.isaac.pethospital.medicaltest.enums;

public enum ReportStatusEnum {

    CREATED("已创建"),
    PAID("已付款"),
    FINISHED("已完成");

    ReportStatusEnum(String text) {
        this.text =text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

    }
