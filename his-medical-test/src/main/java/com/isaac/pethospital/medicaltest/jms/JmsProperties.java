package com.isaac.pethospital.medicaltest.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financeChargeItemOperationQueue;

    public String getFinanceChargeItemOperationQueue() {
        return financeChargeItemOperationQueue;
    }

    public void setFinanceChargeItemOperationQueue(String financeChargeItemOperationQueue) {
        this.financeChargeItemOperationQueue = financeChargeItemOperationQueue;
    }
}
