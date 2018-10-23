package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.dto.*;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import com.isaac.pethospital.employee.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;
    private final AuthHelper authHelper;

    public DepartmentRestController(DepartmentService departmentService, AuthHelper authHelper) {
        this.departmentService = departmentService;
        this.authHelper = authHelper;
    }

    @GetMapping
    public List<DepartmentEntity> getDepartments() {
        List<DepartmentEntity> all = this.departmentService.findAll();
        return all;
    }
    @GetMapping("{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") Long id)
    {
        return this.departmentService.findById(id);
    }

    @GetMapping("root")
    public MyDepartmentIdAndNameAndChildren findRootDepartment() {
        return this.departmentService.findRootDepartment();
    }


    @GetMapping("brief")
    public List<DepartmentIdAndName> findIndexAndNameOnly() {
        return this.departmentService.findIndexAndNameOnly();
    }


    @PostMapping("create-department")
    public boolean createDepartment(@RequestBody DepartmentOperationRequest request) {
        return this.departmentService.createDepartment(request);
    }

    @DeleteMapping("delete-department/{id}")
    public boolean deleteDepartment(@PathVariable("id") Long id) {
        return this.departmentService.deleteDepartment(id);
    }

    @PutMapping("rename-department")
    public boolean renameDepartment(@RequestBody DepartmentOperationRequest request) {
        return this.departmentService.renameDepartment(request);
    }

    @GetMapping("find-manager/{depId}")
    public EmployeeListItem findManager(@PathVariable("depId") Long depId) {
        return this.departmentService.findManager(depId);
    }
}
