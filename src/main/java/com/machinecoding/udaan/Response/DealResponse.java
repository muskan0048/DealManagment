package com.machinecoding.udaan.Response;

public class DealResponse {
    private String message;
    private boolean isSuccess;

    public DealResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
