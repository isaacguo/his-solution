package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.treatment.common.enums.CaseStatusEnum;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class TreatmentCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private CaseStatusEnum caseStatus;

}
