package com.yiershan.manager.controller;

import com.yiershan.manager.dao.User;
import com.yiershan.manager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhoulong
 * @date: 2017/11/15
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    public List<User> getUser(){
        return  UserService.getUser();
    }

}
