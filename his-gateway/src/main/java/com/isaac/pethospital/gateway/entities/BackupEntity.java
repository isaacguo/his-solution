package com.isaac.pethospital.gateway.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BackupEntity {

    String scheduleType;
    int hourValue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public int getHourValue() {
        return hourValue;
    }

    public void setHourValue(int hourValue) {
        this.hourValue = hourValue;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }
}
