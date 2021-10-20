package com.coderfeng.auth.dao.impl;

import com.coderfeng.auth.dao.UserDao;
import com.coderfeng.auth.entity.UserEntity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * 模仿数据访问层
 * @author CoderFeng
 * @date 2021/10/16 10:23
 */
public class UserDaoImpl implements UserDao {

    private static Map<Long,UserEntity> map = new HashMap<>();

    static{
        map.put((long) 1001,new UserEntity(1001,"mylove520", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        map.put((long) 1002,new UserEntity(1002,"mylove", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        map.put((long) 1003,new UserEntity(1003,"520", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        map.put((long) 1004,new UserEntity(1004,"test", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
    }

    @Override
    public UserEntity queryById(long appId) {
        return map.get(appId);
    }
}
