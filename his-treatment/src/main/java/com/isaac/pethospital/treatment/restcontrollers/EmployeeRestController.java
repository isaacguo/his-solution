package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {

    EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("find-by-employee-type")
    public List<EmployeeEntity> findByEmployeeType(@RequestBody EmployeeOperationRequest employeeOperationRequest) {
        return this.employeeService.findByEmployeeType(employeeOperationRequest);
    }

    @PostMapping("find-by-department")
    public List<EmployeeEntity> findByDepartment(@RequestBody EmployeeOperationRequest employeeOperationRequest) {
        return this.employeeService.findByDepartment(employeeOperationRequest);
    }

    @PostMapping("find-by-department-and-can-be-registered")
    public List<EmployeeEntity> findByOpenToFrontDeskDepartment(@RequestBody EmployeeOperationRequest employeeOperationRequest) {
        return this.employeeService.findByDepartmentAndCanBeRegisteredIsTrue(employeeOperationRequest);
    }

    @GetMapping("findByEmpId/{empId}")
    public EmployeeEntity findByEmpId(@PathVariable("empId") Long empId)
    {
        return this.employeeService.findByEmpId(empId);
    }

    @PostMapping("setCanBeRegisteredValue")
    public boolean setCanBeRegisteredValue(@RequestBody EmployeeOperationRequest request)
    {
        return this.employeeService.setCanBeRegisteredValue(request);
    }

}
