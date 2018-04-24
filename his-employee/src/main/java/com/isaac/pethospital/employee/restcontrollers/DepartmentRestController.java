package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.DepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.dto.MyDepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import com.isaac.pethospital.employee.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<DepartmentEntity> getDepartments()
    {
        List<DepartmentEntity> all=this.departmentService.findAll();
        return all;
    }

    @GetMapping("root")
    public MyDepartmentIdAndNameAndChildren findRootDepartment()
    {
        return this.departmentService.findRootDepartment();
    }


    @GetMapping("brief")
    public List<DepartmentIdAndName> findIndexAndNameOnly()
    {
        return this.departmentService.findIndexAndNameOnly();
    }
}
