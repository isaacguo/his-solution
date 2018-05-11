package com.isaac.pethospital.procurement.dtos;

import java.util.LinkedList;
import java.util.List;

public interface VendorProductCategoryListItem {

    String getName();
    Long getId();
    List<VendorProductCategoryListItem> getChildren();


}
