package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.procurement.entities.VendorProductCategoryEntity;
import com.isaac.pethospital.procurement.repositories.VendorProductCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class VendorProductCategoryRestController {

    private final VendorProductCategoryRepository repository;

    public VendorProductCategoryRestController(VendorProductCategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<VendorProductCategoryEntity> findAll()
    {
        return this.repository.findAll();
    }
}
