package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.dto.EmployeeCount;
import com.isaac.pethospital.employee.dto.EmployeeListItem;
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
    private final AuthHelper authHelper;

    public EmployeeRestController(EmployeeService employeeService, AuthHelper authHelper) {
        this.employeeService = employeeService;
        this.authHelper = authHelper;
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
    public boolean createNewEmployee(@RequestBody EmployeeOperationRequest request) {
        return this.employeeService.createEmployee(request);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteVendor(@PathVariable("id") Long id) {
        return this.employeeService.deleteEmployee(id);
    }


    @PutMapping("update")
    public boolean updateVendor(@RequestBody EmployeeOperationRequest request) {
        return this.employeeService.updateEmployee(request);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/get-department-id/{userAccount}")
    public Long getDepartmentId(@PathVariable("userAccount") String userAccount) {
        return this.employeeService.getDepartmentId(userAccount);

    }

    @GetMapping(value = "/{userAccount}/manager")
    public String getDirectManagerUserAccount(@PathVariable("userAccount") String userAccount) {
        return this.employeeService.getDirectManagerUserAccount(userAccount);
    }

    @PostMapping(value = "/find-by-title")
    public String findByTitle(@RequestBody EmployeeOperationRequest request) {
        if (request.getSearchByTitle().equals("总经理"))
            return "yuelingshan";
        else if (request.getSearchByTitle().equals("采购部"))
            return "guojing";
        else
            return "";
    }

    @GetMapping(value = "/find-by-userAccount/{userAccount}")
    public EmployeeOperationRequest findUserNameByUserAccount(@PathVariable("userAccount") String userAccount) {
        return this.employeeService.findUserNameByUserAccount(userAccount);
    }

    @GetMapping(value = "/search-by-name/{keyword}")
    public List<EmployeeEntity> findEmployeesByKeywordInName(@PathVariable("keyword") String keyword) {
        return this.employeeService.findKeywordInName(keyword);
    }

    @GetMapping(value = "/{departmentId}/employee-list")
    public List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return this.employeeService.findEmployeesForEmployeeListItemByDepartmentId(departmentId);
    }
}
