package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.services.CrudService;

public interface ChargeService<T,R> extends CrudService<T,R> {

    ChargeReportOperationReplyMessage onGenerateChargeOrderReceived(ChargeReportOperationMessage message);
}
