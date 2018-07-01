package com.isaac.pethospital.treatment.common.enums;

public enum TreatmentCaseStatusEnum {

    BOOKED("已预约"),
    UNPAID("未付款"),
    UNPRESENTED("未候诊"),
    WAITING("等候中"),
    CURING("就诊中"),
    CALLED("已过号"),
    FINISHED("已完成"),
    UNFINISHED("未完成");

    TreatmentCaseStatusEnum(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
