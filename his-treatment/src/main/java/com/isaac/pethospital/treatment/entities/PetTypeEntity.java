package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class PetTypeEntity {

    boolean isRoot;
    String name;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<PetTypeEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    PetTypeEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
    @JsonManagedReference("petType-pet")
    private List<PetEntity> pets=new LinkedList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PetTypeEntity> getChildren() {
        return children;
    }

    public void addChild(PetTypeEntity child) {
        if(child==null) throw new RuntimeException("child is null");
        child.setParent(this);
        this.children.add(child);
    }

    public PetTypeEntity getParent() {
        return parent;
    }

    public void setParent(PetTypeEntity parent) {
        this.parent = parent;
    }
}
