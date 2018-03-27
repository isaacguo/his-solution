package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationNumberEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationNumberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationNumberServiceImpl implements RegistrationNumberService {

    RegistrationNumberRepository registrationNumberRepository;

    public RegistrationNumberServiceImpl(RegistrationNumberRepository registrationNumberRepository) {
        this.registrationNumberRepository = registrationNumberRepository;
    }

    @Override
    public int getNumber(EmployeeEntity doctor, LocalDate date) {

        RegistrationNumberEntity registrationNumberEntity = this.registrationNumberRepository.findByDoctorAndDate(doctor, date);
        if (registrationNumberEntity == null) {
            registrationNumberEntity = new RegistrationNumberEntity(doctor, date);
            this.registrationNumberRepository.save(registrationNumberEntity);
            return 1;
        } else {
            registrationNumberEntity.addOne();
            return this.registrationNumberRepository.save(registrationNumberEntity).getNumber();
        }
    }
}
