package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.employee.enums.EmploymentStatusEnum;
import com.isaac.pethospital.employee.enums.MaritalStatusEnum;
import com.isaac.pethospital.employee.enums.SexualEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor()
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String givenName;
    private String surname;
    private String employeeNumber;
    private String idNumber;
    private String driverLicenseNumber;
    private LocalDateTime dateOfBirth;
    @Enumerated(EnumType.STRING)
    private SexualEnum gender;
    private String nationality;
    private String ethnic;
    private String email;
    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;
    private LocalDateTime joinedDate;

    @OneToOne(cascade = CascadeType.ALL)
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
