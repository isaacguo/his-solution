package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;

import java.time.LocalDate;

public interface RegistrationNumberService {

    int getNumber(EmployeeEntity doctor, LocalDate of);
}
