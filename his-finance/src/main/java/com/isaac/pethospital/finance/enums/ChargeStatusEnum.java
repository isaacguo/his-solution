package com.isaac.pethospital.finance.enums;

public enum ChargeStatusEnum {

    UNPAID("UNPAID"),
    PAID("PAID"),
    REIMBURSED("REIMBURSED");


    ChargeStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }

}
