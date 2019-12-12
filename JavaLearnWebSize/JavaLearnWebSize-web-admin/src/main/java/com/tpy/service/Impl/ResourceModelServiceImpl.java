package com.tpy.service.Impl;

import com.tpy.dao.ResourceModelMapper;
import com.tpy.entity.ResourceModel;
import com.tpy.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceModelServiceImpl implements ResourceService {

    private ResourceModelMapper mapper;
    @Autowired
    public void setMapper(ResourceModelMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public boolean modifyByFileLoadCount(int num) {
        int count = mapper.queryfilecount(num);
        ResourceModel resourceModel = new ResourceModel();
        resourceModel.setUploadcount(count+1);
        resourceModel.setNum(num);

        return mapper.modifyByFileLoadCount(resourceModel) == 1;
    }

    @Override
    public boolean addResourceModel(ResourceModel resource) {

        return mapper.addResourceMapper(resource) == 1;
    }

    @Override
    public List<ResourceModel> indexQueryResourceService(String filetype) {

        return mapper.idnexQueryResource(filetype);
    }

    @Override
    public List<ResourceModel> queryResourceByName(String contextName) {

        List<ResourceModel> resourceModels = mapper.queryResourceByName(contextName);

        return resourceModels;
    }

    @Override
    public boolean deleteResourceByNum(int num) {
        return mapper.deleteResourceByNum(num) == 1;
    }
}
