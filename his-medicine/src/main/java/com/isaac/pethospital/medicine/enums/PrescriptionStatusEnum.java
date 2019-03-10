package com.isaac.pethospital.medicine.enums;

public enum PrescriptionStatusEnum {


    UNSUBMITTED("UNSUBMITTED"),
    UNPAID("UNPAID"),
    PAID("PAID"),
    WITHDREW("WITHDREW"),
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
