package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.common.enums.GenderEnum;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

public class PetOwnerOperationRequest {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    Long petId;
    Long id;
    @NotBlank
    private String name;
    private GenderEnum gender;
    private LocalDateTime dateOfBirth;
    private String address;
    private String cellPhone;
    private String email;
    private String homePhone;

    public PetOwnerOperationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public PetOwnerEntity toPetOwnerEntity() {
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setName(this.name);
        petOwnerEntity.setAddress(this.address);
        petOwnerEntity.setCellPhone(this.cellPhone);
        petOwnerEntity.setDateOfBirth(this.dateOfBirth);
        petOwnerEntity.setEmail(this.email);
        petOwnerEntity.setGender(this.gender);
        petOwnerEntity.setHomePhone(this.homePhone);
        return petOwnerEntity;
    }

    ;
}
