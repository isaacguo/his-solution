package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DailyCareRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nurseName;
    @Column(length = 1024)
    String comment;


    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    @OneToMany(mappedBy = "dailyCareRecord")
    @JsonManagedReference("DailyCareRecordEntity-medicineList")
    List<DailyCareMedicineEntity> medicineList = new LinkedList<>();

    @ManyToOne
    @JsonBackReference("dailyCare-dailyCareRecord")
    DailyCareEntity dailyCare;


}
