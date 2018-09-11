package com.isaac.pethospital.common.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financePriceItemOperationQueue;
    String financeChargeItemOperationQueue;
    String financeChargeItemOperationReplyTopic;
    String financeChargeStatusChangedTopic;
    String procurementApprovalPassedTopic;
    String treatmentGenerateMedicalTestOrderTopic;
    String treatmentGenerateMedicineDispenseOrderTopic;
    String employeeUseraccountOperationTopic;
    String medicalTestCreateReportTopic;
    String medicalTestRemovedReportTopic;
    String pharmacyMedicineDispenseCreateTopic;

    public String getPharmacyMedicineDispenseCreateTopic() {
        return pharmacyMedicineDispenseCreateTopic;
    }

    public void setPharmacyMedicineDispenseCreateTopic(String pharmacyMedicineDispenseCreateTopic) {
        this.pharmacyMedicineDispenseCreateTopic = pharmacyMedicineDispenseCreateTopic;
    }

    public String getTreatmentGenerateMedicineDispenseOrderTopic() {
        return treatmentGenerateMedicineDispenseOrderTopic;
    }

    public void setTreatmentGenerateMedicineDispenseOrderTopic(String treatmentGenerateMedicineDispenseOrderTopic) {
        this.treatmentGenerateMedicineDispenseOrderTopic = treatmentGenerateMedicineDispenseOrderTopic;
    }

    public String getFinanceChargeStatusChangedTopic() {
        return financeChargeStatusChangedTopic;
    }

    public void setFinanceChargeStatusChangedTopic(String financeChargeStatusChangedTopic) {
        this.financeChargeStatusChangedTopic = financeChargeStatusChangedTopic;
    }

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
