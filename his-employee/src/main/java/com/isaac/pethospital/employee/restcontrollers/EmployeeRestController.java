package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.employee.dto.EmployeeCount;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import com.isaac.pethospital.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/counts")
    public EmployeeCount getTotalCounts()
    {
         long count=this.employeeService.getTotalCounts();
         return new EmployeeCount(count);
    }
    @GetMapping(value = "/getMyInfo")
    public EmployeeEntity getMyInfo()
    {
        return this.employeeService.getMyInfo();

    }

    @GetMapping("/{uuid}/")
    public EmployeeEntity getEmployeeInfoByEmployeeUuidId(@PathVariable("uuid") String uuid)
    {
        return this.employeeService.getEmployeeByUuid(uuid);
    }

    @PostMapping(value = "/create")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee)
    {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees()
    {
        return this.employeeRepository.findAll();
    }
}
