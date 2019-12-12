package com.tpy.entity;


/**
 * 用户
 */
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private int userCharactor;
    private int isDelete;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserCharactor() {
        return userCharactor;
    }

    public void setUserCharactor(int userCharactor) {
        this.userCharactor = userCharactor;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
