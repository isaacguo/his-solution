package com.isaac.pethospital.employee.jms;

import com.isaac.pethospital.employee.services.EmployeeService;

//@Component
public class EmployeeListener {

    private final EmployeeService employeeService;

    public EmployeeListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /*
    @JmsListener(destination = "${jms.procurement-approval-passed-topic}")
    public void processMessage(Long procurementId) throws Exception {
        this.procurementService.approvalPassed(procurementId);
    }
    */
}
