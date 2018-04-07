package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.employee.dto.EmployeeCount;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import com.isaac.pethospital.employee.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/counts")
    public EmployeeCount getTotalCounts() {
        long count = this.employeeService.getTotalCounts();
        return new EmployeeCount(count);
    }

    @GetMapping(value = "/getMyInfo")
    public EmployeeEntity getMyInfo() {
        return this.employeeService.getMyInfo();

    }

    @GetMapping("/{uuid}/")
    public EmployeeEntity getEmployeeInfoByEmployeeUuidId(@PathVariable("uuid") String uuid) {
        return this.employeeService.getEmployeeByUuid(uuid);
    }

    @PostMapping(value = "/create")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employee) {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping(value = "/{userAccount}/manager")
    public String getDirectManagerUserAccount(@PathVariable("userAccount") String userAccount) {
        return "linghuchong";
    }

    @PostMapping(value = "/find-by-title")
    public String findByTitle(@RequestBody EmployeeOperationRequest request) {
        if (request.getSearchByTitle().equals("总经理"))
            return "yuelingshan";
        else if(request.getSearchByTitle().equals("采购部"))
            return "guojing";
        else
            return "";
    }
    @GetMapping(value="/find-by-userAccount/{userAccount}")
    public EmployeeOperationRequest findUserNameByUserAccount(@PathVariable("userAccount") String userAccount)
    {
        return this.employeeService.findUserNameByUserAccount(userAccount);
    }


}
