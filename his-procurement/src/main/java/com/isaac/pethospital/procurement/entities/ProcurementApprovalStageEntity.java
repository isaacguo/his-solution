package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class ProcurementApprovalStageEntity {

    String stage;
    @OneToOne(mappedBy = "previousStage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("next-previous")
    ProcurementApprovalStageEntity nextStage;
    @OneToOne
    @JsonBackReference("next-previous")
    ProcurementApprovalStageEntity previousStage;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public ProcurementApprovalStageEntity getNextStage() {
        return nextStage;
    }

    public void setNextStage(ProcurementApprovalStageEntity nextStage) {
        if(nextStage==null)
            throw new RuntimeException("Next Stage is null");
        nextStage.setPreviousStage(this);
        this.nextStage = nextStage;
    }

    public ProcurementApprovalStageEntity getPreviousStage() {
        return previousStage;
    }

    public void setPreviousStage(ProcurementApprovalStageEntity previousStage) {
        this.previousStage = previousStage;
    }
}
