package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProcurementPurchaseEntity {

    LocalDateTime generatedDateTime; //表单生成时间
    @OneToMany
    @JsonManagedReference("ProcurementPurchaseEntity-ProcurementPurchaseGoodEntity")
    List<ProcurementPurchaseGoodEntity> goods = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGeneratedDateTime() {
        return generatedDateTime;
    }

    public void setGeneratedDateTime(LocalDateTime generatedDateTime) {
        this.generatedDateTime = generatedDateTime;
    }

    public List<ProcurementPurchaseGoodEntity> getGoods() {
        return goods;
    }

    public void addGood(ProcurementPurchaseGoodEntity good) {
        if (good == null)
            throw new RuntimeException("Purchase Good is null.");
        this.goods.add(good);
    }
}
