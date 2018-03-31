package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ProcurementGoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String number; //个数
    String packageSpecification; //包装规格
    String packageUnit; //包装单位

    double pricePerUnit; //单价
    double totalPrice;

}

