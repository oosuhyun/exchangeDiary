package com.example.exchangeDiary.dto;

public class UserSignupReqDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String isAd;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserBirth() {
        return userBirth;
    }
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getIsAd() {
        return isAd;
    }
    public void setIsAd(String isAd) {
        this.isAd = isAd;
    }

    @Override
    public String toString() {
        return "UserSignupReqDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
                + userBirth + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", isAd=" + isAd + "]";
    }
}
