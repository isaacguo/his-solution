package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ChargeItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @ManyToOne
    @JsonBackReference("charge-chargeItem")
    private ChargeEntity charge;
    private BigDecimal amount;
    @ManyToOne
    private PriceEntity price;
    private Double discount;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public PriceEntity getPrice() {
        return price;
    }

    public void setPrice(PriceEntity price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }



    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChargeEntity getCharge() {
        return charge;
    }

    public void setCharge(ChargeEntity charge) {
        this.charge = charge;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
