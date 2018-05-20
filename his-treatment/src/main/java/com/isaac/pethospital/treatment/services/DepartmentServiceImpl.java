package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.EmployeeListItem;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.feignservices.EmployeeFeignService;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeFeignService employeeFeignService;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, EmployeeFeignService employeeFeignService) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.employeeFeignService=employeeFeignService;
    }

    @Override
    public List<DepartmentEntity> getOpenToFrontDeskDepartments() {
        return this.departmentRepository.findByOpenToFrontDeskIsTrue();
    }


    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        String uuid = UUID.randomUUID().toString();
        //departmentEntity.setUuid(uuid);
        return this.departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity getDepartmentByDepId(Long depId) {
        DepartmentEntity de = this.departmentRepository.findByDepId(depId);
        if (de != null)
            return de;
        else {
            DepartmentEntity newDe = new DepartmentEntity();
            newDe.setDepId(depId);
            return newDe;
        }
    }

    @Override
    public boolean setDepartmentOpenToFrontDeskValue(DepartmentEntity department) {
        DepartmentEntity de = this.departmentRepository.findByDepId(department.getDepId());
        if (de == null)
            de = new DepartmentEntity();
        de.setOpenToFrontDesk(department.isOpenToFrontDesk());
        de.setDepId(department.getDepId());
        de.setName(department.getName());
        this.departmentRepository.save(de);
        return true;
    }

    @Override
    public List<EmployeeEntity> getEmployeesByDepartmentId(Long depId) {
         this.employeeFeignService.findEmployeesForEmployeeListItemByDepartmentId(depId);
         return null;
    }
}
