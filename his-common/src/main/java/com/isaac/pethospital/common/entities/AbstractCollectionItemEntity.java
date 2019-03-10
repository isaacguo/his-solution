package com.isaac.pethospital.common.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractCollectionItemEntity<C extends AbstractCollectionEntity> {


    @ManyToOne
    @JsonBackReference("collection-items")
    C collection;

    public C getCollection() {
        return collection;
    }

    public void setCollection(C collection) {
        this.collection = collection;
    }
}
