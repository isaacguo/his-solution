package com.isaac.pethospital.treatment.restcontrollers;


import com.isaac.pethospital.treatment.dtos.InpatientManagementRequest;
import com.isaac.pethospital.treatment.entities.InpatientManagementEntity;
import com.isaac.pethospital.treatment.services.InpatientManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inpatient-management")
public class InpatientManagementRestController {

    private final InpatientManagementService inpatientManagementService;

    public InpatientManagementRestController(InpatientManagementService inpatientManagementService) {
        this.inpatientManagementService = inpatientManagementService;
    }

    @GetMapping("{status}")
    public List<InpatientManagementEntity> getRecordsByStatus(@PathVariable("status") String status) {
        return this.inpatientManagementService.findByManagementStatus(status);
    }

    @PostMapping()
    public void createInpatientRecord(@RequestBody InpatientManagementRequest request)
    {
        this.inpatientManagementService.createInpatientRecord(request);
    }




}
