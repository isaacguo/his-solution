package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.DoctorEntity;
import com.isaac.pethospital.treatment.services.DepartmentSerivce;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentSerivce departmentSerivce;

    public DepartmentRestController(DepartmentSerivce departmentSerivce) {
        this.departmentSerivce = departmentSerivce;
    }

    @GetMapping
    public List<DepartmentEntity> getDepartments()
    {
        return this.departmentSerivce.getDepartments();
    }
    @GetMapping(value = "/getDoctorsInDepartmentByUuid/{uuid}/")
    public List<DoctorEntity> getDoctorsInDepartmentByUuid(@PathVariable("uuid") String uuid)
    {
        return this.departmentSerivce.getDoctorsInDepartmentByUuid(uuid);
    }
}
