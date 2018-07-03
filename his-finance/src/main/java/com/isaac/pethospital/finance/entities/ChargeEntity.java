package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ChargeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String chargeItemId;
    String fromService;

    Long normalPrice; //普通价格
    Long memberPrice; //会员价格

    @ManyToOne()
    @JsonBackReference("ChargeCategoryEntity-ChargeEntity")
    private ChargeCategoryEntity chargeCategory;



}
