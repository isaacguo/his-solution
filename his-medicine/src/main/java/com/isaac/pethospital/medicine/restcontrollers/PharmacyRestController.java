package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.services.PharmacyMedicineDispenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pharmacy-medicine")
public class PharmacyRestController extends AbstractCRUDRestController<PharmacyMedicineDispenseEntity, PharmacyOperationRequest> {

    private final PharmacyMedicineDispenseService pharmacyMedicineDispenseService;

    public PharmacyRestController(PharmacyMedicineDispenseService pharmacyMedicineDispenseService
                                  ) {
        super(pharmacyMedicineDispenseService);
        this.pharmacyMedicineDispenseService = pharmacyMedicineDispenseService;
    }

    @GetMapping("findMedicineByNameContains/{name}")
    public List<InventoryItemEntity> findMedicineByNameContains(@PathVariable("name") String name) {
        return this.pharmacyMedicineDispenseService.findMedicineByNameContains(name);

    }

}
