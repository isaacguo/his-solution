package com.isaac.pethospital.common.enums;

public enum  OperationEnum {

    CREATE("CREATE"),
    DELETE("DELETE"),
    UPDATE("UPDATE");

    OperationEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }


}
