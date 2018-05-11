package com.isaac.pethospital.common.enums;

public enum PetColorEnum {

    WHITE("白"),
    BLACK("黑"),
    LIGHTYELLOW("浅黄"),
    YELLOW("黄"),
    RED("红"),
    GREEN("绿");


    PetColorEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
