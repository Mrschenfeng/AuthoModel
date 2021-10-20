package com.coderfeng.auth.bo;

import com.coderfeng.auth.constants.TokenConstant;
import com.coderfeng.auth.dto.AuthRequestDTO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author CoderFeng
 * @date 2021/10/16 12:32
 */
public class AuthTokenBo {
    private Integer appId;
    private String token;
    private Long timestamp;

    public AuthTokenBo(Integer appId, String token, Long timestamp) {
        this.appId = appId;
        this.token = token;
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public static AuthTokenBo voToBo(AuthRequestDTO requestDTO){
        return new AuthTokenBo(requestDTO.getAppId(),requestDTO.getToken(),requestDTO.getCreateTime());
    }

    public static AuthTokenBo createToken(Integer appId,String password,Long createTime){
        String str = appId + password + createTime;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        if (md != null) {
            md.update(str.getBytes());
        }
        // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
        return new AuthTokenBo(appId,new BigInteger(1, md.digest()).toString(16),createTime);
    }

    public static boolean isExpire(Long nowTime,Long createTime){
        // 超时，验证失败
        return nowTime - createTime >= TokenConstant.DEFAULT_EXPIRE_TIME;
    }

    public static boolean compare(String token1,String token2){
        return token1.equals(token2);
    }
}
