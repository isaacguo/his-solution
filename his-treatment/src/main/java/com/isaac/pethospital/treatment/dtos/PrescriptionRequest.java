package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.TreatmentCaseMedicineEntity;

import java.util.List;

public class PrescriptionRequest {
    List<TreatmentCaseMedicineEntity> items;

    public List<TreatmentCaseMedicineEntity> getItems() {
        return items;
    }

    public void setItems(List<TreatmentCaseMedicineEntity> items) {
        this.items = items;
    }
}
