package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class PetOwnerEntity {

    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    @JsonManagedReference("PetOwnerEntity-PetEntity")
    List<PetEntity> petList = new LinkedList<>();
    @OneToMany(mappedBy = "petOwner",cascade = CascadeType.ALL)
    @JsonManagedReference("PetOwnerEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseList=new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uuid;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PetEntity> getPetList() {
        return petList;
    }

    public void addPet(PetEntity pet) {
        if(pet==null)
            throw new RuntimeException("pet is null");
        pet.setPetOwner(this);
        this.petList.add(pet);
    }
}
