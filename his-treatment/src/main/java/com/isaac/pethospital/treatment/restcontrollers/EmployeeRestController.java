package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
