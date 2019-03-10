package com.isaac.pethospital.gateway.dtos;

public class EmployeeOperationRequest {

    String loginAccount;
    String password;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
