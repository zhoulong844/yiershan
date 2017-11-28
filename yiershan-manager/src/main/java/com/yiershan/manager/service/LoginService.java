package com.yiershan.manager.service;


import com.yiershan.common.exception.BaseException;
import com.yiershan.common.exception.ServerCode;
import com.yiershan.manager.dao.User;
import com.yiershan.manager.mapper.IUserMapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.entity.Example;


/**
 * @author: zhoulong
 * @date: 2017/11/23
 */
@Service
public class LoginService {

    @Autowired
    public IUserMapper userMapper;

    @RequestMapping("login")
    public String login(String userName, String password){

        // 1.判断参数有效性
        Assert.hasText(userName, "用户名不能为空!");
        Assert.hasText(password, "密码不能为空!");
        Example ex = new Example(User.class);
        ex.createCriteria().andEqualTo("name", userName);
        List<User> userList = userMapper.selectByExample(ex);
        if(userList == null || userList.size() <= 0){
            throw new BaseException(ServerCode.USER_NOT_EXISTS);
        }
        if(!DigestUtils.md5Hex(password).equals(userList.get(0).password)){
            throw new BaseException(ServerCode.INVALID_CREDENTIAL,"用户名或密码错误");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(userName, DigestUtils.md5Hex(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "../../../view/index.html";

    }
}
