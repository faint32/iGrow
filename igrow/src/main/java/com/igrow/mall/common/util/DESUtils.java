package com.igrow.mall.common.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
* @ClassName DESUtils
* @Description TODO【des加密工具】
* @Author Brights
* @Date 2013-11-19 上午9:48:52
*/ 
public class DESUtils {
	private static Key key;
	private static final String KEY_STR = "!@#$%^&*()bora20120511!@#$%^&*()"; 
	private static final String DES_ALGORITHM = "DES";
	static {
		try {
			//使用SecureRandom生成KEY
			KeyGenerator generator = KeyGenerator.getInstance(DES_ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
			//使用SecretKeyFactory生成KEY
			//SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
		    //DESKeySpec keySpec = new DESKeySpec(KEY_STR.getBytes());
		    //key = keyFactory.generateSecret(keySpec);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	* @Title getEncryptString
	* @Description TODO【对str进行DES加密】
	* @param str
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("utf-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	* @Title getDecryptString
	* @Description TODO【对str进行DES解密】
	* @param str
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getDecryptString(String str) {
		BASE64Decoder base64De = new BASE64Decoder();
		try {
			byte[] strBytes = base64De.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	* @Title main
	* @Description TODO【main方法】
	* @param args
	* @throws Exception 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public static void main(String[] args) throws Exception {
//		if (args == null || args.length < 1) {
//			System.out.println("请输入要加密的字符，用空格分隔.");
//		} else {
//			for (String arg : args) {
//				System.out.println(arg + ":" + getEncryptString(arg));
//			}
//		}
/*		System.out.println("*******************************************************");
		System.out.println("email.username" + ":" + getEncryptString("onect@atbora.com"));
		System.out.println("email.password" + ":" + getEncryptString("what12345"));
		System.out.println("*******************************************************");
		System.out.println("sms.serial.no" + ":" + getEncryptString("6SDK-EMY-6688-JIZPS"));
		System.out.println("sms.key" + ":" + getEncryptString("323679"));
		System.out.println("*******************************************************");
		System.out.println("db.jdbc.username.local" + ":" + getEncryptString("root"));
		System.out.println("db.jdbc.password.local" + ":" + getEncryptString("123456"));
		System.out.println("db.jdbc.url.local" + ":" + getEncryptString("jdbc:mysql://127.0.0.1:3306/hotelMallDbs?useUnicode=true&characterEncoding=utf8"));
		System.out.println("*******************************************************");
		System.out.println("db.jdbc.username.test" + ":" + getEncryptString("root"));
		System.out.println("db.jdbc.password.test" + ":" + getEncryptString("bora20120511"));
		System.out.println("db.jdbc.url.test" + ":" + getEncryptString("jdbc:mysql://192.168.1.100:3306/hotelMallDbs?useUnicode=true&characterEncoding=utf8"));
		System.out.println("db.jdbc.url.test1" + ":" + getEncryptString("jdbc:mysql://192.168.1.100:3306/hotelMallDbsTest?useUnicode=true&characterEncoding=utf8"));
		System.out.println("*******************************************************");
		System.out.println("db.jdbc.username.produce" + ":" + getEncryptString("hotelmalldbadmin"));
		System.out.println("db.jdbc.password.produce" + ":" + getEncryptString("bora20120511"));
		System.out.println("db.jdbc.url.produce" + ":" + getEncryptString("jdbc:mysql://hotelmalldbs.mysql.rds.aliyuncs.com:3333/hotel_mall_dbs?useUnicode=true&characterEncoding=utf8"));
		System.out.println("db.jdbc.url.produceTest" + ":" + getEncryptString("jdbc:mysql://hotelmalldbs.mysql.rds.aliyuncs.com:3333/boramalltest?useUnicode=true&characterEncoding=utf8"));
		System.out.println("db.jdbc.url.produceTest" + ":" + getEncryptString("jdbc:mysql://hotelmalldbs.mysql.rds.aliyuncs.com:3333/boramalltest1?useUnicode=true&characterEncoding=utf8"));
		System.out.println("*******************************************************");
		System.out.println("sms.vcode="+getEncryptString("0000"));
		System.out.println("*******************************************************");
		System.out.println("TEST1="+getDecryptString("B6D+I82dx9UpW4m+EXN5Q0OmmnHYpcQV"));
		System.out.println("TEST2="+getDecryptString("qsnyKEoV0qTELK5v26uvMQ=="));
		System.out.println("*******************************************************");*/
		
	/*	System.out.println("*******************************************************");		
		System.out.println("*******************************************************");
		System.out.println("db.jdbc.username.produce" + ":" + getEncryptString("hotelmalldbadmin"));
		System.out.println("db.jdbc.password.produce" + ":" + getEncryptString("bora20120511"));
		//System.out.println("db.jdbc.url.produce" + ":" + getEncryptString("jdbc:mysql://rdsiuuunivjn6bj.mysql.rds.aliyuncs.com:3306/hotel_mall_dbs?useUnicode=true&characterEncoding=utf8"));
		System.out.println("db.jdbc.url.produce" + ":" + getEncryptString("jdbc:mysql://boramallformal20.mysql.rds.aliyuncs.com:3306/hotel_mall_dbs_20?useUnicode=true&characterEncoding=utf8"));
		System.out.println("*******************************************************");
		System.out.println("*******************************************************");
		*/
		
		//System.out.println("sms.serial.no" + ":" + getEncryptString("SDK-BSY-010-00028"));
		//System.out.println("sms.key" + ":" + getEncryptString("822438"));
		//System.out.println("sms.key" + ":" + getEncryptString("http://sdk.entinfo.cn:8060/webservice.asmx"));
/*		System.out.println("alipay.partner_0" + ":" + "2088011692572096");
		System.out.println("alipay.partner_1" + ":" + getEncryptString("2088011692572096"));
		System.out.println("alipay.key_0" + ":" + "u3ka57h3fchuhf6glf3ri2ba30selehk"); 
		System.out.println("alipay.key_1" + ":" + getEncryptString("u3ka57h3fchuhf6glf3ri2ba30selehk"));
		System.out.println("alipay.email_0" + ":" + "borabora@atbora.com");
		System.out.println("alipay.email_1" + ":" + getEncryptString("borabora@atbora.com"));
		System.out.println("alipay.account.name_)" + ":" + "杭州波拉波拉信息技术有限公司");
		System.out.println("alipay.account.name_1" + ":" + getEncryptString("杭州波拉波拉信息技术有限公司"));*/
		System.out.println("db.jdbc.url.produceTest" + ":" + getEncryptString("jdbc:mysql://hotelmalldbs.mysql.rds.aliyuncs.com:3333/boramalltest1?useUnicode=true&characterEncoding=utf8"));
		
	}
}
