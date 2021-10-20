package com.coderfeng.auth;

import com.coderfeng.auth.bo.AuthTokenBo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class AuthApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testMd5Encode(){
		Integer appId = 1001;
		String password = "mylove520";
		Long createTime = (long)1634360255;
		String str = appId + password + createTime;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return;
		}
		// 计算md5函数

		md.update(str.getBytes());


		System.out.println(new BigInteger(1, md.digest()).toString(16));
		// digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		//一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
	}
}
