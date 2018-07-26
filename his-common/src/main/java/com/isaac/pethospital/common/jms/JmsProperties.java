package com.isaac.pethospital.common.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financePriceItemOperationQueue;
    String financeChargeItemOperationQueue;
    String financeChargeItemOperationReplyTopic;
    String procurementApprovalPassedTopic;
    String treatmentGenerateMedicalTestOrderTopic;
    String employeeUseraccountOperationTopic;
    String medicalTestCreateReportTopic;
    String medicalTestRemovedReportTopic;

    public String getMedicalTestRemovedReportTopic() {
        return medicalTestRemovedReportTopic;
    }

    public void setMedicalTestRemovedReportTopic(String medicalTestRemovedReportTopic) {
        this.medicalTestRemovedReportTopic = medicalTestRemovedReportTopic;
    }

    public String getMedicalTestCreateReportTopic() {
        return medicalTestCreateReportTopic;
    }

    public void setMedicalTestCreateReportTopic(String medicalTestCreateReportTopic) {
        this.medicalTestCreateReportTopic = medicalTestCreateReportTopic;
    }

    public String getFinanceChargeItemOperationReplyTopic() {
        return financeChargeItemOperationReplyTopic;
    }

    public void setFinanceChargeItemOperationReplyTopic(String financeChargeItemOperationReplyTopic) {
        this.financeChargeItemOperationReplyTopic = financeChargeItemOperationReplyTopic;
    }

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
