package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prescriptions")
public class PharmacyPrescriptionRestController extends AbstractCRUDRestController<PharmacyPrescriptionEntity, PharmacyOperationRequest> {

    private final PharmacyPrescriptionService pharmacyPrescriptionService;

    public PharmacyPrescriptionRestController(PharmacyPrescriptionService pharmacyPrescriptionService) {
        super(pharmacyPrescriptionService);
        this.pharmacyPrescriptionService = pharmacyPrescriptionService;
    }

    @GetMapping("findByPetUuidToday/{uuid}")
    public List<PharmacyPrescriptionEntity> findByPetUuidToday(@PathVariable("uuid") String uuid) {
        return this.pharmacyPrescriptionService.findByPetUuidToday(uuid);
    }

    @GetMapping("findByPetUuidHistory/{uuid}")
    public List<PharmacyPrescriptionEntity> findByPetUuidHistory(@PathVariable("uuid") String uuid) {
        return this.pharmacyPrescriptionService.findByPetUuidHistory(uuid);
    }

    @PutMapping("submitPrescription")
    public PharmacyPrescriptionEntity submitPrescription(@RequestBody
                                                                     PharmacyOperationRequest request) {
        return this.pharmacyPrescriptionService.submitPrescription(request);
    }
}
