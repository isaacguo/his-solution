package com.isaac.pethospital.employee.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String procurementApprovalPassedTopic;

    public String getProcurementApprovalPassedTopic() {
        return procurementApprovalPassedTopic;
    }

    public void setProcurementApprovalPassedTopic(String procurementApprovalPassedTopic) {
        this.procurementApprovalPassedTopic = procurementApprovalPassedTopic;
    }
}
