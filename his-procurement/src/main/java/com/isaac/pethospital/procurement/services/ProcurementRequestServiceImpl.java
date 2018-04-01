package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProcurementRequestServiceImpl implements ProcurementRequestService {

    private final ProcurementRequestRepository procurementRequestRepository;
    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementService procurementService;

    public ProcurementRequestServiceImpl(ProcurementRequestRepository procurementRequestRepository, DatetimeGenerator datetimeGenerator, ProcurementService procurementService) {
        this.procurementRequestRepository = procurementRequestRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementService = procurementService;
    }

    @Override
    public boolean createRequest(ProcurementRequestOperation pro) {

        ProcurementRequestEntity pre = pro.toProcurementRequestEntity();
        pre.setSubmittedData(datetimeGenerator.getNowLocalDateTime());
        ProcurementRequestEntity result= this.procurementRequestRepository.save(pre);
        this.procurementService.requestSubmitted(result);
        return true;
    }
}
