package com.isaac.pethospital.common.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financePriceItemOperationQueue;
    String financeChargeItemOperationQueue;
    String procurementApprovalPassedTopic;
    String treatmentGenerateMedicalTestOrderTopic;
    String employeeUseraccountOperationTopic;

    public String getTreatmentGenerateMedicalTestOrderTopic() {
        return treatmentGenerateMedicalTestOrderTopic;
    }

    public void setTreatmentGenerateMedicalTestOrderTopic(String treatmentGenerateMedicalTestOrderTopic) {
        this.treatmentGenerateMedicalTestOrderTopic = treatmentGenerateMedicalTestOrderTopic;
    }

    public String getProcurementApprovalPassedTopic() {
        return procurementApprovalPassedTopic;
    }

    public void setProcurementApprovalPassedTopic(String procurementApprovalPassedTopic) {
        this.procurementApprovalPassedTopic = procurementApprovalPassedTopic;
    }

    public String getEmployeeUseraccountOperationTopic() {
        return employeeUseraccountOperationTopic;
    }

    public void setEmployeeUseraccountOperationTopic(String employeeUseraccountOperationTopic) {
        this.employeeUseraccountOperationTopic = employeeUseraccountOperationTopic;
    }

    public String getFinancePriceItemOperationQueue() {
        return financePriceItemOperationQueue;
    }

    public void setFinancePriceItemOperationQueue(String financePriceItemOperationQueue) {
        this.financePriceItemOperationQueue = financePriceItemOperationQueue;
    }

    public String getFinanceChargeItemOperationQueue() {
        return financeChargeItemOperationQueue;
    }

    public void setFinanceChargeItemOperationQueue(String financeChargeItemOperationQueue) {
        this.financeChargeItemOperationQueue = financeChargeItemOperationQueue;
    }
}
