package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.isaac.pethospital.common.enums.GenderEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class PetOwnerEntity {

    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    @JsonManagedReference("PetOwnerEntity-PetEntity")
    List<PetEntity> petList = new LinkedList<>();
    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    @JsonManagedReference("PetOwnerEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseList = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uuid;

    private String name;
    private GenderEnum gender;
    private LocalDateTime dateOfBirth;

    private String memberNumber;
    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL)
    private List<ExpenseEntity> expenseRecordList = new LinkedList<ExpenseEntity>();
    private String address;
    private String cellPhone;
    private String email;
    private String homePhone;

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ExpenseEntity> getExpenseRecordList() {
        return expenseRecordList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

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
    public void removePet(PetEntity pet)
    {
        if(pet==null)
            throw new RuntimeException("pet is null");
        pet.setPetOwner(null);
        this.petList.remove(pet);
    }



    public void addPet(PetEntity pet) {
        if (pet == null)
            throw new RuntimeException("pet is null");
        pet.setPetOwner(this);
        this.petList.add(pet);
    }
}
