
package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.treatment.dtos.OperationResponse;
import com.isaac.pethospital.treatment.dtos.PrescriptionRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.*;
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

    @GetMapping()
    public List<TreatmentCaseEntity>findAll()
    {
        return this.treatmentCaseService.findAll();
    }
    @GetMapping("/get-pet-owner-info-by-treatment-case-id/{tId}")
    public PetOwnerEntity getPetOwnerInfoByTreatmentCaseId(@PathVariable("tId") Long tId)
    {
        return this.treatmentCaseService.getPetOwnerInfoByTreatmentCaseId(tId);

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

    @PostMapping("/{tId}/prescriptions")
    public TreatmentCaseEntity setPrescriptions(@PathVariable("tId") Long tId, @RequestBody PrescriptionRequest request) {
        return this.treatmentCaseService.setPrescriptions(tId, request);
    }

    @PutMapping("/{tId}")
    public TreatmentCaseEntity update(@RequestBody TreatmentCaseOperationRequest request) {
        return this.treatmentCaseService.update(request);
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

    @PostMapping("/{uuid}/generate-medical-test-order")
    public Boolean generateMedicalTestOrder(@PathVariable("uuid") String uuid) {
        return this.treatmentCaseService.generateMedicalTestOrder(uuid);
    }

}
