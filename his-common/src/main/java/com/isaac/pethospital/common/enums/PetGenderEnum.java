package com.isaac.pethospital.common.enums;

public enum PetGenderEnum {

    MALE("公"),
    FEMALE("母");

    PetGenderEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
