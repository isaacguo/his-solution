package com.isaac.pethospital.common.util;

import java.util.List;

public class AbstractCategory<I> implements Category<I> {

    @Override
    public List<Category> getChildren() {
        return null;
    }

    @Override
    public void addChild(Category child) {

    }

    @Override
    public void addChildByName(String name) {

    }

    @Override
    public Category getParent() {
        return null;
    }

    @Override
    public void setParent(Category parent) {

    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public List<I> getItems() {
        return null;
    }

    @Override
    public I addItem(I item) {
        return null;
    }

    @Override
    public void removeItem(I item) {

    }
}
