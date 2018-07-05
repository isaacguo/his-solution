package com.isaac.pethospital.common.dtos;

import com.isaac.pethospital.common.enums.OperationEnum;

public class ChargeItemOperationMesassge {

    OperationEnum operationEnum;
    String uuid;
    String source;

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public void setOperationEnum(OperationEnum operationEnum) {
        this.operationEnum = operationEnum;
    }

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
}
