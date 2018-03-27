package com.isaac.pethospital.common.enums;

public enum GenderEnum {

    MALE("男"),
    FEMALE("女");

    GenderEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
