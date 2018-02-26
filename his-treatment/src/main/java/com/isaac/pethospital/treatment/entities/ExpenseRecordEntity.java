package com.isaac.pethospital.treatment.entities;

import javax.persistence.*;

@Entity
public class ExpenseRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    PetOwnerEntity petOwner;

}
