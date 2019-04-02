package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.InpatientManagementRequest;
import com.isaac.pethospital.treatment.entities.InpatientManagementEntity;
import com.isaac.pethospital.treatment.repositories.InpatientManagementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InpatientManagementServiceImpl implements InpatientManagementService {

    private final InpatientManagementRepository inpatientManagementRepository;

    public InpatientManagementServiceImpl(InpatientManagementRepository inpatientManagementRepository) {
        this.inpatientManagementRepository = inpatientManagementRepository;
    }

    @Override
    public List<InpatientManagementEntity> findByManagementStatus(String status) {
        return this.inpatientManagementRepository.findByManagementStatus(status);
    }

    @Override
    public void createInpatientRecord(InpatientManagementRequest request) {

        InpatientManagementEntity inpatientManagement=new InpatientManagementEntity();
        inpatientManagement.setPetUuid(request.getPetUuid());
        inpatientManagement.setManagementStatus("Inpatient");
        inpatientManagement.setInDate(new Date());
        inpatientManagement.setPetStatus(request.getPetStatus());
        inpatientManagement.setReasonToInpatient(request.getReasonToInpatient());
        inpatientManagement.setRequestDoctor(request.getRequestDoctor());
        inpatientManagement.setRequestDoctorUuid(request.getRequestDoctorUuid());

        this.inpatientManagementRepository.save(inpatientManagement);
    }
}
