package com.tpy.controller;

import com.tpy.entity.User;
import com.tpy.service.Impl.userServiceImpl;
import com.tpy.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class loginController {



    @Qualifier("userServiceImpl")
    private userService userServiceImpl;
    @Autowired
    public void setUserServiceImpl(com.tpy.service.Impl.userServiceImpl impl){
        this.userServiceImpl = impl;
    }

    @RequestMapping(value = {"login",""}, method = RequestMethod.GET)
    public String loginPage(){

        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response){

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userServiceImpl.queryUserService(account,password);

        if(user == null){
            request.setAttribute("message","账号或密码错误！");
            return "login";
        }

        System.out.println(user);

        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        return "home";//test
    }


    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "quitLogin",method = RequestMethod.GET)
    public String quitLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("User");
        return "login";
    }


}
