package com.isaac.pethospital.finance.restcontrollers;


import com.isaac.pethospital.finance.dtos.PriceOperationRequest;
import com.isaac.pethospital.finance.entities.PriceEntity;
import com.isaac.pethospital.finance.services.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
public class PriceRestController {

    private final PriceService priceService;

    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    List<PriceEntity> findAll()
    {
        return this.priceService.findAll();
    }

    @GetMapping("id")
    PriceEntity findOne(@PathVariable("id") Long id)
    {
        return this.priceService.findOne(id);
    }

    @GetMapping("findByUuid/{uuid}")
    PriceEntity findByUuid(@PathVariable("uuid") String uuid)
    {
        return this.priceService.findByUuid(uuid);
    }
    @PostMapping("findByUuids")
    List<PriceEntity> findByUuids(@RequestBody PriceOperationRequest request)
    {
        return this.priceService.findByUuids(request);
    }

    @PutMapping()
    public PriceEntity update(@RequestBody PriceOperationRequest request)
    {
        return this.priceService.update(request);
    }




}
