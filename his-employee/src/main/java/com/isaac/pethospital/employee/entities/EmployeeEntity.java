package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaac.pethospital.employee.common.MaritalStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String givenName;
    private String surname;
    @ManyToOne
    @JsonBackReference("DepartmentEntity-EmployeeEntity")
    private DepartmentEntity department;
    private String gender;
    private String employeeNumber;
    private String phoneNumber;
    private String officeNumber;

    //private EmployeeEntity reportTo;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    private String nationality;
    private String driverLicense;

    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;

    @OneToOne
    private SalaryEntity salary;

}
