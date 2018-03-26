package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String companyName;
    String address;
    String postcode;
    String legalPerson; //法人
    String description;


    @OneToMany
    List<ContactEntity> contactList=new LinkedList<>();

}
