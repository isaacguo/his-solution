package com.isaac.pethospital.medicine.enums;

public enum DispenseStatusEnum {

    UNPAID("UNPAID"),
    PAID("PAID"),
    DISPENSED("DISPENSED"),
    UNDISPENSED("UNDISPENSED");

    DispenseStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
