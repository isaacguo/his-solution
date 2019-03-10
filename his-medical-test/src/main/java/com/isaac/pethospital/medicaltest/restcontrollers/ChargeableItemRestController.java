package com.isaac.pethospital.medicaltest.restcontrollers;

import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import com.isaac.pethospital.medicaltest.services.ReportTemplateCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("charge-items")
public class ChargeableItemRestController {

    private final ReportTemplateCategoryService reportTemplateCategoryService;

    public ChargeableItemRestController(ReportTemplateCategoryService reportTemplateCategoryService) {
        this.reportTemplateCategoryService = reportTemplateCategoryService;
    }

    @GetMapping
    public List<ReportTemplateCategoryEntity> getCategories() {
        return this.reportTemplateCategoryService.findRoots();
    }



}
