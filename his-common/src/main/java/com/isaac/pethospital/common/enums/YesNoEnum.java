package com.isaac.pethospital.common.enums;

public enum YesNoEnum {
    YES("是"),
    NO("否");

    YesNoEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
