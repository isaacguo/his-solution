package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;
import com.isaac.pethospital.medicaltest.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/getDepartmentByDepId/{depId}")
    public DepartmentEntity getDepartmentByDepId(@PathVariable("depId") Long depId)
    {
        return this.departmentService.getDepartmentByDepId(depId);
    }

    @PostMapping(value = "/setDepartmentEnable")
    public boolean setDepartmentEnable(@RequestBody DepartmentEntity department)
    {
        return this.departmentService.setDepartmentEnable(department);
    }





}
