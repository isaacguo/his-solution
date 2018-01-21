package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.employee.common.EmploymentStatusEnum;
import com.isaac.pethospital.employee.common.MaritalStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String givenName;
    private String surname;
    private String employeeNumber;
    private String idNumber;
    private String driverLicenseNumber;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String ethnic;
    private String email;
    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;
    private Date joinedDate;

    @OneToOne
    private ContactAddressEntity contactAddress;


    private String jobTitle;
    private EmploymentStatusEnum employmentStatus;

    @ManyToOne()
    @JsonBackReference("directReportTo-teamMembers")
    private EmployeeEntity directReportTo;

    @OneToMany(mappedBy = "directReportTo")
    @JsonManagedReference("directReportTo-teamMembers")
    private List<EmployeeEntity> teamMembers;

    @ManyToOne
    @JsonBackReference("DepartmentEntity-EmployeeEntity")
    private DepartmentEntity department;


    private String emergencyContact;
    private String emergencyPhoneNumber;


}
