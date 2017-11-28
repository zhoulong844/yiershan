package com.yiershan.manager.dao;

import com.yiershan.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: zhoulong
 * @date: 2017/11/17
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 5873501092596017309L;

    @Column(name = "name", length = 20 ,unique = true)
    public String name;

    @Column(name = "password", length = 64)
    public String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
