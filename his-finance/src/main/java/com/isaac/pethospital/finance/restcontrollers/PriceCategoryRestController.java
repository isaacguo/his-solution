package com.isaac.pethospital.finance.restcontrollers;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.PriceCategoryEntity;
import com.isaac.pethospital.finance.services.PriceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price-categories")
public class PriceCategoryRestController {

    private final PriceCategoryService priceCategoryService;

    public PriceCategoryRestController(PriceCategoryService priceCategoryService) {
        this.priceCategoryService = priceCategoryService;
    }

    @PostMapping()
    public PriceCategoryEntity createDepartment(@RequestBody ChargeCategoryOperationRequest request) {
        return this.priceCategoryService.create(request);
    }

    @GetMapping("root")
    public List<PriceCategoryEntity> findRoot() {
        return this.priceCategoryService.findRoot();
    }
    @DeleteMapping("{id}")
    public boolean deleteOne(@PathVariable("id") Long id)
    {
        return this.priceCategoryService.delete(id);
    }

    @PutMapping("rename")
    public boolean renameDepartment(@RequestBody ChargeCategoryOperationRequest request) {
        return this.priceCategoryService.renameChargeCategory(request);
    }

}
