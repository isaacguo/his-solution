package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestCreateReportMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestDeleteReportMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyMedicineDispenseCreateMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.treatment.dtos.OperationResponse;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PrescriptionEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.TreatmentCaseRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TreatmentCaseServiceImpl implements TreatmentCaseService {

    private final TreatmentCaseRepository treatmentCaseRepository;
    private final PetRepository petRepository;
    private final EmployeeRepository employeeRepository;
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public TreatmentCaseServiceImpl(TreatmentCaseRepository treatmentCaseRepository, PetRepository petRepository, EmployeeRepository employeeRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        this.treatmentCaseRepository = treatmentCaseRepository;
        this.petRepository = petRepository;
        this.employeeRepository = employeeRepository;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
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


    private TreatmentCaseEntity getTreatmentCaseByUuid(String uuid) {
        if (StringUtils.isEmpty(uuid))
            throw new RuntimeException("treatment case uuid is null");
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findByUuid(uuid);
        if (tce == null) {
            throw new RuntimeException("treatment case is null");
        }
        return tce;
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
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findOne(tid);
        return tce;
    }

    @Override
    public void onMedicalTestReportCreated(MedicalTestCreateReportMessage message) {

        TreatmentCaseEntity tce = getTreatmentCaseByUuid(message.getTreatmentCaseUuid());
        tce.addMedicalTestReportUuid(message.getReportUuid());
        this.treatmentCaseRepository.save(tce);
    }

    @Override
    public void onMedicalTestReportRemoved(MedicalTestDeleteReportMessage message) {

        TreatmentCaseEntity tce = getTreatmentCaseByUuid(message.getTreatmentCaseUuid());
        tce.removeMedicalTestReportUuid(message.getReportUuid());
        this.treatmentCaseRepository.save(tce);
    }

    @Override
    public void onPharmacyMedicineDispenseCreate(PharmacyMedicineDispenseCreateMessage message) {

        TreatmentCaseEntity tce = getTreatmentCaseByUuid(message.getTreatmentCaseUuid());
        tce.addPharmacyMedicineDispenseUuid(message.getPharmacyMedicineDispenseUuid());
        this.treatmentCaseRepository.save(tce);
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

    @Override
    public Boolean generateMedicalTestOrder(String uuid) {

        TreatmentCaseEntity tc = treatmentCaseRepository.findByUuid(uuid);
        if (tc == null)
            throw new RuntimeException("Treatment Case is null");

        GenerateMedicalTestOrderMessage medicalTestOrderMessage = new GenerateMedicalTestOrderMessage();
        medicalTestOrderMessage.setTreatmentCaseUuid(tc.getUuid());
        medicalTestOrderMessage.setPetOwnerUuid(tc.getPet().getPetOwner().getUuid());
        medicalTestOrderMessage.setPetUuid(tc.getPet().getUuid());

        this.jmsSender.sendEvent(jmsProperties.getTreatmentGenerateMedicalTestOrderTopic(), medicalTestOrderMessage);
        return true;
    }

    @Override
    public void onChargeItemEvent(ChargeReportOperationReplyMessage message) {

    }

}
