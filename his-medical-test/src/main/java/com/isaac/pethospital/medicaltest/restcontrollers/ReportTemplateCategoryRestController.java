package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateCategoryOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import com.isaac.pethospital.medicaltest.services.ReportTemplateCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report-category")
public class ReportTemplateCategoryRestController {

    public ReportTemplateCategoryRestController(ReportTemplateCategoryService reportTemplateCategoryService) {
        this.reportTemplateCategoryService = reportTemplateCategoryService;
    }

    private final ReportTemplateCategoryService reportTemplateCategoryService;


    @GetMapping("departmentId/{dId}")
    public List<ReportTemplateCategoryEntity> findByDepartmentId(@PathVariable("dId") Long depId) {
        return this.reportTemplateCategoryService.findByDepartmentId(depId);
    }

    @GetMapping
    public List<ReportTemplateCategoryEntity> findRoots() {
        return this.reportTemplateCategoryService.findRoots();
    }

    @GetMapping("{id}")
    public ReportTemplateCategoryEntity findOne(@PathVariable("id") Long id) {
        return this.reportTemplateCategoryService.findOne(id);
    }

    @PostMapping
    public ReportTemplateCategoryEntity create(@RequestBody ReportTemplateCategoryOperationRequest request) {
        return this.reportTemplateCategoryService.create(request);
    }

    @PutMapping("{id}")
    public ReportTemplateCategoryEntity update(@RequestBody ReportTemplateCategoryOperationRequest request) {
        return this.reportTemplateCategoryService.update(request);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return this.reportTemplateCategoryService.delete(id);
    }

}
