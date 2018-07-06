package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateCategoryOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;

import java.util.List;

public interface ReportTemplateCategoryService {

    List<ReportTemplateCategoryEntity> findRoots();

    ReportTemplateCategoryEntity findOne(Long id);

    ReportTemplateCategoryEntity create(ReportTemplateCategoryOperationRequest request);

    ReportTemplateCategoryEntity update(ReportTemplateCategoryOperationRequest request);

    boolean delete(Long id);
}
