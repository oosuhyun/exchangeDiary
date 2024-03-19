package com.example.exchangeDiary.dto;

import java.sql.Date;

public class UserInfoDto {
    private String userId;
    private String userPw;
    private String userName;
    private Date userBirth;
    private String userPhone;
    private String userEmail;
    private String isAd;
    private Date date;
    private String status;

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
    public Date getUserBirth() {
        return userBirth;
    }
    public void setUserBirth(Date userBirth) {
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfoDto [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userBirth="
                + userBirth + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", isAd=" + isAd + ", date="
                + date + ", status=" + status + "]";
    }
}
