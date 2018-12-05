package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateIdAndNameResponse;
import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.services.ReportTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report-templates")
public class ReportTemplateRestController {

    private final ReportTemplateService reportTemplateService;

    public ReportTemplateRestController(ReportTemplateService reportTemplateService) {
        this.reportTemplateService = reportTemplateService;
    }

    @GetMapping()
    public List<ReportTemplateEntity> findAll() {
        return this.reportTemplateService.findAll();
    }

    @GetMapping("{rid}")
    public ReportTemplateEntity findById(@PathVariable("rid") Long rid) {
        return this.reportTemplateService.findById(rid);
    }

    @GetMapping("findReportTemplatesByDepartmentId/{dId}")
    public List<ReportTemplateEntity> findReportTemplatesByDepartmentId(@PathVariable("dId") Long dId) {
        return this.reportTemplateService.findReportTemplatesByDepartmentId(dId);
    }

    @GetMapping("findTemplateByNameContains/{name}")
    public List<ReportTemplateEntity> findTemplateByNameContains(@PathVariable("name") String name) {
        return this.reportTemplateService.findTemplateByNameContains(name);
    }

    @DeleteMapping("{rid}")
    public boolean deleteById(@PathVariable("rid") Long rid) {
        return this.reportTemplateService.deleteById(rid);
    }


    @PostMapping("create")
    public ReportTemplateEntity createReport(@RequestBody ReportTemplateOperationRequest request) {
        return this.reportTemplateService.createReportTemplate(request);
    }


    @PostMapping("update")
    public ReportTemplateEntity updateReport(@RequestBody ReportTemplateOperationRequest request) {
        return this.reportTemplateService.updateReportTemplate(request);
    }

}
