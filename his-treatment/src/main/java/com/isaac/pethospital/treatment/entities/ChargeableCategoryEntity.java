package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.common.entities.AbstractCollectionEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChargeableCategoryEntity extends AbstractCollectionEntity<ChargeableItemEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
