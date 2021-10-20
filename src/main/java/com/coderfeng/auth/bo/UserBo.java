package com.coderfeng.auth.bo;

import com.coderfeng.auth.entity.UserEntity;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:34
 */
public class UserBo {

    private Integer appId;
    private String password;

    public UserBo(Integer appId, String password) {
        this.appId = appId;
        this.password = password;
    }

    public Integer getAppId() {
        return appId;
    }

    public String getPassword() {
        return password;
    }

    public static UserBo entityToBo(UserEntity entity){
        return new UserBo(entity.getAppId(),entity.getPassword());
    }
}
