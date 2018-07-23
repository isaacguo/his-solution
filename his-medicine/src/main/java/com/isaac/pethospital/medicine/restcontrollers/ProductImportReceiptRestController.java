package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.medicine.entities.ProductImportReceiptEntity;
import com.isaac.pethospital.medicine.services.ProductImportReceiptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("import-receipts")
public class ProductImportReceiptRestController {

    private final ProductImportReceiptService productImportReceiptService;

    public ProductImportReceiptRestController(ProductImportReceiptService productImportReceiptService) {
        this.productImportReceiptService = productImportReceiptService;
    }

    List<ProductImportReceiptEntity> findAll()
    {
        return this.productImportReceiptService.findAll();
    }
}
