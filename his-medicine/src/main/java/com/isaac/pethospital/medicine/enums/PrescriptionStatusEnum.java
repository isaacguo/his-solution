package com.isaac.pethospital.medicine.enums;

public enum PrescriptionStatusEnum {

    UNPAID("UNPAID"),
    PAID("PAID"),
    DISPENSED("DISPENSED"),
    UNDISPENSED("UNDISPENSED");

    PrescriptionStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
