package com.isaac.pethospital.common.dtos;

import com.isaac.pethospital.common.enums.OperationEnum;

public class JmsEmployeeOperationRequest {

    OperationEnum operation;
    Long uid;
    String username;
    String userAccount;

    public JmsEmployeeOperationRequest() {
    }

    public JmsEmployeeOperationRequest(OperationEnum operation, Long uid, String username, String userAccount) {
        this.operation = operation;
        this.uid = uid;
        this.username = username;
        this.userAccount = userAccount;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

}
