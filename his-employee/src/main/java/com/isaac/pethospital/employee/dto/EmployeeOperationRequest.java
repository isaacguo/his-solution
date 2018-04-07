package com.isaac.pethospital.employee.dto;

public class EmployeeOperationRequest {

    String userAccount;
    String searchByTitle;
    String fullName;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getSearchByTitle() {
        return searchByTitle;
    }

    public void setSearchByTitle(String searchByTitle) {
        this.searchByTitle = searchByTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
