package com.isaac.pethospital.procurement.dtos;

public class ProcurementApprovalOperationRequest {

    String comments;
    boolean reviewResult;
    private Long id;
    String userAccount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(boolean reviewResult) {
        this.reviewResult = reviewResult;
    }
}
