package com.ineunet.knife.util;

import javax.crypto.SecretKey;

public class CryptUtilsTests {

	public static void main(String[] args) {
		SecretKey key = CryptUtils.createSecretKey("DES");
		// 用密匙加密信息"Hello world!"
		String str1 = CryptUtils.encryptToDES(key, "Hello");
		System.out.println("使用des加密信息Hello为:" + str1);
		// 使用这个密匙解密
		String str2 = CryptUtils.decryptByDES(key, str1);
		System.out.println("解密后为：" + str2);
	}
	
}
