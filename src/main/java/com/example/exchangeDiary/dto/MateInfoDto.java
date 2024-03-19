package com.example.exchangeDiary.dto;

public class MateInfoDto {

    private String mateId;
    private String mateName;

    public String getMateId() {
        return mateId;
    }
    public void setMateId(String mateId) {
        this.mateId = mateId;
    }
    public String getMateName() {
        return mateName;
    }
    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    @Override
    public String toString() {
        return "MateInfoDto [mateId=" + mateId + ", mateName=" + mateName + "]";
    }
}
