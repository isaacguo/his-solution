package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.PetEntity;

import java.util.List;

public interface PetService {
    List<PetEntity> findByName(String name);
}
