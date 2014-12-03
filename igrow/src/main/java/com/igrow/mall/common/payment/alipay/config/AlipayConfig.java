package com.igrow.mall.common.payment.alipay.config;


/**
* @ClassName AlipayConfig
* @Description TODO【支付宝配置】
* @Author Brights
* @Date 2013-11-19 下午9:17:42
*/ 
public class AlipayConfig {
	
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static final String PARTNER = "partner";
	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
	public static final String KEY = "key";
	// 商户的私钥
	public static final String PRIVATE_KEY = "private_key";
	// 支付宝的公钥，无需修改该值
	public static final String APP_ALI_PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	public static final String WAP_ALI_PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHN4QPArGV9GV35Pa8lRl1KybzVJKvN+30MW50T4U/iPmD+SLCifmlDua96CstcXARuAgP9Hoh/LuGcpjjzE4uZ/3AyALv1CNdWT/wueLC5wC2O95PKz6W+mIOG7jzWJ+fns7b4TfzcX7UCzopYEE+NhKR2FaFlel2mvgaKHxykQIDAQAB";
	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "/opt/temp/";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// app签名方式 不需修改
	public static String app_sign_type = "RSA";
	
	// wap签名方式，选择项：0001(RSA)、MD5
	public static String wap_sign_type = "0001";
	public static String wap_sign_type_rsa = "0001";
	public static String wap_sign_type_md5 = "MD5";

}
