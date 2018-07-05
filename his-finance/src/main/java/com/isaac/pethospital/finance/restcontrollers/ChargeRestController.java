package com.isaac.pethospital.finance.restcontrollers;


import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.services.ChargeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("charges")
public class ChargeRestController {

    private final ChargeService chargeService;

    public ChargeRestController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @GetMapping
    List<ChargeEntity> findAll()
    {
        return this.chargeService.findAll();
    }


}
