package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.treatment.GenerateEmployeeMessage;
import com.isaac.pethospital.treatment.dtos.ChargeableCategoryOperationRequest;
import com.isaac.pethospital.treatment.dtos.ChargeableItemOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import com.isaac.pethospital.treatment.repositories.ChargeableCategoryRepository;
import com.isaac.pethospital.treatment.services.ChargeableItemService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class EmployeeCreateEventListener {

    private final ChargeableItemService chargeableItemService;
    private final ChargeableCategoryRepository chargeableCategoryRepository;

    public EmployeeCreateEventListener(ChargeableItemService chargeableItemService, ChargeableCategoryRepository chargeableCategoryRepository) {
        this.chargeableItemService = chargeableItemService;
        this.chargeableCategoryRepository = chargeableCategoryRepository;
    }

    @JmsListener(destination = "${jms.treatment-employee-generate-topic}")
    @Transactional
    public void processMessage(GenerateEmployeeMessage message) throws Exception {
        ChargeableItemOperationRequest chargeableItemOperationRequest = new ChargeableItemOperationRequest();

        ChargeableCategoryEntity cce= this.chargeableCategoryRepository.findByName("挂号");
        chargeableItemOperationRequest.setCategoryId(cce.getId());
        chargeableItemOperationRequest.setUuid(message.getEmployeeUuid());
        chargeableItemOperationRequest.setName(message.getName());

        this.chargeableItemService.create(chargeableItemOperationRequest);
    }
}
