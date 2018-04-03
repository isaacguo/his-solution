package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    private final ProcurementRepository procurementRepository;

    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementConfigurationService procurementConfigurationService;
    private final ProcurementStatusService procurementStatusService;
    private final ProcurementApprovalService procurementApprovalService;
    private final VendorRepository vendorRepository;

    public ProcurementServiceImpl(ProcurementRepository procurementRepository, DatetimeGenerator datetimeGenerator, ProcurementConfigurationService procurementConfigurationService, ProcurementStatusService procurementStatusService, ProcurementApprovalService procurementApprovalService, VendorRepository vendorRepository) {
        this.procurementRepository = procurementRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementConfigurationService = procurementConfigurationService;
        this.procurementStatusService = procurementStatusService;
        this.procurementApprovalService = procurementApprovalService;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void requestSubmitted(ProcurementRequestEntity request) {
        ProcurementEntity pe = this.createProcurement(request);
        this.procurementApprovalService.procurementCreated(pe);
    }

    @Override
    public ProcurementEntity createProcurement(ProcurementRequestEntity request) {
        ProcurementEntity pe = new ProcurementEntity();
        pe = this.procurementRepository.save(pe);
        pe.setProcurementRequest(request);
        pe.setStatus(this.procurementStatusService.getRoot().getStatus());
        String orderNumber = this.procurementConfigurationService.getOrderNumber();
        pe.setOrderNumber(orderNumber);

        return this.procurementRepository.save(pe);
    }

    @Override
    public List<ProcurementEntity> findAllMyProcurements(String requester) {
        return this.procurementRepository.findByRequester(requester);
    }

    @Override
    public ProcurementEntity addVendorInfo(ProcurementOperation po) {
        ProcurementEntity pe = this.procurementRepository.findOne(po.getId());
        if (pe == null)
            throw new RuntimeException("Cannot find Procurement by given id:" + po.getId());

        VendorEntity ve = this.vendorRepository.findOne(po.getVendorId());
        if (ve == null)
            throw new RuntimeException("Cannot find Vendor by given id:" + po.getVendorId());
        ContactEntity ce = ve.getContacts().stream().filter(r -> r.getId() == po.getContactId()).findFirst().orElse(null);
        if (ve == null)
            throw new RuntimeException("Cannot find Contact by given id:" + po.getContactId());

        pe.setVendor(ve.getName());
        pe.setContact(ce.getName());

        ProcurementStatusEntity pse=this.procurementStatusService.getNextStatus(pe.getStatus(), true);
        if(pse!=null)
            pe.setStatus(pse.getStatus());
        else
            throw new RuntimeException("No success status after "+pe.getStatus());

        return this.procurementRepository.save(pe);
    }
}
