package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.medicine.repository.MedicineRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }


}
