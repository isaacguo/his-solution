package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.employee.enums.EmploymentStatusEnum;
import com.isaac.pethospital.employee.enums.MaritalStatusEnum;
import com.isaac.pethospital.employee.enums.SexualEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class EmployeeEntity {

    String uuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String loginAccount;
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

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    private String workPhoneNumber;
    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;
    private LocalDateTime joinedDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference("employee-contact")
    private ContactAddressEntity contactAddress;
    private String jobTitle;
    private EmploymentStatusEnum employmentStatus;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference("employee-leave")
    private List<LeaveEntity> leaves = new LinkedList<>();
    @ManyToOne()
    @JsonBackReference("directReportTo-teamMembers")
    private EmployeeEntity directReportTo;
    @OneToMany(mappedBy = "directReportTo")
    @JsonManagedReference("directReportTo-teamMembers")
    private List<EmployeeEntity> teamMembers=new LinkedList<>();
    @ManyToOne
    @JsonBackReference("DepartmentEntity-EmployeeEntity")
    private DepartmentEntity department;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public SexualEnum getGender() {
        return gender;
    }

    public void setGender(SexualEnum gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MaritalStatusEnum getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public ContactAddressEntity getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(ContactAddressEntity contactAddress) {
        if (contactAddress == null)
            throw new RuntimeException("ContactAddress should not be null");
        else {
            this.contactAddress=contactAddress;
            this.contactAddress.setEmployeeEntity(this);
        }
        this.contactAddress = contactAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public EmploymentStatusEnum getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatusEnum employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public List<LeaveEntity> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<LeaveEntity> leaves) {
        this.leaves = leaves;
    }

    public EmployeeEntity getDirectReportTo() {
        return directReportTo;
    }

    public void setDirectReportTo(EmployeeEntity directReportTo) {
        this.directReportTo = directReportTo;
    }

    public List<EmployeeEntity> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<EmployeeEntity> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }


}
