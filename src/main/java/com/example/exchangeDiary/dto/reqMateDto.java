package com.example.exchangeDiary.dto;

public class reqMateDto {

    private String userId;
    private String mateId;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMateId() {
        return mateId;
    }
    public void setMateId(String mateId) {
        this.mateId = mateId;
    }

    @Override
    public String toString() {
        return "reqMateDto [userId=" + userId + ", mateId=" + mateId + "]";
    }
}
