/**
* @FileName RedirectUrlUtil.java
* @Package com.igrow.mall.common.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014-5-5 上午9:52:49
* @Version V1.0.1
*/
package com.igrow.mall.common.util;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.bean.common.Setting;
import com.igrow.mall.common.constant.SystemConstants;

/**
 * @ClassName RedirectUrlUtil
 * @Description TODO【重定向工具类】
 * @Author Brights
 * @Date 2014-5-5 上午9:52:49
 */
public class RedirectUrlUtil {
	
	@SuppressWarnings("unused")
	private static Setting setting;
	
	static{
		setting = (Setting) SpringUtil.getBean("setting");
	}
	
	/**
	* @Title getRequestUrl
	* @Description TODO【获取请求地址】
	* @param sn
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getRequestUrl(String sn){
		StringBuffer urlsb = new StringBuffer();
		if(StringUtils.isNotBlank(sn)){
			//urlsb.append(setting.getSystemMallUrl());
			urlsb.append(SystemConstants.SLASH_DELIMITER);
			urlsb.append(SystemConstants.REDIRECT_URL_HTM);
			urlsb.append(SystemConstants.SLASH_DELIMITER);
			urlsb.append(sn);
			urlsb.append(SystemConstants.PAYMENT_NOTIFY_SUFFIX);
		}
		System.out.println(urlsb.toString());
		return urlsb.toString();
	}
	
	
	public static String getRedirectUrl(String url){
		StringBuffer urlsb = new StringBuffer();
		if(StringUtils.isNotBlank(url)){
			String urlLower = url.toLowerCase();
			System.out.println(urlLower);
			if(urlLower.contains(SystemConstants.HTTP_LOWER)){
				urlsb.append(url.trim());
				System.out.println(urlsb.toString());
				return urlsb.toString();
			}else{
				urlsb.append(SystemConstants.HTTP_LOWER);
				urlsb.append(url.trim());
				System.out.println(urlsb.toString());
				return urlsb.toString();
			}
		}
		return urlsb.toString();
	}
	
}
