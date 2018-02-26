package com.isaac.pethospital.employee.enums;

public enum  MaritalStatusEnum {


    SINGLE("未婚"),
    MARRIED("已婚");

    MaritalStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
