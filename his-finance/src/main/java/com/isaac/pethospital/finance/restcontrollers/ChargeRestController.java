package com.isaac.pethospital.finance.restcontrollers;


import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.services.ChargeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("id")
    ChargeEntity findOne(@PathVariable("id") Long id)
    {
        return this.chargeService.findOne(id);
    }

    @GetMapping("findByUuid/{uuid}")
    ChargeEntity findByUuid(@PathVariable("uuid") String uuid)
    {
        return this.chargeService.findByUuid(uuid);
    }
    @PostMapping("findByUuids")
    List<ChargeEntity> findByUuids(@RequestBody ChargeOperationRequest request)
    {
        return this.chargeService.findByUuids(request);
    }

    @PutMapping()
    public ChargeEntity update(@RequestBody ChargeOperationRequest request)
    {
        return this.chargeService.update(request);
    }




}
