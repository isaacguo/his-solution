package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class LeaveInfoEntity {

    @OneToOne
    @JsonBackReference("employee-leaveInfo")
    EmployeeEntity employee;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long anuualLeave;
    private long sickLeave;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public long getAnuualLeave() {
        return anuualLeave;
    }

    public void setAnuualLeave(long anuualLeave) {
        this.anuualLeave = anuualLeave;
    }

    public long getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(long sickLeave) {
        this.sickLeave = sickLeave;
    }
}
