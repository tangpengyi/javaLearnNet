package com.tpy.service.Impl;

import com.tpy.dao.userMapper;
import com.tpy.entity.User;
import com.tpy.service.userService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {


    private userMapper mapper;

    @Autowired
    public void setMapper(userMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User queryUserService(String userName, String userPwd) {

        List<User> users = mapper.selectUserByAccount(userName);
        if (users.size() == 0) {
            return null;
        }

        for (User user : users) {
            if (StringUtils.equals(user.getUserPwd(), userPwd)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User queryUserByUserNum(int userNum) {
        return mapper.selectUserByUserNum(userNum);
    }
}
