package com.tpy.entity;


import java.sql.Date;

/**
 * 实例教程表
 */
public class ExampleTutorial {

    private int tutorialNum;//编号
    private int userId;//用户编号
    private String uploadTime;//上传时间
    private int dtNum;//详细教程编号
    private int isDelete;//是否删除

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTutorialNum() {
        return tutorialNum;
    }

    public void setTutorialNum(int tutorialNum) {
        this.tutorialNum = tutorialNum;
    }


    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getDtNum() {
        return dtNum;
    }

    public void setDtNum(int dtNum) {
        this.dtNum = dtNum;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ExampleTutorial{" +
                "tutorialNum=" + tutorialNum +
                ", userId='" + userId + '\'' +
                ", uploadTime=" + uploadTime +
                ", dtNum=" + dtNum +
                ", isDelete=" + isDelete +
                '}';
    }
}
