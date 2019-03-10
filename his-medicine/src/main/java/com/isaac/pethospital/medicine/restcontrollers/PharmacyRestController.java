package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pharmacy-medicine")
public class PharmacyRestController extends AbstractCRUDRestController<PharmacyPrescriptionEntity, PharmacyOperationRequest> {

    private final PharmacyPrescriptionService pharmacyPrescriptionService;

    public PharmacyRestController(PharmacyPrescriptionService pharmacyPrescriptionService) {
        super(pharmacyPrescriptionService);
        this.pharmacyPrescriptionService = pharmacyPrescriptionService;
    }

    @GetMapping("findMedicineByNameContains/{name}")
    public List<InventoryItemEntity> findMedicineByNameContains(@PathVariable("name") String name) {
        return this.pharmacyPrescriptionService.findMedicineByNameContains(name);
    }
}
