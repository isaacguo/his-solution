package com.isaac.pethospital.medicine.enums;

public enum PrescriptionStatusEnum {




    PrescriptionStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
