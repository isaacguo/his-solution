package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public PharmacyPrescriptionEntity submitPrescription(@RequestBody PharmacyOperationRequest request) {
        return this.pharmacyPrescriptionService.submitPrescription(request);
    }

    @GetMapping("all/{status}")
    public Page<PharmacyPrescriptionEntity> findAllPrescriptionsByStatusOnPage(@PathVariable("status") String status, Pageable pageable) {
        PrescriptionStatusEnum statusEnum = PrescriptionStatusEnum.valueOf(status);
        return this.pharmacyPrescriptionService.findAllPrescriptionsByStatusOnPage(statusEnum, pageable);
    }

    @PutMapping("medicineDispensed")
    public PharmacyPrescriptionEntity medicineDispensed(@RequestBody PharmacyOperationRequest request) {
        return this.pharmacyPrescriptionService.medicineDispensed(request);
    }
    @PutMapping("withdrawMedicine")
    public PharmacyPrescriptionEntity withdrawMedicine(@RequestBody PharmacyOperationRequest request) {
        return this.pharmacyPrescriptionService.withdrawMedicine(request);
    }

}
