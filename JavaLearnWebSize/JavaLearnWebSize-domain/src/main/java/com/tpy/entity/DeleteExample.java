package com.tpy.entity;

public class DeleteExample {

    private int tutorialNum;//实例编号
    private int dtNum;//实例明细编号
    private String title;//文章名称
    private String userName;//作者名称
    private String uploadTime;//上传时间

    public int getTutorialNum() {
        return tutorialNum;
    }

    public void setTutorialNum(int tutorialNum) {
        this.tutorialNum = tutorialNum;
    }

    public int getDtNum() {
        return dtNum;
    }

    public void setDtNum(int dtNum) {
        this.dtNum = dtNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "DeleteExample{" +
                "tutorialNum=" + tutorialNum +
                ", dtNum=" + dtNum +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                '}';
    }
}
