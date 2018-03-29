package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ProcurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long orderNumber; //单号

    @ManyToOne
    VendorEntity vendor;

    @OneToMany
    @JsonManagedReference("ProcurementEntity-ProcurementGoodEntit")
    List<ProcurementGoodEntity> goods; //采购商品

    @ManyToOne
    OperatorEntity operator;
    LocalDateTime orderGeneratedTime; //制单时间

    LocalDateTime orderConfirmedTime; //订单确认时间


}
