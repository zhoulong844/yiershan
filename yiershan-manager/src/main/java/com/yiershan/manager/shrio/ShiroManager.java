package com.yiershan.manager.shrio;

import com.yiershan.common.exception.BaseException;
import com.yiershan.common.exception.ServerCode;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhoulong
 * @date: 2017/11/23
 */
public class ShiroManager extends AuthorizingRealm{

        //这里因为没有调用后台，直接默认只有一个用户("spf"，"123456")
        private static final String USER_NAME = "spf";
        private static final String PASSWORD = "123456";

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
            String username = (String) principalCollection.fromRealm(getName()).iterator().next();
            Set<String> roleNames = new HashSet<String>();
            Set<String> permissions = new HashSet<String>();
            roleNames.add("admin");//添加角色
            permissions.add("read");  //添加权限
            System.out.print("12341234234234");
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
            info.setStringPermissions(permissions);
            return info;
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken){
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            System.out.print("12341234234234");
            if(token.getUsername().equals(USER_NAME)){
                return new SimpleAuthenticationInfo(USER_NAME, DigestUtils.md5Hex(PASSWORD), getName());
            }else{
                throw new BaseException(ServerCode.SERVER_UNKNOWN_ERROR);
            }
        }

}
