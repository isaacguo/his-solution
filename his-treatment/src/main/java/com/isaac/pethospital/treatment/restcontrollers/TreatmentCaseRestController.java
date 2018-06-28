package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.treatment.dtos.OperationResponse;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PrescriptionEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.services.EmployeeService;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("treatment-cases")
public class TreatmentCaseRestController {

    private final TreatmentCaseService treatmentCaseService;
    private final EmployeeService employeeService;
    private final AuthHelper authHelper;

    public TreatmentCaseRestController(TreatmentCaseService treatmentCaseService, EmployeeService employeeService, AuthHelper authHelper) {
        this.treatmentCaseService = treatmentCaseService;
        this.employeeService = employeeService;
        this.authHelper = authHelper;
    }

    @GetMapping("/find-all-by-pet/{pId}")
    public List<TreatmentCaseQueryResponse> findAll(@PathVariable("pId") Long pid) {
        return this.treatmentCaseService.findAll(pid);
    }
    @GetMapping("/{tId}")
    public TreatmentCaseEntity findOne(@PathVariable("tId") Long tid) {
        return this.treatmentCaseService.findOne(tid);
    }

    @GetMapping("/{tId}/prescriptions")
    public List<PrescriptionEntity> getPrescriptions(@PathVariable("tId") Long tid) {
        return this.treatmentCaseService.getPrescriptionList(tid);
    }

    @PutMapping("/{tId}/add-medical-test/{medicalReportTemplateId}")
    public boolean addMedicalReportTemplate(@PathVariable("tId") Long tId, @PathVariable("medicalReportTemplateId") Long medicalReportTemplateId){
        return this.treatmentCaseService.addMedicalReportTemplate(tId,medicalReportTemplateId);
    }

    @DeleteMapping("/{tId}/add-medical-test/{medicalReportTemplateId}")
    public boolean removeMedicalReportTemplate(@PathVariable("tId") Long tId, @PathVariable("medicalReportTemplateId") Long medicalReportTemplateId){
        return this.treatmentCaseService.removeMedicalReportTemplate(tId,medicalReportTemplateId);
    }

    @PostMapping
    public TreatmentCaseEntity create(@RequestBody TreatmentCaseOperationRequest request) {
        String userAccount = authHelper.getUserAccount();
        EmployeeEntity doctor = this.employeeService.findByLoginAccount(userAccount);
        request.setDoctor(doctor);

        return this.treatmentCaseService.createTreatmentCase(request);
    }

    @DeleteMapping("/{tid}")
    public OperationResponse deleteOne(@PathVariable("tid") Long tid) {
        return this.treatmentCaseService.deleteOne(tid);
    }


}
