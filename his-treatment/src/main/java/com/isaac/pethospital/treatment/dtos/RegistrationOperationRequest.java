package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RegistrationOperationRequest {
    int indexOfDay;
    private Long id;
    //@NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bookDate;
    @NotNull
    private Long doctorId;
    @NotNull
    private Long operatorId;
    @NotNull
    private Long petId;

    public RegistrationEntity toRegistrationEntity(EmployeeEntity doctor, EmployeeEntity operator, PetEntity pet) {
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setBookDate(this.bookDate);
        registrationEntity.setDoctor(doctor);
        registrationEntity.setOperator(operator);
        registrationEntity.setPet(pet);
        registrationEntity.setCreatedDate(LocalDateTime.now());
        registrationEntity.setRegistrationStatus(RegistrationStatusEnum.BOOKED);
        return registrationEntity;
    }

    public int getIndexOfDay() {
        return indexOfDay;
    }

    public void setIndexOfDay(int indexOfDay) {
        this.indexOfDay = indexOfDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
