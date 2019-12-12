package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.entity.DetailsTutorial;
import com.tpy.service.ModifyDetailstutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyDetailstutorialServiceImpl implements ModifyDetailstutorialService {

    private instanceMapper mapper;
    @Autowired
    public void setMapper(instanceMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public int modifyDetailstutorial(DetailsTutorial detailsTutorial) {
        int i = mapper.ModifyDetailstutorial(detailsTutorial);
        return i;
    }
}
