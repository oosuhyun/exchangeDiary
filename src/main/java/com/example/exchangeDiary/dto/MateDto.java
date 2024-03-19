package com.example.exchangeDiary.dto;

public class MateDto {

    private String requestMate;
    private String responseMate;
    private String status;

    public String getRequestMate() {
        return requestMate;
    }
    public void setRequestMate(String requestMate) {
        this.requestMate = requestMate;
    }
    public String getResponseMate() {
        return responseMate;
    }
    public void setResponseMate(String responseMate) {
        this.responseMate = responseMate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MateDto [requestMate=" + requestMate + ", responseMate=" + responseMate + ", status=" + status + "]";
    }
}
