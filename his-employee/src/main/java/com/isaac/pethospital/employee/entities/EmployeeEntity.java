package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.isaac.pethospital.employee.enums.EmploymentStatusEnum;
import com.isaac.pethospital.employee.enums.MaritalStatusEnum;
import com.isaac.pethospital.employee.enums.SexualEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class EmployeeEntity {

    //employee info
    private String employeeNumber;
    private String loginAccount;
    private LocalDate joinedDate;
    private String jobTitle;
    private String workPhoneNumber;
    private EmploymentStatusEnum employmentStatus;

    //personal info
    private String givenName;
    private String surname;
    private String fullName;


    String uuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String idNumber;
    private String driverLicenseNumber;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private SexualEnum gender;
    private String nationality;
    private String ethnic;
    private String email;

    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference("employee-contact")
    private ContactAddressEntity contactAddress;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference("employee-leaveInfo")
    private LeaveInfoEntity leaveInfo;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference("employee-leaverecords")
    private List<LeaveRecordEntity> leaveRecords = new LinkedList<>();
    @ManyToOne()
    @JsonBackReference("directReportTo-teamMembers")
    private EmployeeEntity directReportTo;
    @OneToMany(mappedBy = "directReportTo")
    @JsonManagedReference("directReportTo-teamMembers")
    private List<EmployeeEntity> teamMembers = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("DepartmentEntity-EmployeeEntity")
    private DepartmentEntity department;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public List<LeaveRecordEntity> getLeaveRecords() {
        return leaveRecords;
    }

    public void addLeaveRecord(LeaveRecordEntity leaveRecord) {
        if (leaveRecord == null) throw new RuntimeException("Leave Record is null");
        if (leaveRecord != null) {
            leaveRecord.setEmployee(this);
            this.leaveRecords.add(leaveRecord);
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public ContactAddressEntity getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(ContactAddressEntity contactAddress) {
        if (contactAddress == null)
            throw new RuntimeException("ContactAddress should not be null");
        else {
            this.contactAddress = contactAddress;
            this.contactAddress.setEmployeeEntity(this);
        }
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

    public LeaveInfoEntity getLeaveInfo() {
        return leaveInfo;
    }

    public void setLeaveInfo(LeaveInfoEntity leaveInfo) {

        if (leaveInfo == null)
            throw new RuntimeException("Leave info should not be null");
        else {
            this.leaveInfo = leaveInfo;
            this.leaveInfo.setEmployee(this);
        }
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

    public void addTeamMember(EmployeeEntity teamMember) {
        if (teamMember == null)
            throw new RuntimeException("Team member is null");
        teamMember.setDirectReportTo(this);
        this.teamMembers.add(teamMember);
    }

    public void removeTeamMember(EmployeeEntity teamMember) {
        if (teamMember == null)
            throw new RuntimeException("Team member is null");
        this.teamMembers.remove(teamMember);
        teamMember.setDirectReportTo(null);
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
