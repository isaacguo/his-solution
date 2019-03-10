package com.isaac.pethospital.finance.restcontrollers;

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
        this.chargeService=chargeService;

    }

    @PostMapping("{id}/updateStatus")
    public boolean updateStatus(@PathVariable("id")Long id,@RequestBody ChargeOperationRequest request)
    {
        return this.chargeService.updateStatus(id,request);
    }

}
