package com.yiershan.manager.mapper;


import com.yiershan.manager.dao.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * @author: zhoulong
 * @date: 2017/11/16
 */
public interface IUserMapper extends Mapper<User> {

    String getId();

}
