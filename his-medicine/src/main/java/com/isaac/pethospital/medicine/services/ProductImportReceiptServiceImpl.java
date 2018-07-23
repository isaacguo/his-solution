package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.medicine.entities.ProductImportReceiptEntity;
import com.isaac.pethospital.medicine.repository.ProductImportReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImportReceiptServiceImpl implements ProductImportReceiptService {
    private final ProductImportReceiptRepository productImportReceiptRepository;

    public ProductImportReceiptServiceImpl(ProductImportReceiptRepository productImportReceiptRepository) {
        this.productImportReceiptRepository = productImportReceiptRepository;
    }

    @Override
    public List<ProductImportReceiptEntity> findAll() {
        return this.productImportReceiptRepository.findAll();
    }
}
