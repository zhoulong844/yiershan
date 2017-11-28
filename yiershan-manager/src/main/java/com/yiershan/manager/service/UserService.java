package com.yiershan.manager.service;

import com.yiershan.manager.dao.User;
import com.yiershan.manager.mapper.IUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhoulong
 * @date: 2017/11/16
 */
@Service("userService")
public class UserService {

    @Autowired
    private IUserMapper userMapper;

    public List<User> getUser(){
     return  userMapper.selectAll();
    }
}
