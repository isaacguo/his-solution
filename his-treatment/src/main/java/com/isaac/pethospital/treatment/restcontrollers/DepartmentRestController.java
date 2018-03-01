package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.services.DepartmentSerivce;
import org.springframework.web.bind.annotation.*;

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
    public List<EmployeeEntity> getDoctorsInDepartmentByUuid(@PathVariable("uuid") String uuid)
    {
        return this.departmentSerivce.getDoctorsInDepartmentByUuid(uuid);
    }

    @PostMapping(value = "/book")
    public TreatmentCaseEntity createTreatmentCase(@RequestBody TreatmentCaseEntity treatmentCase)
    {

        return this.departmentSerivce.createTreatmentCase(treatmentCase);
    }

}
