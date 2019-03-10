package com.isaac.pethospital.common.enums;

public enum ChargeEventEnum {

    CREATED("CREATED");

    ChargeEventEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
