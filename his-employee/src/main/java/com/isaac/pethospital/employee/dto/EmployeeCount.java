package com.isaac.pethospital.employee.dto;

public class EmployeeCount {

    public EmployeeCount(long count) {
        this.count = count;
    }


    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
