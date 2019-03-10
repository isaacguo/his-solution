package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.treatment.dtos.ChargeableItemOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;
import com.isaac.pethospital.treatment.services.ChargeableItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chargeable-items")
public class ChargeableItemRestController extends AbstractCRUDRestController<ChargeableItemEntity, ChargeableItemOperationRequest> {

    private final ChargeableItemService chargeableItemService;

    public ChargeableItemRestController(ChargeableItemService chargeableItemService) {
        super(chargeableItemService);
        this.chargeableItemService = chargeableItemService;
    }
}
