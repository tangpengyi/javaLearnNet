package com.tpy.service.Impl;

import com.tpy.dao.userMapper;
import com.tpy.entity.ExampleTutorial;
import com.tpy.service.QueryUserAllExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryUserAllExampleServiceImpl implements QueryUserAllExampleService {


    private userMapper mapper;
    @Autowired
    public void setMapper(userMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ExampleTutorial> queryUserAllExample(int userId) {
        List<ExampleTutorial> exampleTutorials = mapper.selectUserAllExampleTutorial(userId);
        return exampleTutorials;
    }
}
