package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.service.QtitleForDetailsByDtNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QtitleForDetailsByDtNumServiceImpl implements QtitleForDetailsByDtNumService {

    private instanceMapper mapper;
    @Autowired
    public void setMapper(instanceMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public String queryTitleForDetailsByDtNumService(int dtNum) {
        String title = mapper.selectTitleForDetailsByDtNum(dtNum);
        return title;
    }
}
