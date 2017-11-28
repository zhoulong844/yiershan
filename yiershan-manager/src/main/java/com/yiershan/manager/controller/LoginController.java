package com.yiershan.manager.controller;

import com.yiershan.manager.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhoulong
 * @date: 2017/11/23
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

     @Autowired
     public LoginService loginService;

    @RequestMapping(value = { "doLogin" },method = RequestMethod.POST)
    public String login(String userName,String password,HttpServletRequest request, Model model){
      return loginService.login(userName,password);
    }
}
