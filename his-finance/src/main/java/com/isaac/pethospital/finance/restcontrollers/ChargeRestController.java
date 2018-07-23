package com.isaac.pethospital.finance.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.restcontrollers.CrudRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.services.ChargeService;
import org.apache.commons.lang.CharEncoding;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("charge")
public class ChargeRestController extends AbstractCRUDRestController<ChargeEntity, ChargeOperationRequest> {

    ChargeService chargeService;

    public ChargeRestController(ChargeService chargeService) {
        super(chargeService);
    }


}
