package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.medicine.entities.ProductImportReceiptEntity;

import java.util.List;

public interface ProductImportReceiptService {
    List<ProductImportReceiptEntity> findAll();
}
