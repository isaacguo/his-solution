package com.isaac.pethospital.employee.enums;

public enum LeaveTypeEnum {

    SICK_LEAVE("病假"),
    ANNUAL_LEAVE("年假");

    LeaveTypeEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }


}
