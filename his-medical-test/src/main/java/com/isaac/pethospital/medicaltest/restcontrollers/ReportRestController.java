package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
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
    @GetMapping()
    public List<ReportEntity> findAll()
    {
        return this.reportService.findAll();
    }
    @GetMapping("{rid}")
    public ReportEntity findById(@PathVariable("rid") Long rid )
    {
        return this.reportService.findById(rid);
    }
    @DeleteMapping("{rid}")
    public boolean deleteById(@PathVariable("rid") Long rid )
    {
        return this.reportService.deleteById(rid);
    }


    @PostMapping("create")
    public ReportEntity createReport(@RequestBody ReportOperationRequest request) {
        return this.reportService.createReport(request);

    }

}
