package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmacyDispensingRestController extends AbstractCRUDRestController<PharmacyMedicineDispenseEntity, PharmacyOperationRequest> {
    public PharmacyDispensingRestController(CrudService<PharmacyMedicineDispenseEntity, PharmacyOperationRequest> crudService) {
        super(crudService);
    }
}
