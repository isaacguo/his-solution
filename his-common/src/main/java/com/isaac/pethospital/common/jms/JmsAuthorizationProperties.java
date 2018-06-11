package com.isaac.pethospital.common.jms;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsAuthorizationProperties {

    String employeeUseraccountOperationTopic;

    public String getEmployeeUseraccountOperationTopic() {
        return employeeUseraccountOperationTopic;
    }

    public void setEmployeeUseraccountOperationTopic(String employeeUseraccountOperationTopic) {
        this.employeeUseraccountOperationTopic = employeeUseraccountOperationTopic;
    }
}
