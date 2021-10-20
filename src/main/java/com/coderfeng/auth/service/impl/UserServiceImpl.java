package com.coderfeng.auth.service.impl;

import com.coderfeng.auth.bo.UserBo;
import com.coderfeng.auth.dao.UserDao;
import com.coderfeng.auth.dao.impl.UserDaoImpl;
import com.coderfeng.auth.service.UserService;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:35
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserBo queryById(Integer appId) {
        return UserBo.entityToBo(userDao.queryById(appId));
    }
}
