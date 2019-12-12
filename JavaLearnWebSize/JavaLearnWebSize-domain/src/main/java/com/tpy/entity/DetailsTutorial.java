package com.tpy.entity;


/**
 * 实例详情
 */

public class DetailsTutorial {

    private int dtNum;//编号
    private String specialSubject;//专题
    private String exampleType;//类型
    private String title;//题目
    private String context;//实例内容
    private String explainContext;//实例讲解
    private String runResult;//运行结果
    private String filePath;//代码附件路径
    private int isDelete;//是否删除

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

    public String getSpecialSubject() {
        return specialSubject;
    }

    public void setSpecialSubject(String specialSubject) {
        this.specialSubject = specialSubject;
    }

    public String getExampleType() {
        return exampleType;
    }

    public void setExampleType(String exampleType) {
        this.exampleType = exampleType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExplainContext() {
        return explainContext;
    }

    public void setExplainContext(String explainContext) {
        this.explainContext = explainContext;
    }

    public String getRunResult() {
        return runResult;
    }

    public void setRunResult(String runResult) {
        this.runResult = runResult;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "DetailsTutorial{" +
                "specialSubject='" + specialSubject + '\'' +
                ", exampleType='" + exampleType + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", explainContext='" + explainContext + '\'' +
                ", runResult='" + runResult + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
