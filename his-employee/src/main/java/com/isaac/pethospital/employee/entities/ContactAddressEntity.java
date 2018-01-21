package com.isaac.pethospital.employee.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity
@Data
public class ContactAddressEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String country;
    private String city;
    private String district;
    private String address;
    private String post;
    private String homePhone;
    private String workPhone;

    private String mobilePhone;

    @OneToOne
    private EmployeeEntity employeeEntity;

}
