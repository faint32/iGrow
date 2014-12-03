package com.igrow.mall.bean.common;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.igrow.mall.common.util.DESUtils;

/**
* @ClassName EncryptPropertyPlaceholderConfigurer
* @Description TODO【配置文件加密字符串解密】
* @Author Brights
* @Date 2013-11-19 上午9:53:00
*/ 
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {	
	public static final String[] ENCRYPT_PROPNAMES = {"db.jdbc.username","db.jdbc.password","db.jdbc.url",
		 "email.username","email.password","sms.md.serial.no","sms.md.key","sms.emay.serial.no","sms.emay.key",
		 "system.login.sms.vcode","alipay.partner","alipay.key","alipay.email","alipay.account.name"}; 
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {		
		if(isEncryptProp(propertyName)){
			return DESUtils.getDecryptString(propertyValue);
		}else{
			return propertyValue;
		}
	}
	
	/**
	* @Title isEncryptProp
	* @Description TODO【判断是否是加密的属性】
	* @param propertyName
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	private boolean isEncryptProp(String propertyName){
		for(String encryptPropName:ENCRYPT_PROPNAMES){
			if(encryptPropName.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}
