package com.isaac.pethospital.procurement.dtos;

public class UpdateVendorCategoryNameOperationRequest {
    Long categoryId;
    String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
