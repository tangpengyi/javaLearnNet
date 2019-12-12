package com.tpy.dao;

import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.ExampleTutorial;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface instanceMapper {

    //修改实例
    public int modifyExample(ExampleTutorial exampleTutorial);
    //修改实例明细
    public int ModifyDetailstutorial(DetailsTutorial detailstutorial);

    /**
     * 查询所有的实例教程
     * @return
     */
    public List<DetailsTutorial> queryAllInstance();


    /**
     * 根据专题和类型查询具体的教程内容
     * @param
     * @return
     */
    public List<DetailsTutorial> queryInstanceBySpecialSubject(String exampleType);


    /**
     * 查询详情实例一共多少条数据
     * @return
     */
    public int queryMaxdetailstutorialCount();


    /**
     * 插入详情模块
     * @param detailstutorial
     * @return
     */
    public int insertDetailstutorial(DetailsTutorial detailstutorial);


    /**
     * 插入实例
     * @param exampleTutorial
     * @return
     */
    public int insertExampleTutorialMapper(ExampleTutorial exampleTutorial);


    /**
     * 查询实例总个数
     * @return
     */
    public int queryexampleTutorialCountMapper();


    /**
     * 根据详情实例编号查询实例信息
     * @param dtNum
     * @return
     */
    public ExampleTutorial selectExampleTutorial(int dtNum);


    /**
     * 根据实例明细编号查询标题
     * @param dtNum
     * @return
     */
    public String selectTitleForDetailsByDtNum(int dtNum);


    /**
     * 根据编号删除实例明细
     * @param dtNum
     * @return
     */
    public int deleteDetailstutorialByNum(int dtNum);


    /**
     * 根据编号删除实例
     * @param tutorialNum
     * @return
     */
    public int deleteexampleTutorialByNum(int tutorialNum);

}
