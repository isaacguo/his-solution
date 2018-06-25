package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.TreatmentCaseRepository;
import com.isaac.pethospital.treatment.restcontrollers.TreatmentCaseRestController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentCaseServiceImpl implements TreatmentCaseService {

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
        return this.treatmentCaseRepository.findTreatmentCaseEntitiesByPet(pet);
    }

    @Override
    public TreatmentCaseEntity createTreatmentCase(TreatmentCaseOperationRequest request) {
        return this.treatmentCaseRepository.save(request.toTreatmentCaseEntity(this.petRepository, this.employeeRepository));
    }
}
