package com.isaac.pethospital.finance.jms;

//@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financeChargeItemOperationQueue;

    public String getFinanceChargeItemOperationQueue() {
        return financeChargeItemOperationQueue;
    }

    public void setFinanceChargeItemOperationQueue(String financeChargeItemOperationQueue) {
        this.financeChargeItemOperationQueue = financeChargeItemOperationQueue;
    }
}
