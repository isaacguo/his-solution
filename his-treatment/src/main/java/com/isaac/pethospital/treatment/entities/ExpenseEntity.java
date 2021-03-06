package com.isaac.pethospital.treatment.entities;

import javax.persistence.*;

@Entity
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    PetOwnerEntity petOwner;

}
