package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.treatment.dtos.ChargeableCategoryOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import com.isaac.pethospital.treatment.services.ChargeableCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chargeable-category")
public class ChargeableCategoryRestController extends AbstractCRUDRestController<ChargeableCategoryEntity, ChargeableCategoryOperationRequest> {

    private final ChargeableCategoryService chargeableCategoryService;

    public ChargeableCategoryRestController(ChargeableCategoryService chargeableCategoryService) {
        super(chargeableCategoryService);
        this.chargeableCategoryService = chargeableCategoryService;
    }
}
