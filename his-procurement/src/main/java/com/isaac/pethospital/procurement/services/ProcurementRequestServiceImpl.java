package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcurementRequestServiceImpl implements ProcurementRequestService {

    private final ProcurementRequestRepository procurementRequestRepository;
    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementService procurementService;
    private final EmployeeFeignService employeeFeignService;

    public ProcurementRequestServiceImpl(ProcurementRequestRepository procurementRequestRepository,
                                         DatetimeGenerator datetimeGenerator,
                                         ProcurementService procurementService,
                                         EmployeeFeignService employeeFeignService) {

        this.procurementRequestRepository = procurementRequestRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementService = procurementService;
        this.employeeFeignService=employeeFeignService;
    }

    @Override
    public boolean createRequest(ProcurementRequestOperation pro) {

        EmployeeOperationRequest eor=this.employeeFeignService.findUserNameByUserAccount(pro.getRequester());
        ProcurementRequestEntity pre = pro.toProcurementRequestEntity();
        pre.setRequesterFullName(eor.getFullName());
        pre.setSubmittedData(datetimeGenerator.getNowLocalDateTime());
        ProcurementRequestEntity result= this.procurementRequestRepository.save(pre);
        this.procurementService.requestSubmitted(result);
        return true;
    }
}
