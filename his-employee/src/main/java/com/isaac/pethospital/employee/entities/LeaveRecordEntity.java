package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class LeaveRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @ManyToOne
    @JsonBackReference("employee-leaverecords")
    private EmployeeEntity employee;

}
