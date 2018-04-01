package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProcurementStatusEntity {

    String status;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-next")
    List<ProcurementStatusEntity> next = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-next")
    ProcurementStatusEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void addNext(ProcurementStatusEntity next) {
        if (next == null)
            throw new RuntimeException("next is null");
        next.setParent(this);
        this.next.add(next);
    }

    public void removeNext(ProcurementStatusEntity next) {
        if (next == null)
            throw new RuntimeException("next is null");

        this.next.remove(next);
        next.setParent(null);
    }

    public ProcurementStatusEntity getParent() {
        return parent;
    }

    public void setParent(ProcurementStatusEntity parent) {
        this.parent = parent;
    }

    public List<ProcurementStatusEntity> getNext() {
        return next;
    }
}
