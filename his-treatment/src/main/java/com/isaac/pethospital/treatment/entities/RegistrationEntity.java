package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistrationEntity {

    private Long price;
    private int indexOfDay;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bookDate;
    @ManyToOne
    private EmployeeEntity doctor;
    @ManyToOne
    private EmployeeEntity operator;
    @ManyToOne
    //@JsonBackReference("PetEntity-RegistrationEntity")
    private PetEntity pet;
    private RegistrationStatusEnum registrationStatus;

    public RegistrationStatusEnum getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatusEnum registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public int getIndexOfDay() {
        return indexOfDay;
    }

    public void setIndexOfDay(int indexOfDay) {
        this.indexOfDay = indexOfDay;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public EmployeeEntity getOperator() {
        return operator;
    }

    public void setOperator(EmployeeEntity operator) {
        this.operator = operator;
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

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
