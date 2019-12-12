package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.ExampleTutorial;
import com.tpy.service.exampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class exampleServiceImpl implements exampleService {

    private instanceMapper mapper;
    @Autowired
    public void setInstanceMapper(instanceMapper mapper){
        this.mapper = mapper;
    }


    @Override
    public List<DetailsTutorial> queryExampleServiceImpl() {

        //查询所有专题和类型
        List<DetailsTutorial> detailsTutorials = mapper.queryAllInstance();

        return detailsTutorials;

    }

    @Override
    public DetailsTutorial queryTutorialServiceImpl(String specialSubject, String exampleType) {

        DetailsTutorial detailsTutorial = new DetailsTutorial();
        detailsTutorial.setSpecialSubject(specialSubject);
        detailsTutorial.setExampleType(exampleType);
        System.out.println(detailsTutorial.getExampleType());
        List<DetailsTutorial> d = mapper.queryInstanceBySpecialSubject(detailsTutorial.getExampleType());
        return d.get(0);
    }

    @Override
    public ExampleTutorial queryExampleTutorial(int dtNum) {
        ExampleTutorial exampleTutorial = mapper.selectExampleTutorial(dtNum);
        return  exampleTutorial;
    }
}
