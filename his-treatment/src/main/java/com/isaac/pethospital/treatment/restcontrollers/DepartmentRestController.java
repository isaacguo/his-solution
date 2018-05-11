package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<DepartmentEntity> getDepartments()
    {
        return this.departmentService.getDepartments();
    }
    /*
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
    */

}
