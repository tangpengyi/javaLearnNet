package com.tpy.dao;

import com.tpy.entity.ResourceModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceModelMapper {

    /**
     * 根据资源编号查询下载次数
     * @param num
     * @return
     */
    public int queryfilecount(int num);

    /**
     * 根据编号修改下载次数
     * @param resourceModel
     * @return
     */
    public int modifyByFileLoadCount(ResourceModel resourceModel);


    /**
     * 增加资源
     * @param resourceModel
     * @return
     */
    public int addResourceMapper(ResourceModel resourceModel);

    /**
     * 根据文件类型查询资源
     * @param filetype
     * @return
     */
    public List<ResourceModel> idnexQueryResource(String filetype);


    /**
     * 根据资源名称模糊查询
     * @param resourceName
     * @return
     */
    public List<ResourceModel> queryResourceByName(String resourceName);


    /**
     * 根据编号删除资源
     * @param num
     * @return
     */
    public int deleteResourceByNum(int num);

}
