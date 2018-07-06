package com.isaac.pethospital.common.util;

import java.util.List;

public interface Category<I> {

    List<Category> getChildren();

    void addChild(Category child);

    void addChildByName(String name);

    Category getParent();

    void setParent(Category parent);

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);


    List<I> getItems();

    I addItem(I item);

    void removeItem(I item);


}
