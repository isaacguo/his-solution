package com.isaac.pethospital.common.jms.finance;

import com.isaac.pethospital.common.enums.OperationEnum;

public class PriceItemOperationMessage {

    OperationEnum operationEnum;


    String uuid;
    String source;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }

}
