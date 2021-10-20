package com.coderfeng.auth.dao;

import com.coderfeng.auth.entity.UserEntity;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:22
 */
public interface UserDao {

    /**
     * 根据用户 appId 返回用户
     * @param appId 用户名
     * @return 用户实体类
     */
    UserEntity queryById(long appId);
}
