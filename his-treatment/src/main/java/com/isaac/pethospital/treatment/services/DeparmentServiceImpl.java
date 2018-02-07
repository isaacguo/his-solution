package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.DoctorEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DeparmentServiceImpl implements DepartmentSerivce {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public DeparmentServiceImpl(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DepartmentEntity> getDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public List<DoctorEntity> getDoctorsInDepartmentByUuid(String uuid) {

        DepartmentEntity departmentEntity = this.departmentRepository.findByUuid(uuid);
        if (departmentEntity == null) throw new RuntimeException("Can not find specified department");

        return departmentEntity.getDoctorList();
    }

    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        String uuid = UUID.randomUUID().toString();
        departmentEntity.setUuid(uuid);
        return this.departmentRepository.save(departmentEntity);

    }

    @Override
    public TreatmentCaseEntity createTreatmentCase(TreatmentCaseEntity treatmentCase) {
        treatmentCase.setCreatedDate(LocalDateTime.now());
        treatmentCase.setTreatmentCaseStatus(TreatmentCaseStatusEnum.BOOKED);
        DepartmentEntity departmentEntity = this.departmentRepository.findByUuid(treatmentCase.getDepartment().getUuid());
        departmentEntity.addTreatmentCase(treatmentCase);
        this.departmentRepository.save(departmentEntity);
        treatmentCase.setCreateResult(true);
        return treatmentCase;
    }

}
