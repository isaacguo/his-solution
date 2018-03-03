package com.isaac.pethospital.treatment.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RegistrationNumberEntity {

    public RegistrationNumberEntity() {
    }

    public RegistrationNumberEntity(EmployeeEntity doctor, LocalDate date) {
        this.doctor = doctor;
        this.date = date;
        this.number=1;
    }

    @ManyToOne
    private EmployeeEntity doctor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Integer number;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeEntity doctor) {
        this.doctor = doctor;
    }


    public void addOne()
    {
        this.number++;
    }


}
