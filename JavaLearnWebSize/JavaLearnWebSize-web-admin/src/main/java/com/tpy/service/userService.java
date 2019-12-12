package com.tpy.service;

import com.tpy.entity.User;

public interface userService {

    /**
     * 根据用户账号和密码查询用户是否存在，存在返回用户，不存在返回null
     * @return
     */
    public User queryUserService(String userName,String userPwd);

    /**
     * 根据用户编号查询用户
     * @param userNum
     * @return
     */
    public User queryUserByUserNum(int userNum);



}
