package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.services.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reports")
public class ReportRestController {

    private final ReportService reportService;

    public ReportRestController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("{rid}")
    public ReportEntity findOne(@PathVariable("rid") Long rid)
    {
        return this.reportService.findOne(rid);
    }

    @DeleteMapping("/{uuid}/")
    public boolean deleteByUuid(@PathVariable("uuid") String uuid)
    {
        return this.reportService.deleteReport(uuid);
    }
    @PostMapping("get-reports-by-uuids")
    public List<ReportEntity> getReportsByIds(@RequestBody ReportOperationRequest request)
    {
        return this.reportService.getReportsByIds(request);
    }

    @GetMapping
    public List<ReportEntity> findAll()
    {
        return this.reportService.findAll();
    }

    @PostMapping
    public ReportEntity createReport(@RequestBody ReportOperationRequest request) {
        return this.reportService.createReport(request);
    }




    @PutMapping("update-status")
    public boolean updateReportStatus(ReportOperationRequest request) {
        return this.reportService.updateReportStatus(request);
    }

    @PutMapping
    public boolean updateReport(@RequestBody ReportOperationRequest request) {
        return this.reportService.updateReport(request);
    }


}
