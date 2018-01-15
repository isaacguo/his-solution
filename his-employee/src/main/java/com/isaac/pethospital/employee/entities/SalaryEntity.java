package com.isaac.pethospital.employee.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long baseSalary;
    private long bonus;

    @OneToOne
    EmployeeEntity employee;
}
