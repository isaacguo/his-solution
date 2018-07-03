package com.isaac.pethospital.finance.restcontrollers;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeCategoryEntity;
import com.isaac.pethospital.finance.services.ChargeCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("charge-categories")
public class ChargeCategoryRestController {

    private final ChargeCategoryService chargeCategoryService;

    public ChargeCategoryRestController(ChargeCategoryService chargeCategoryService) {
        this.chargeCategoryService = chargeCategoryService;
    }

    @PostMapping()
    public ChargeCategoryEntity createDepartment(@RequestBody ChargeCategoryOperationRequest request) {
        return this.chargeCategoryService.create(request);
    }

    @GetMapping("root")
    public List<ChargeCategoryEntity> findRoot() {
        return this.chargeCategoryService.findRoot();
    }
    @DeleteMapping("{id}")
    public boolean deleteOne(@PathVariable("id") Long id)
    {
        return this.chargeCategoryService.delete(id);
    }

    @PutMapping("rename")
    public boolean renameDepartment(@RequestBody ChargeCategoryOperationRequest request) {
        return this.chargeCategoryService.renameChargeCategory(request);
    }

}
