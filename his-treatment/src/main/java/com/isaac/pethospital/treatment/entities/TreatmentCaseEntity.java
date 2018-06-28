package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class TreatmentCaseEntity {

    LocalDateTime treatmentDate;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDateTime;

    String petOwnerDescription;
    String doctorDiagnose;
    String clinicSituation;
    String doctorAdvice;

    @ManyToOne
    @JsonBackReference("EmployeeEntity-TreatmentCaseEntity")
    EmployeeEntity doctor;
    @ManyToOne
    @JsonBackReference("PetEntity-TreatmentCaseEntity")
    PetEntity pet;
    @ElementCollection
    List<Long> medicalTestReportIdList = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @Enumerated(EnumType.STRING)
    private TreatmentCaseStatusEnum treatmentCaseStatus;

    @OneToMany(mappedBy = "treatmentCase", cascade = CascadeType.PERSIST)
    @JsonManagedReference("TreatmentCaseEntity-PrescriptionEntity")
    private List<PrescriptionEntity> prescriptionList = new LinkedList<>();


    public void setPrescriptionList(List<PrescriptionEntity> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public List<PrescriptionEntity> getPrescriptionList() {
        return prescriptionList;
    }

    public void addPrescription(PrescriptionEntity prescription) {
        if (prescription == null)
            throw new RuntimeException("Prescription is null");
        prescription.setTreatmentCase(this);
        this.prescriptionList.add(prescription);
    }
    public void removePrescription(PrescriptionEntity prescription) {
        if (prescription == null)
            throw new RuntimeException("Prescription is null");
        prescription.setTreatmentCase(null);
        this.prescriptionList.remove(prescription);
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    public String getClinicSituation() {

        return clinicSituation;
    }

    public void setClinicSituation(String clinicSituation) {
        this.clinicSituation = clinicSituation;
    }

    public String getDoctorDiagnose() {
        return doctorDiagnose;
    }

    public void setDoctorDiagnose(String doctorDiagnose) {
        this.doctorDiagnose = doctorDiagnose;
    }


    public String getPetOwnerDescription() {
        return petOwnerDescription;
    }

    public void setPetOwnerDescription(String petOwnerDescription) {
        this.petOwnerDescription = petOwnerDescription;
    }
    public List<Long> getMedicalTestReportIdList() {
        return medicalTestReportIdList;
    }

    public void addMedicalTestReportId(Long medicalTestReportId) {
        if (medicalTestReportId == null)
            throw new RuntimeException("Medical Test Id is null");
        this.medicalTestReportIdList.add(medicalTestReportId);
    }

    public void removeMedicalTestReportId(Long medicalTestReportId) {
        if (medicalTestReportId == null)
            throw new RuntimeException("Medical Test Id is null");
        this.medicalTestReportIdList.remove(medicalTestReportId);
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }


    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
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


    public EmployeeEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeEntity doctor) {
        this.doctor = doctor;
    }
}
