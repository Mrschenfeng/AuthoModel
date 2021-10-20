package com.coderfeng.auth.service.impl;

import com.coderfeng.auth.bo.AuthTokenBo;
import com.coderfeng.auth.bo.UserBo;
import com.coderfeng.auth.dto.AuthRequestDTO;
import com.coderfeng.auth.service.AuthService;
import com.coderfeng.auth.service.UserService;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author CoderFeng
 * @date 2021/10/16 10:46
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService service = new UserServiceImpl();

    @Override
    public Boolean auth(AuthRequestDTO request) {
        String clientToken = request.getToken();
        Integer appId = request.getAppId();
        Long createTime = request.getCreateTime();
        Long nowTime = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        if(AuthTokenBo.isExpire(nowTime,createTime)){
            // 超时，验证失败
            return  false;
        }
        UserBo userBo = service.queryById(appId);
        if(userBo == null){
            // 找不到实体，验证失败
            return false;
        }
        AuthTokenBo serverToken = AuthTokenBo.createToken(userBo.getAppId(), userBo.getPassword(), createTime);

        return AuthTokenBo.compare(clientToken,serverToken.getToken());
    }



}
