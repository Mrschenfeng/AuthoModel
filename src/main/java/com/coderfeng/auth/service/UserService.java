package com.coderfeng.auth.service;

import com.coderfeng.auth.bo.UserBo;
import org.springframework.stereotype.Service;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:34
 */
@Service
public interface UserService {

    /**
     * 根据用户Id查询用户实体
     * @param appId 用户Id
     * @return 用户实体类
     */
    UserBo queryById(Integer appId);
}
