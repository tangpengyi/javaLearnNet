package com.tpy.service;

import com.tpy.dao.ResourceModelMapper;
import com.tpy.entity.ResourceModel;

import java.util.List;


public interface ResourceService {


    /**
     * 根据编号把下载次数加一
     * @param num
     * @return
     */
    public boolean modifyByFileLoadCount(int num);


    /**
     * 资源添加
     * @param resource
     * @return
     */
    public boolean addResourceModel(ResourceModel resource);


    /**
     * 进入资源下载页面查询几个资源信息
     * @return
     */
    public List<ResourceModel> indexQueryResourceService(String filetype);


    /**
     * 根据资源名称模糊查询
     * @param contextName
     * @return
     */
    public List<ResourceModel> queryResourceByName(String contextName);


    /**
     * 根据编号删除资源
     * @param num
     * @return
     */
    public boolean deleteResourceByNum(int num);

}
