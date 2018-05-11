package com.isaac.pethospital.employee.enums;

public enum EmploymentStatusEnum {


    FULL_TIME("全职"),
    PART_TIME("兼职"),
    INTERN("实习"),
    RE_EMPLOY_AFTER_RETIRMENT("返聘"),
    OUTSOURCE("外包");

    EmploymentStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
