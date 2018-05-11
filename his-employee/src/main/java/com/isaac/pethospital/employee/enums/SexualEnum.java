package com.isaac.pethospital.employee.enums;

public enum SexualEnum {

    MALE("男"),
    FEMALE("女");

    SexualEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
