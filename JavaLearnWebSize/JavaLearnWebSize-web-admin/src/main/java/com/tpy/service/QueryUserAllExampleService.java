package com.tpy.service;

import com.tpy.entity.ExampleTutorial;

import java.util.List;

public interface QueryUserAllExampleService {

    /**
     * 根据用户Id查询用户所有的实例
     * @return
     */
    public List<ExampleTutorial> queryUserAllExample(int userId);

}
