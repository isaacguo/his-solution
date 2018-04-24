package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
     long getTotalCounts();

    EmployeeEntity getEmployeeById(long id);
    EmployeeEntity createEmployee(EmployeeOperationRequest request);

    EmployeeEntity getMyInfo();

    EmployeeEntity getEmployeeByUuid(String uuid);
    List<String> getOrganizationNames();
    List<String> getSupportedRelationships();

    EmployeeOperationRequest findUserNameByUserAccount(String userAccount);

    List<EmployeeEntity> findAll();

    boolean deleteEmployee(EmployeeOperationRequest employeeOperationRequest);

    boolean updateEmployee(EmployeeOperationRequest employeeOperationRequest);

    EmployeeEntity findBySurnameAndGivenName(EmployeeOperationRequest employeeOperationRequest);

    boolean setReportTo(Long employeeId, Long managerId);

    List<EmployeeEntity> findKeywordInName(String any);

    List<EmployeeListItem> findEmployeesForEmployeeListItem();

    String getDirectManagerUserAccount(String userAccount);

    Long getDepartmentId(String userAccount);

    List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(Long departmentId);
}
