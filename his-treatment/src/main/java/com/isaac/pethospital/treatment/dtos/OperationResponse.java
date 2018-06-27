package com.isaac.pethospital.treatment.dtos;

public class OperationResponse<T> {

    T content;
    boolean success;
    String message;

    public OperationResponse()
    {

    }
    public OperationResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public OperationResponse(boolean success) {
        this(success,"");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
