package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;
    EmployeeTypeRepository employeeTypeRepository;
    DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeTypeRepository employeeTypeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeOperationRequest employeeOperationRequest) {

        DepartmentEntity departmentEntity = checkDepartment(employeeOperationRequest);

        EmployeeEntity employeeEntity = employeeOperationRequest.toEmployee();
        employeeEntity.setDepartment(departmentEntity);

        return this.employeeRepository.save(employeeOperationRequest.toEmployee());
    }

    @Override
    public void deleteEmployee(EmployeeOperationRequest employeeOperationRequest) {
        if (this.employeeRepository.exists(employeeOperationRequest.getId()))
            this.employeeRepository.delete(employeeOperationRequest.getId());
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeOperationRequest employeeOperationRequest) {
        if (!this.employeeRepository.exists(employeeOperationRequest.getId()))
            throw new RuntimeException("Employee doesn't exist");

        EmployeeEntity employeeEntity = this.employeeRepository.findOne(employeeOperationRequest.getId());
        employeeEntity.setName(employeeOperationRequest.getName());
        return this.employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> findByName(EmployeeOperationRequest employeeOperationRequest) {
        return this.employeeRepository.findByName(employeeOperationRequest.getName());
    }

    @Override
    public List<EmployeeEntity> findByDepartment(EmployeeOperationRequest employeeOperationRequest) {
        DepartmentEntity departmentEntity = checkDepartment(employeeOperationRequest);
        return this.employeeRepository.findByDepartment(departmentEntity);
    }

    @Override
    public List<EmployeeEntity> findByEmployeeType(EmployeeOperationRequest employeeOperationRequest) {
        EmployeeTypeEntity employeeTypeEntity = checkEmployeeType(employeeOperationRequest);
        return this.employeeRepository.findByEmployeeType(employeeTypeEntity);
    }

    @Override
    public EmployeeEntity findByLoginAccount(String loginAccount) {
        EmployeeEntity employeeEntity = this.employeeRepository.findByLoginAccount(loginAccount);
        if (employeeEntity == null)
            throw new RuntimeException("The Employee with loginAccount: " + loginAccount + " cannot be found");
        return employeeEntity;
    }

    @Override
    public boolean setCanBeRegisteredValue(EmployeeOperationRequest request) {
        DepartmentEntity de=checkDepartment(request);
        EmployeeEntity ee = employeeRepository.findByEmpId(request.getEmpId());
        if (ee == null) {
            ee = new EmployeeEntity();
            ee.setEmpId(request.getEmpId());
            ee.setLoginAccount(request.getLoginAccount());
            ee.setName(request.getName());
            ee.setLoginAccount(request.getLoginAccount());
            ee.setDepartment(de);
        }
        ee.setCanBeRegistered(request.isCanBeRegistered());
        employeeRepository.save(ee);
        return true;
    }

    @Override
    public EmployeeEntity findByEmpId(Long empId) {
        EmployeeEntity ee = this.employeeRepository.findByEmpId(empId);
        if (ee == null)
            return new EmployeeEntity();
        else
            return ee;
    }

    @Override
    public List<EmployeeEntity> findByDepartmentAndCanBeRegisteredIsTrue(EmployeeOperationRequest employeeOperationRequest) {
        DepartmentEntity departmentEntity = checkDepartment(employeeOperationRequest);
        return this.employeeRepository.findByDepartmentAndCanBeRegisteredIsTrue(departmentEntity);
    }

    private EmployeeTypeEntity checkEmployeeType(EmployeeOperationRequest employeeOperationRequest) {
        if (employeeOperationRequest.getEmployeeTypeId() == null)
            throw new RuntimeException("No EmployeeType Info.");
        EmployeeTypeEntity employeeTypeEntity = employeeTypeRepository.findOne(employeeOperationRequest.getEmployeeTypeId());
        if (employeeTypeEntity == null)
            throw new RuntimeException("Cannot Find EmployeeType.");
        return employeeTypeEntity;
    }

    private DepartmentEntity checkDepartment(EmployeeOperationRequest employeeOperationRequest) {
        if (employeeOperationRequest.getDepartmentId() == null)
            throw new RuntimeException("No Department Info.");
        DepartmentEntity departmentEntity = departmentRepository.findByDepId(employeeOperationRequest.getDepartmentId());
        if (departmentEntity == null)
            throw new RuntimeException("Cannot Find Department.");
        return departmentEntity;
    }
}
