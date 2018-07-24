package com.isaac.pethospital.treatment.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TreatmentCaseOperationRequest {

    LocalDateTime treatmentDate;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDateTime;
    EmployeeEntity doctor;
    PetEntity pet;
    List<Long> medicalTestReportIdList = new LinkedList<>();

    String petOwnerDescription;
    String doctorDiagnose;
    String clinicSituation;
    String doctorAdvice;

    public String getPetOwnerDescription() {
        return petOwnerDescription;
    }

    public void setPetOwnerDescription(String petOwnerDescription) {
        this.petOwnerDescription = petOwnerDescription;
    }

    public String getDoctorDiagnose() {
        return doctorDiagnose;
    }

    public void setDoctorDiagnose(String doctorDiagnose) {
        this.doctorDiagnose = doctorDiagnose;
    }

    public String getClinicSituation() {
        return clinicSituation;
    }

    public void setClinicSituation(String clinicSituation) {
        this.clinicSituation = clinicSituation;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    private Long id;
    private String uuid;
    private TreatmentCaseStatusEnum treatmentCaseStatus;

    public LocalDateTime getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDateTime treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public EmployeeEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeEntity doctor) {
        this.doctor = doctor;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public List<Long> getMedicalTestReportIdList() {
        return medicalTestReportIdList;
    }

    public void setMedicalTestReportIdList(List<Long> medicalTestReportIdList) {
        this.medicalTestReportIdList = medicalTestReportIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public TreatmentCaseStatusEnum getTreatmentCaseStatus() {
        return treatmentCaseStatus;
    }

    public void setTreatmentCaseStatus(TreatmentCaseStatusEnum treatmentCaseStatus) {
        this.treatmentCaseStatus = treatmentCaseStatus;
    }

    public TreatmentCaseEntity toTreatmentCaseEntity(PetRepository petRepository, EmployeeRepository employeeRepository)
    {
        TreatmentCaseEntity treatmentCaseEntity=new TreatmentCaseEntity();

        treatmentCaseEntity.setTreatmentDate(LocalDateTime.now());
        treatmentCaseEntity.setLastModifiedDateTime(LocalDateTime.now());
        treatmentCaseEntity.setUuid(UUID.randomUUID().toString());
        //treatmentCaseEntity.setCreatedDate(this.createdDate);
        /*
        treatmentCaseEntity.setTreatmentDate(this.treatmentDate);
        treatmentCaseEntity.setCreatedDate(this.createdDate);
        treatmentCaseEntity.setLastModifiedDateTime(this.lastModifiedDateTime);
        treatmentCaseEntity.setUuid(this.uuid);
        treatmentCaseEntity.setTreatmentCaseStatus(this.treatmentCaseStatus);
        this.medicalTestReportIdList.forEach(r->{
            tgetOnereatmentCaseEntity.addMedicalTestReportId(r);
        });
        */


       PetEntity petEntity= petRepository.findOne(pet.getId());
       if(petEntity==null)
           throw new RuntimeException("Pet is null");
       treatmentCaseEntity.setPet(petEntity);

       EmployeeEntity doctor= employeeRepository.findOne(this.doctor.getId());
       if(doctor==null)
           throw new RuntimeException("Doctor is null");
       treatmentCaseEntity.setDoctor(doctor);
       return treatmentCaseEntity;
    }

}
