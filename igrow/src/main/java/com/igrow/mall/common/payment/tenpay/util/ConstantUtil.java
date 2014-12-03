package com.igrow.mall.common.payment.tenpay.util;

/**
* @ClassName ConstantUtil
* @Description TODO【参数配置】
* @Author Shiyz
* @Date 2014年5月26日 上午11:10:20
*/ 
public class ConstantUtil {
	/**
	 * 商家可以考虑读取配置文件
	 */
	
	//初始化
	public static String APP_ID = "wxf1dcab5599ff99fb";//微信开发平台应用id
	public static String APP_SECRET = "a431079ba08acb81f2cd283f007d9090";//应用对应的凭证
	//应用对应的密钥//paySignKey
	public static String APP_KEY = "7POsqyg7pXF1uAR6LByodQAxeUjhgy5zTcCkIt2NVvKfX0an66bGrC9nRJfczIwbPatafyxZFO5IONRISOPFNmKU09Zqb97Qkaq72wTa5kPIwU9BQSbdxtakjZU1SLlh";
	
	public static String PARTNER = "1900000109";//财付通商户号
	public static String PARTNER_KEY = "093347685cf05e56b86218a805d009f8";//财付通商户号对应的密钥
	
	
	public static String WAP_APP_ID = "wx8a865f88c23ec791";//微信开发平台应用id
	public static String WAP_APP_SECRET = "daf3f91530d8b66b92f6243aee9643de";//应用对应的凭证
	//应用对应的密钥//paySignKey
	public static String WAP_APP_KEY = "4W1NtCdDMU4UtJk310JNmvKxfbkKvAHgkIKPjvNje6WDez73x6l5Fjq0TueGVAS6mvKj6AES50nX3mOhlJg8pKIuXMgSXameLTgFoMD72ndkHDnAOsyG2saZXtBzFeSh";
	public static String WAP_PARTNER = "1220193001";//财付通商户号
	public static String WAP_PARTNER_KEY = "6810ef8478d19e14086ba70698af0b68";//财付通商户号对应的密钥
	
	
	//参数
	public static String TOKENURL = "https://api.weixin.qq.com/cgi-bin/token";//获取access_token对应的url
	public static String GRANT_TYPE = "client_credential";//常量固定值 
	public static String EXPIRE_ERRCODE = "42001";//access_token失效后请求返回的errcode
	public static String FAIL_ERRCODE = "40001";//重复获取导致上一次获取的access_token失效,返回错误码
	public static String GATEURL = "https://api.weixin.qq.com/pay/genprepay?access_token=";//获取预支付id的接口url
	public static String ACCESS_TOKEN = "access_token";//access_token常量值
	public static String ERRORCODE = "errcode";//用来判断access_token是否失效的值
	public static String SIGN_METHOD = "sha1";//签名算法常量值
	//package常量值
	public static String packageValue = "bank_type=WX&body=%B2%E2%CA%D4&fee_type=1&input_charset=GBK&notify_url=http%3A%2F%2F127.0.0.1%3A8180%2Ftenpay_api_b2c%2FpayNotifyUrl.jsp&out_trade_no=2051571832&partner=1900000109&sign=10DA99BCB3F63EF23E4981B331B0A3EF&spbill_create_ip=127.0.0.1&time_expire=20131222091010&total_fee=1";
	public static String traceid = "testtraceid001";//测试用户id
}
