package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;
import org.apache.commons.lang.StringUtils;

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

    @OneToMany(mappedBy = "treatmentCase", cascade = CascadeType.ALL)
    @JsonManagedReference("TreatmentCase-TreatmentCaseMedicine")
    List<TreatmentCaseMedicineEntity> medicineList = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("EmployeeEntity-TreatmentCaseEntity")
    EmployeeEntity doctor;
    @ManyToOne
    @JsonBackReference("PetEntity-TreatmentCaseEntity")
    PetEntity pet;
    @ElementCollection
    List<String> medicalTestReportUuidList = new LinkedList<>();
    @ElementCollection
    List<String> pharmacyMedicineDispenseUuidList = new LinkedList<>();
    @OneToMany(mappedBy = "treatmentCase", cascade = CascadeType.ALL)
    @JsonManagedReference("TreatmentCase-Comment")
    List<CommentEntity> comments = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;

    @Enumerated(EnumType.STRING)
    private TreatmentCaseStatusEnum treatmentCaseStatus;

    public TreatmentCaseStatusEnum getTreatmentCaseStatus() {
        return treatmentCaseStatus;
    }

    public void setTreatmentCaseStatus(TreatmentCaseStatusEnum treatmentCaseStatus) {
        this.treatmentCaseStatus = treatmentCaseStatus;
    }

    private boolean caseClosed;
    @OneToMany(mappedBy = "treatmentCase", cascade = CascadeType.PERSIST)
    @JsonManagedReference("TreatmentCaseEntity-PrescriptionEntity")
    private List<PrescriptionEntity> prescriptionList = new LinkedList<>();

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void addComment(CommentEntity comment) {
        if (comment == null)
            throw new RuntimeException("Comment is null");
        comment.setTreatmentCase(this);
        this.comments.add(comment);
    }

    public boolean isCaseClosed() {
        return caseClosed;
    }

    public void setCaseClosed(boolean caseClosed) {
        this.caseClosed = caseClosed;
    }

    public List<TreatmentCaseMedicineEntity> getMedicineList() {
        return medicineList;
    }

    public void removeMedicine(TreatmentCaseMedicineEntity medicine) {
        if (medicine == null)
            throw new RuntimeException("Medicine is null");
        medicine.setTreatmentCase(null);
        this.medicineList.remove(medicine);
    }

    public void addMedicine(TreatmentCaseMedicineEntity medicine) {
        if (medicine == null)
            throw new RuntimeException("Medicine is null");
        medicine.setTreatmentCase(this);
        this.medicineList.add(medicine);
    }

    public void removeMedicineList(TreatmentCaseMedicineEntity medicine) {
        if (medicine == null)
            throw new RuntimeException("Medicine is null");
        medicine.setTreatmentCase(null);
        this.medicineList.add(medicine);
    }

    public List<String> getPharmacyMedicineDispenseUuidList() {
        return pharmacyMedicineDispenseUuidList;
    }

    public void addPharmacyMedicineDispenseUuid(String pharmacyMedicineDispenseUuid) {
        if (StringUtils.isEmpty(pharmacyMedicineDispenseUuid))
            throw new RuntimeException("pharmacyMedicineDispenseUuid is null");
        this.pharmacyMedicineDispenseUuidList.add(pharmacyMedicineDispenseUuid);
    }

    public void removePharmacyMedicineDispenseUuid(String pharmacyMedicineDispenseUuid) {
        if (StringUtils.isEmpty(pharmacyMedicineDispenseUuid))
            throw new RuntimeException("pharmacyMedicineDispenseUuid is null");
        this.pharmacyMedicineDispenseUuidList.remove(pharmacyMedicineDispenseUuid);
    }

    public List<PrescriptionEntity> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<PrescriptionEntity> prescriptionList) {
        this.prescriptionList = prescriptionList;
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

    public List<String> getMedicalTestReportUuidList() {
        return medicalTestReportUuidList;
    }

    public void addMedicalTestReportUuid(String medicalTestReportUuid) {
        if (StringUtils.isEmpty(medicalTestReportUuid))
            throw new RuntimeException("Medical Test Id is null");
        this.medicalTestReportUuidList.add(medicalTestReportUuid);
    }

    public void removeMedicalTestReportUuid(String medicalTestReportUuid) {
        if (StringUtils.isEmpty(medicalTestReportUuid))
            throw new RuntimeException("Medical Test Id is null");
        this.medicalTestReportUuidList.remove(medicalTestReportUuid);
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
