package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.EnumMap;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findByLoginAccount(String userAccount);

    EmployeeEntity findBySurnameAndGivenName(String surname, String givenName);

    EmployeeEntity findByUuid(String uuid);

    //List<EmployeeEntity> findDistinctByFullNameContains(String keyword);
    List<EmployeeEntity> findDistinctByFullNameHanYuPinYinContains(String keyword);


    @Query("select e.loginAccount as loginAccount, e.uuid as uuid, e.jobTitle as jobTitle, e.employeeNumber as employeeNumber, e.workPhoneNumber as workPhoneNumber, e.fullName as fullName, e.gender as gender, r.fullName as directReportTo, d.name as departmentName from EmployeeEntity e join e.department d join e.directReportTo r ")
    List<EmployeeListItem> findEmployeesForEmployeeListItem();


    @Query("select r.fullName as directReportTo, e.loginAccount as loginAccount, e.id as id, e.uuid as uuid, e.jobTitle as jobTitle, e.employeeNumber as employeeNumber, e.workPhoneNumber as workPhoneNumber, e.fullName as fullName, e.gender as gender,  d.name as departmentName from EmployeeEntity e join e.department d join e.directReportTo r where d.id=:departmentId ")
    List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("select e from EmployeeEntity e where e.department =null and e.directReportTo=null")
    EmployeeEntity getSentinelEmployee();
}
