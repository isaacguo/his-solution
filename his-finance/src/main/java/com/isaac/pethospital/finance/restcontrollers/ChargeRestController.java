package com.isaac.pethospital.finance.restcontrollers;

import com.isaac.pethospital.common.jms.finance.ChargeItemOperationMessage;
import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.services.ChargeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("charge")
public class ChargeRestController extends AbstractCRUDRestController<ChargeEntity, ChargeOperationRequest> {

    ChargeService chargeService;

    public ChargeRestController(ChargeService chargeService) {
        super(chargeService);
    }

}
