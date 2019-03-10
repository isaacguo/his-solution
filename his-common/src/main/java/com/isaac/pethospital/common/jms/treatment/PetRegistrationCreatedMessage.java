package com.isaac.pethospital.common.jms.treatment;

import java.math.BigDecimal;

public class PetRegistrationCreatedMessage {

    String petUuid;
    String petOwnerUuid;
    String name;
    String doctorUuid;
    String priceUuid;
    BigDecimal totalAmount;

    public String getPriceUuid() {
        return priceUuid;
    }

    public void setPriceUuid(String priceUuid) {
        this.priceUuid = priceUuid;
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getPetOwnerUuid() {
        return petOwnerUuid;
    }

    public void setPetOwnerUuid(String petOwnerUuid) {
        this.petOwnerUuid = petOwnerUuid;
    }
}
