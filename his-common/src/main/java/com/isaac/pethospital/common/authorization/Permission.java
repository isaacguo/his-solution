package com.isaac.pethospital.common.authorization;


public class Permission {
    public Permission(String employee, String salary, String crud) {

    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private String domain;
    private String subdomain;
    private String action;


}
