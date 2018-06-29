package com.isaac.pethospital.employee.dto;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.employee.entities.*;
import com.isaac.pethospital.employee.enums.EmploymentStatusEnum;
import com.isaac.pethospital.employee.enums.MaritalStatusEnum;
import com.isaac.pethospital.employee.enums.SexualEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.swing.StringUIClientPropertyKey;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EmployeeOperationRequest {

    Long departmentId;
    //Used By other services(procurement)
    String userAccount;
    String searchByTitle;
    String fullName;
    String password;
    //from EmployeeEntity

    String uuid;

    public HanyuPinyinConverter getConverter() {
        return converter;
    }

    public void setConverter(HanyuPinyinConverter converter) {
        this.converter = converter;
    }

    HanyuPinyinConverter converter;

    private Long id;
    private String loginAccount;
    private String givenName;
    private String surname;
    private String employeeNumber;
    private String idNumber;
    private String driverLicenseNumber;
    private LocalDate dateOfBirth;
    private SexualEnum gender;
    private String nationality;
    private String ethnic;
    private String email;
    private String workPhoneNumber;
    private MaritalStatusEnum maritalStatus;
    private LocalDate joinedDate;
    private ContactAddressEntity contactAddress;
    private String jobTitle;
    private EmploymentStatusEnum employmentStatus;
    private LeaveInfoEntity leaveInfo;
    private List<LeaveRecordEntity> leaveRecords = new LinkedList<>();
    private List<EmployeeEntity> teamMembers = new LinkedList<>();
    private DepartmentEntity department;
    private String emergencyContact;
    private String emergencyPhoneNumber;

    public String getFullNameHanYuPinYin() {
        return fullNameHanYuPinYin;
    }

    public void setFullNameHanYuPinYin(String fullNameHanYuPinYin) {
        this.fullNameHanYuPinYin = fullNameHanYuPinYin;
    }

    private String directReportToFullName;
    private String fullNameHanYuPinYin;

    public String getDirectReportToFullName() {
        return directReportToFullName;
    }

    public void setDirectReportToFullName(String directReportToFullName) {
        this.directReportToFullName = directReportToFullName;
    }

    public static EmployeeOperationRequest convertToDto(EmployeeEntity ee) {
        EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();

        employeeOperationRequest.setId(ee.getId());
        employeeOperationRequest.setLoginAccount(ee.getLoginAccount());
        employeeOperationRequest.setEmployeeNumber(ee.getEmployeeNumber());
        employeeOperationRequest.setEmploymentStatus(ee.getEmploymentStatus());
        employeeOperationRequest.setGivenName(ee.getGivenName());
        employeeOperationRequest.setSurname(ee.getSurname());
        employeeOperationRequest.setIdNumber(ee.getIdNumber());
        employeeOperationRequest.setDriverLicenseNumber(ee.getDriverLicenseNumber());
        employeeOperationRequest.setFullName(ee.getFullName());
        employeeOperationRequest.setFullNameHanYuPinYin(ee.getFullNameHanYuPinYin());
        employeeOperationRequest.setDateOfBirth(ee.getDateOfBirth());
        employeeOperationRequest.setGender(ee.getGender());
        employeeOperationRequest.setNationality(ee.getNationality());
        employeeOperationRequest.setEthnic(ee.getEthnic());
        employeeOperationRequest.setEmail(ee.getEmail());
        employeeOperationRequest.setWorkPhoneNumber(ee.getWorkPhoneNumber());
        employeeOperationRequest.setMaritalStatus(ee.getMaritalStatus());
        employeeOperationRequest.setJoinedDate(ee.getJoinedDate());
        employeeOperationRequest.setJobTitle(ee.getJobTitle());

        if (ee.getDirectReportTo() != null)
            employeeOperationRequest.setDirectReportToFullName(ee.getDirectReportTo().getFullName());


        return employeeOperationRequest;

    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public MaritalStatusEnum getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

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

    public LeaveInfoEntity getLeaveInfo() {
        return leaveInfo;
    }

    public void setLeaveInfo(LeaveInfoEntity leaveInfo) {
        this.leaveInfo = leaveInfo;
    }

    public List<LeaveRecordEntity> getLeaveRecords() {
        return leaveRecords;
    }

    public void setLeaveRecords(List<LeaveRecordEntity> leaveRecords) {
        this.leaveRecords = leaveRecords;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getSearchByTitle() {
        return searchByTitle;
    }

    public void setSearchByTitle(String searchByTitle) {
        this.searchByTitle = searchByTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public EmployeeEntity toEmployeeEntity() {
        EmployeeEntity ee = new EmployeeEntity();
        updateInternal(ee, true);
        return ee;
    }

    public void updateEmployee(EmployeeEntity employee) {
        updateInternal(employee, false);

    }

    private void updateInternal(EmployeeEntity ee, boolean isCreate) {
        ee.setLoginAccount(this.loginAccount);
        ee.setEmployeeNumber(this.employeeNumber);
        ee.setEmploymentStatus(this.employmentStatus);
        ee.setGivenName(this.givenName);
        ee.setSurname(this.surname);
        ee.setIdNumber(this.idNumber);
        ee.setDriverLicenseNumber(this.driverLicenseNumber);
        ee.setFullName(this.surname + this.givenName);
        if (StringUtils.isEmpty(this.fullNameHanYuPinYin))
            ee.setFullNameHanYuPinYin(converter.toHanyuPinyin(ee.getFullName()));
        else
            ee.setFullNameHanYuPinYin(this.fullNameHanYuPinYin);
        ee.setDateOfBirth(this.dateOfBirth);
        ee.setGender(this.gender);
        ee.setNationality(this.nationality);
        ee.setEthnic(this.ethnic);
        ee.setEmail(this.email);
        ee.setWorkPhoneNumber(this.workPhoneNumber);
        ee.setMaritalStatus(this.maritalStatus);
        ee.setJoinedDate(this.joinedDate);
        ee.setJobTitle(this.jobTitle);

    }
}
