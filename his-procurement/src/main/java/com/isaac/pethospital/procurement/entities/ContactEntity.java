package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ElementCollection
    List<String> cellphone;

    @ManyToOne
    VendorEntity vendor;

}
