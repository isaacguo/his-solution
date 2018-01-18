package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Data
public class EmployeeRestController {


    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeEntity> getEmployees()
    {
        return this.employeeRepository.findAll();
    }

}
