package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.dto.EmployeeCount;
import com.isaac.pethospital.employee.dto.EmployeeListItem;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
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
    public EmployeeOperationRequest getMyInfo() {
        return this.employeeService.getMyInfo();

    }

    @GetMapping("/{uuid}/")
    public EmployeeOperationRequest getEmployeeInfoByEmployeeUuidId(@PathVariable("uuid") String uuid) {
        return this.employeeService.getEmployeeByUuid(uuid);
    }

    @PostMapping(value = "/create")
    public boolean createNewEmployee(@RequestBody EmployeeOperationRequest request) {
        return this.employeeService.createEmployee(request);
    }
    @PutMapping(value = "/updateLoginAccount")
    public boolean updateLoginAccount(@RequestBody EmployeeOperationRequest request) {
        return this.employeeService.updateLoginAccount(request);
    }

    @PutMapping(value = "/updatePassword")
    public boolean updatePassword(@RequestBody EmployeeOperationRequest request) {
        return this.employeeService.updatePassword(request);
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
    public List<EmployeeListItem> getEmployees() {
        return this.employeeService.findEmployeesForEmployeeListItem();
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
        return this.employeeService.findByTitle(request);

    }

    @GetMapping(value = "/find-by-loginAccount/{loginAccount}")
    public EmployeeOperationRequest findUserNameByLoginAccount(@PathVariable("loginAccount") String loginAccount) {
        return this.employeeService.findUserNameByLoginAccount(loginAccount);
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

    @PutMapping(value = "/move-employee-to-department")
    public boolean moveEmployeeToDepartment(@RequestBody EmployeeOperationRequest request)
    {
       return this.employeeService.moveEmployeeToDepartment(request.getId(), request.getDepartmentId());
    }

    @PutMapping(value="/set-as-manager")
    public boolean setAsManager(@RequestBody EmployeeOperationRequest request)
    {
       return this.employeeService.setAsManager(request.getId());
    }

}
