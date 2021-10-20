package com.coderfeng.auth.service;

import com.coderfeng.auth.dto.AuthRequestDTO;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:43
 */
public interface AuthService {
    /**
     * 验证接口请求权限
     * @param request 请求
     * @return 验证结果
     */
    Boolean auth(AuthRequestDTO request);
}
