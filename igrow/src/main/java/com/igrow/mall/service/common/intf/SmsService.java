/**
* @FileName SmsService.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午9:52:52
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

import java.util.Map;

import com.igrow.mall.common.enums.SystemEnums.SmsBusinessType;

/**
 * @ClassName SmsService
 * @Description TODO【短信发送服务类】
 * @Author Brights
 * @Date 2013-10-29 上午9:52:52
 */
public interface SmsService {
	
	/**
	* @Title sendSms
	* @Description TODO【发送短信】
	* @param mobiles
	* @param content
	* @param sbType
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int sendSyncSms(String[] mobiles,String content,SmsBusinessType sbType);
	
	/**
	* @Title sendSms
	* @Description TODO【短信发送】
	* @param mobile//手机号码
	* @param content//
	* @param sbType
	* @param tCode
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int sendSyncSms(String[] mobiles,SmsBusinessType sbType,String tCode,Map<String, Object> data);
	
	/**
	* @Title sendSms
	* @Description TODO【异步发送短信】
	* @param mobiles
	* @param content
	* @param sbType
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public void sendAsyncSms(String[] mobiles,String content,SmsBusinessType sbType);
	
	/**
	* @Title sendSms
	* @Description TODO【异步发送短信】
	* @param mobile//手机号码
	* @param content//
	* @param sbType
	* @param tCode
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public void sendAsyncSms(String[] mobiles,SmsBusinessType sbType,String tCode,Map<String, Object> data);
}
