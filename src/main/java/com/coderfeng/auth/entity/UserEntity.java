package com.coderfeng.auth.entity;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:19
 */
public class UserEntity {
    private Integer appId;
    private String password;
    private Long createTime;

    public UserEntity(Integer appId, String password, Long createTime) {
        this.appId = appId;
        this.password = password;
        this.createTime = createTime;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
