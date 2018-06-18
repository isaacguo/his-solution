package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
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
    public List<ReportTemplateEntity> findAll()
    {
        return this.reportTemplateService.findAll();
    }
    @GetMapping("{rid}")
    public ReportTemplateEntity findById(@PathVariable("rid") Long rid )
    {
        return this.reportTemplateService.findById(rid);
    }
    @DeleteMapping("{rid}")
    public boolean deleteById(@PathVariable("rid") Long rid )
    {
        return this.reportTemplateService.deleteById(rid);
    }


    @PostMapping("create")
    public ReportTemplateEntity createReport(@RequestBody ReportOperationRequest request) {
        return this.reportTemplateService.createReportTemplate(request);
    }


    @PostMapping("update")
    public ReportTemplateEntity updateReport(@RequestBody ReportOperationRequest request) {
        return this.reportTemplateService.updateReportTemplate(request);
    }

}
