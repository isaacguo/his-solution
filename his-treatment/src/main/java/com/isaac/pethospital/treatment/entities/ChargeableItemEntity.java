package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.common.entities.AbstractCollectionItemEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChargeableItemEntity extends AbstractCollectionItemEntity<ChargeableCategoryEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
