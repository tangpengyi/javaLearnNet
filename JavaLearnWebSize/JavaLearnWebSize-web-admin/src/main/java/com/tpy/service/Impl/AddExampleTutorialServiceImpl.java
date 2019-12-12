package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.entity.ExampleTutorial;
import com.tpy.service.AddExampleTutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AddExampleTutorialServiceImpl implements AddExampleTutorialService {


    private instanceMapper mapper;

    @Autowired
    public void setMapper(instanceMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public int addExampleTutorialService(ExampleTutorial exampleTutorial) {
        int num = mapper.queryexampleTutorialCountMapper();
        exampleTutorial.setTutorialNum(num+1);
        int i = mapper.insertExampleTutorialMapper(exampleTutorial);

        return i;
    }
}
