package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommentEntity {


    String uuid;
    String comments;
    LocalDateTime createdDate;
    String uuidOfCommentBy;
    @ManyToOne
    @JsonBackReference("TreatmentCase-Comment")
    TreatmentCaseEntity treatmentCase;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getUuidOfCommentBy() {
        return uuidOfCommentBy;
    }

    public void setUuidOfCommentBy(String uuidOfCommentBy) {
        this.uuidOfCommentBy = uuidOfCommentBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public TreatmentCaseEntity getTreatmentCase() {
        return treatmentCase;
    }

    public void setTreatmentCase(TreatmentCaseEntity treatmentCase) {
        this.treatmentCase = treatmentCase;
    }
}
