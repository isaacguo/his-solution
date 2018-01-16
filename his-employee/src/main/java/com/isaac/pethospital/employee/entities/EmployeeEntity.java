package com.isaac.pethospital.employee.entities;

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
    private String department;
    private String gender;
    private String employeeNumber;
    private String phoneNumber;
    private String officeNumber;
    
    //private EmployeeEntity reportTo;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    @OneToOne
    private SalaryEntity salary;

}
