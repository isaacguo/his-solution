package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProcurementApprovalEntity {

    @ManyToOne
    @JsonBackReference("ProcurementEntity-ProcurementApprovalEntity")
    ProcurementEntity procurement;
    String stage;
    LocalDateTime reviewedDateTime;
    LocalDateTime createdDateTime;
    boolean reviewResult;
    String comments;
    String reviewer;
    String reviewerFullName;
    boolean reviewed;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getReviewerFullName() {
        return reviewerFullName;
    }

    public void setReviewerFullName(String reviewerFullName) {
        this.reviewerFullName = reviewerFullName;
    }

    public boolean isReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(boolean reviewResult) {
        this.reviewResult = reviewResult;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcurementEntity getProcurement() {
        return procurement;
    }

    public void setProcurement(ProcurementEntity procurement) {
        this.procurement = procurement;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public LocalDateTime getReviewedDateTime() {
        return reviewedDateTime;
    }

    public void setReviewedDateTime(LocalDateTime reviewedDateTime) {
        this.reviewedDateTime = reviewedDateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
