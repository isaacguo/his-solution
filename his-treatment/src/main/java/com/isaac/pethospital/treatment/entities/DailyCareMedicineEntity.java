package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class DailyCareMedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String medicineName;
    String dosage;  //每日药品剂量
    String medicineSpecification; //药品规格 药品规格就是药品最小包装或最小单体的一个量度值

    @ManyToOne
    @JsonBackReference("DailyCareRecordEntity-medicineList")
    DailyCareMedicineEntity dailyCareRecord;
}
