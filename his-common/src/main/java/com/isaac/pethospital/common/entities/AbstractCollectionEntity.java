package com.isaac.pethospital.common.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@MappedSuperclass
public abstract class AbstractCollectionEntity<T extends AbstractCollectionItemEntity> {



    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("collection-items")
    List<T> items=new LinkedList<>();

    public void addItem(T item)
    {
        if(item==null)
            throw new RuntimeException("item is" +
                    " null");
        item.setCollection(this);
        this.items.add(item);
    }

    public void removeItem(T item)
    {
        if(item==null)
            throw new RuntimeException("item is null");
        item.setCollection(null);
        this.items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }


}
