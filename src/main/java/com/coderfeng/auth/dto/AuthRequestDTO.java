package com.coderfeng.auth.dto;

/**
 * @description 鉴权请求实体类
 * @author CoderFeng
 * @date 2021/10/16 10:13
 */
public class AuthRequestDTO {
    private String token;
    private Long createTime;
    private Integer appId;

    public AuthRequestDTO(String token, Long createTime, Integer appId) {
        this.token = token;
        this.createTime = createTime;
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public Integer getAppId() {
        return appId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "token='" + token + '\'' +
                ", createTime=" + createTime +
                ", appId=" + appId +
                '}';
    }
}
