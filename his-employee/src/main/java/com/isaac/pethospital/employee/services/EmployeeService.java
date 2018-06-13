package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
     long getTotalCounts();

    EmployeeEntity getEmployeeById(long id);
    boolean createEmployee(EmployeeOperationRequest request);

    EmployeeOperationRequest getMyInfo();

    EmployeeOperationRequest getEmployeeByUuid(String uuid);
    List<String> getOrganizationNames();
    List<String> getSupportedRelationships();

    EmployeeOperationRequest findUserNameByUserAccount(String userAccount);

    List<EmployeeEntity> findAll();

    boolean deleteEmployee(Long id );

    boolean updateEmployee(EmployeeOperationRequest employeeOperationRequest);

    EmployeeEntity findBySurnameAndGivenName(EmployeeOperationRequest employeeOperationRequest);

    boolean setReportTo(Long employeeId, Long managerId);

    List<EmployeeEntity> findKeywordInName(String any);

    List<EmployeeListItem> findEmployeesForEmployeeListItem();

    String getDirectManagerUserAccount(String userAccount);

    Long getDepartmentId(String userAccount);

    List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(Long departmentId);

    EmployeeOperationRequest findUserNameByLoginAccount(String loginAccount);

    boolean updateLoginAccount(EmployeeOperationRequest request);

    boolean updatePassword(EmployeeOperationRequest request);

    boolean moveEmployeeToDepartment(Long empId, Long depId);

    boolean setAsManager(Long id);
}
