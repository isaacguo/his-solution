package com.isaac.pethospital.medicine.restcontrollers;


import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.medicine.dtos.InventoryItemOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.services.InventoryItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory-items")
public class InventoryItemRestController extends AbstractCRUDRestController<InventoryItemEntity, InventoryItemOperationRequest> {

    private final InventoryItemService inventoryItemService;

    public InventoryItemRestController(InventoryItemService inventoryItemService) {
        super(inventoryItemService);
        this.inventoryItemService=inventoryItemService;
    }


    @GetMapping(value = "/find-by-name-contains/{keyword}")
    public List<InventoryItemEntity> findEmployeesByKeywordInName(@PathVariable("keyword") String keyword) {
        return this.inventoryItemService.findByNameContains(keyword);
    }

}
