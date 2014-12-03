/**
* @FileName EmailService.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午9:18:48
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

import java.util.Map;

/**
 * @ClassName EmailWs
 * @Description TODO【电子邮件服务】
 * @Author Brights
 * @Date 2013-10-13 下午9:18:48
 */
public interface EmailService {
	
	/**
	* @Title syncSendMail
	* @Description TODO【依据模板发送邮件】
	* @param subject
	* @param tCode
	* @param data
	* @param toMail 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void sendSyncMail(String subject, String tCode, Map<String, Object> data, String toMails[]);
	
	/**
	* @Title syncSendMail
	* @Description TODO【依据内容发送邮件】
	* @param subject
	* @param content
	* @param toMail 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void sendSyncMail(String subject, String content, String toMails[]);
	
	/**
	* @Title asyncSendMail
	* @Description TODO【依据模板异步发送邮件】
	* @param subject
	* @param tCode
	* @param data
	* @param toMail 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void sendAsyncMail(String subject, String tCode, Map<String, Object> data, String toMails[]);
	
	/**
	* @Title syncSendMail
	* @Description TODO【依据内容异步发送邮件】
	* @param subject
	* @param content
	* @param toMail 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void sendAsyncMail(String subject, String content, String toMails[]);
	

}
