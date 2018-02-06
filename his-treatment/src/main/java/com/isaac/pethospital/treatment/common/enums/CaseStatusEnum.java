package com.isaac.pethospital.treatment.common.enums;

public enum CaseStatusEnum {

    BOOKED("已预约"),
    UNPRESENTED("未候诊"),
    WAITING("候诊中"),
    CALLED("已过号"),
    FINISHED("已完成"),
    UNFINISHED("未完成");

    CaseStatusEnum(String desc) {

    }

    private String desc;
}
