package com.isaac.pethospital.common.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jms")
public class JmsProperties {

    String financePriceItemOperationQueue;
    String financeChargeItemOperationQueue;
    String financeChargeItemOperationReplyTopic;
    String financeChargeStatusChangedTopic;
    String financePetRegistrationCreatedTopic;
    String procurementApprovalPassedTopic;
    String treatmentEmployeeGenerateTopic;
    String treatmentGenerateMedicalTestOrderTopic;
    String employeeUseraccountOperationTopic;
    String medicalTestCreateReportTopic;
    String medicalTestRemovedReportTopic;
    String pharmacyPrescriptionCreateTopic;
    String pharmacyPrescriptionRemoveTopic;
    String inventoryPrescriptionDispensedTopic;



    public String getInventoryPrescriptionDispensedTopic() {
        return inventoryPrescriptionDispensedTopic;
    }

    public void setInventoryPrescriptionDispensedTopic(String inventoryPrescriptionDispensedTopic) {
        this.inventoryPrescriptionDispensedTopic = inventoryPrescriptionDispensedTopic;
    }

    public String getPharmacyPrescriptionRemoveTopic() {
        return pharmacyPrescriptionRemoveTopic;
    }

    public void setPharmacyPrescriptionRemoveTopic(String pharmacyPrescriptionRemoveTopic) {
        this.pharmacyPrescriptionRemoveTopic = pharmacyPrescriptionRemoveTopic;
    }

    public String getFinancePetRegistrationCreatedTopic() {
        return financePetRegistrationCreatedTopic;
    }

    public void setFinancePetRegistrationCreatedTopic(String financePetRegistrationCreatedTopic) {
        this.financePetRegistrationCreatedTopic = financePetRegistrationCreatedTopic;
    }

    public String getTreatmentEmployeeGenerateTopic() {
        return treatmentEmployeeGenerateTopic;
    }

    public void setTreatmentEmployeeGenerateTopic(String treatmentEmployeeGenerateTopic) {
        this.treatmentEmployeeGenerateTopic = treatmentEmployeeGenerateTopic;
    }

    public String getPharmacyPrescriptionCreateTopic() {
        return pharmacyPrescriptionCreateTopic;
    }

    public void setPharmacyPrescriptionCreateTopic(String pharmacyPrescriptionCreateTopic) {
        this.pharmacyPrescriptionCreateTopic = pharmacyPrescriptionCreateTopic;
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
