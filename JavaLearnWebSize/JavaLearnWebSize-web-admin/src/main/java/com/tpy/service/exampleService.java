package com.tpy.service;

import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.ExampleTutorial;

import java.util.List;

public interface exampleService {

    /**
     * 查询所有的实例的专题和类型
     */
    public List<DetailsTutorial> queryExampleServiceImpl();


    /**
     * 根据专题和类型查询具体教程内容
     * @param specialSubject
     * @param exampleType
     * @return
     */
    public DetailsTutorial queryTutorialServiceImpl(String specialSubject,String exampleType);


    /**
     * 根据详情实例编号查询实例信息
     * @param dtNum
     * @return
     */
    public ExampleTutorial queryExampleTutorial(int dtNum);
}
