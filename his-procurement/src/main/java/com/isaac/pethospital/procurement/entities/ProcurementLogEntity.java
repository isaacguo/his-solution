package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProcurementLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    ProcurementEntity  procurement;

    String comment;
    LocalDateTime submittedData;

}
