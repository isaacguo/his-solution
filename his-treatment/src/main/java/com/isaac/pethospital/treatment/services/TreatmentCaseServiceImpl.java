package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.OperationResponse;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PrescriptionEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.TreatmentCaseRepository;
import com.isaac.pethospital.treatment.restcontrollers.TreatmentCaseRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TreatmentCaseServiceImpl implements TreatmentCaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TreatmentCaseRepository treatmentCaseRepository;
    private final PetRepository petRepository;
    private final EmployeeRepository employeeRepository;

    public TreatmentCaseServiceImpl(TreatmentCaseRepository treatmentCaseRepository, PetRepository petRepository, EmployeeRepository employeeRepository) {
        this.treatmentCaseRepository = treatmentCaseRepository;
        this.petRepository = petRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<TreatmentCaseQueryResponse> findAll(Long pid) {
        if (pid == null)
            throw new RuntimeException("Pid is null");
        PetEntity pet = this.petRepository.findOne(pid);
        if (pet == null)
            throw new RuntimeException("Pet is null");
        return this.treatmentCaseRepository.customFindTreatmentCaseEntitiesByPet(pet);
    }

    @Override
    public TreatmentCaseEntity createTreatmentCase(TreatmentCaseOperationRequest request) {
        return this.treatmentCaseRepository.save(request.toTreatmentCaseEntity(this.petRepository, this.employeeRepository));
    }

    @Override
    public OperationResponse deleteOne(Long tid) {
        if (tid == null) {
            logger.error("treatment case id is null");
            return new OperationResponse(false, "treatment case id is null");
        }
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findOne(tid);
        if (tce == null) {
            logger.error("treatment case is null");
            return new OperationResponse(false, "treatment case is null");
        }
        this.treatmentCaseRepository.delete(tid);
        return new OperationResponse(true);

    }

    @Override
    public List<PrescriptionEntity> getPrescriptionList(Long tid) {
        TreatmentCaseEntity tce = getTreatmentCase(tid);
        return tce.getPrescriptionList();
    }

    private TreatmentCaseEntity getTreatmentCase(Long tid) {
        if (tid == null)
            throw new RuntimeException("treatment case id is null");
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findOne(tid);
        if (tce == null) {
            throw new RuntimeException("treatment case is null");
        }
        return tce;
    }

    @Override
    public TreatmentCaseEntity findOne(Long tid) {
        TreatmentCaseEntity tce= this.treatmentCaseRepository.findOne(tid);
        return tce;
    }

    @Override
    public boolean addMedicalReportTemplate(Long tid, Long medicalReportTemplateId) {
        TreatmentCaseEntity tce = getTreatmentCase(tid);
        tce.addMedicalTestReportId(medicalReportTemplateId);
        this.treatmentCaseRepository.save(tce);
        return false;
    }


    @Override
    public boolean removeMedicalReportTemplate(Long tid, Long medicalReportTemplateId) {
        TreatmentCaseEntity tce = getTreatmentCase(tid);
        tce.removeMedicalTestReportId(medicalReportTemplateId);
        this.treatmentCaseRepository.save(tce);
        return false;
    }

    @Override
    public TreatmentCaseEntity update(TreatmentCaseOperationRequest request) {

        TreatmentCaseEntity tce = getTreatmentCase(request.getId());
        tce.setClinicSituation(request.getClinicSituation());
        tce.setDoctorAdvice(request.getDoctorAdvice());
        tce.setDoctorDiagnose(request.getDoctorDiagnose());
        tce.setPetOwnerDescription(request.getPetOwnerDescription());
        tce.setLastModifiedDateTime(LocalDateTime.now());

        return this.treatmentCaseRepository.save(tce);
    }
}
