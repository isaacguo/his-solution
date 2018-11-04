package com.isaac.pethospital.gateway.dtos;

public class BackupData {

    String scheduleType;
    int hourValue;

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public int getHourValue() {
        return hourValue;
    }

    public void setHourValue(int hourValue) {
        this.hourValue = hourValue;
    }
}
