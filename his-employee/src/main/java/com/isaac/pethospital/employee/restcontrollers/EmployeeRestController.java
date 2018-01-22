package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.employee.dto.EmployeeCount;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import com.isaac.pethospital.employee.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Data
@AllArgsConstructor
public class EmployeeRestController {


    private final EmployeeService employeeService;


    private final EmployeeRepository employeeRepository;

    @GetMapping("/counts")
    public EmployeeCount getTotalCounts()
    {
         long count=this.employeeService.getTotalCounts();
         return new EmployeeCount(count);
    }


    @GetMapping
    public List<EmployeeEntity> getEmployees()
    {
        return this.employeeRepository.findAll();
    }

}
