package com.isaac.pethospital.employee.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ContactAddressEntity {

    @Id
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
