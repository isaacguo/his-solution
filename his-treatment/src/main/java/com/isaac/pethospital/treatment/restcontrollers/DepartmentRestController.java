package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
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
    public List<DepartmentEntity> getOpenToFrontDeskDepartments()
    {
        return this.departmentService.getOpenToFrontDeskDepartments();
    }
    @GetMapping(value = "/getDepartmentByDepId/{depId}")
    public DepartmentEntity getDepartmentByDepId(@PathVariable("depId") Long depId)
    {
        return this.departmentService.getDepartmentByDepId(depId);
    }

    @GetMapping(value="/getEmployeesByDepartmentId/{depId}/")
    public List<EmployeeEntity> getEmployeesByDepartmentUuid(@PathVariable("depId") Long depId)
    {
        return this.departmentService.getEmployeesByDepartmentId(depId);
    }


    @PostMapping(value = "/setDepartmentOpenToFrontDeskValue")
    public boolean setDepartmentOpenToFrontDeskValue(@RequestBody DepartmentEntity department)
    {
        return this.departmentService.setDepartmentOpenToFrontDeskValue(department);
    }

    /*

    @PostMapping(value = "/book")
    public TreatmentCaseEntity createTreatmentCase(@RequestBody TreatmentCaseEntity treatmentCase)
    {

        return this.departmentSerivce.createTreatmentCase(treatmentCase);
    }
    */

}
