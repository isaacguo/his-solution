package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
public class DailyCareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dailyCare")
    @JsonManagedReference("dailyCare-dailyCareRecord")
    List<DailyCareRecordEntity> dailyCareRecords=new LinkedList<>();


}
