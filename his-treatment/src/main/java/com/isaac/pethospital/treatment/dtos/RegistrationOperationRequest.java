package com.isaac.pethospital.treatment.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RegistrationOperationRequest {
    private int indexOfDay;
    private Long id;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime bookDate;
    @NotNull
    private Long doctorId;
    @NotNull
    private Long operatorId;
    @NotNull
    private Long petId;

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


}
