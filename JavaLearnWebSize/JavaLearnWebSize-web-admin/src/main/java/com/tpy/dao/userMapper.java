package com.tpy.dao;

import com.tpy.entity.ExampleTutorial;
import com.tpy.entity.User;
import org.springframework.stereotype.Repository;

import java.net.UnknownServiceException;
import java.util.List;

@Repository
public interface userMapper {

    /**
     * 根据用户账号查询用户
     * @param account
     * @return 返回所有用户
     */
    public List<User> selectUserByAccount(String account);
//    public String selectUserByAccount(String account);

    /**
     * 根据用户编号查询用户
     * @param userNum
     * @return
     */
    public User selectUserByUserNum(int userNum);

    /**
     * 根据用户编号查询所有的用户实例
     * @param userId
     * @return
     */
    public List<ExampleTutorial> selectUserAllExampleTutorial(int userId);

}
