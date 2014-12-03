/**
* @FileName SmsService.java
* @Package com.igrow.mall.jws.service
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-24 下午11:26:32
* @Version V1.0.1
*/
package com.igrow.mall.jws.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @ClassName SmsService
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-11-24 下午11:26:32
 */
@WebService(targetNamespace = "http://service.canv.com", name = "SmsService", serviceName = "smsService")
public interface SmsService {
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public int UpdateSmsMo(String in0);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String GetSmsMo(String in0,String in1,String in2);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String GetSmsMoney(String in0,String in1,String in2);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String SendSms3(String account,String password,String mobile,String content,String channel,String smsid,String sendType);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String GetRandom(String in0);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String GetChannel();
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public int SendSms2(String account,String password,String random,String mobile,String content,String channel,String smsid,String sendType);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String GetSmsMoney2(String in0,String in1);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String SendSms5(String in0,String in1,String in2,String in3,String in4,String in5,String in6);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String SendTimingSms(String account,String password,String mobile,String content,String channel,String smsid,String sendType);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public int SendSms(String in0,String in1,String in2,String in3,String in4,String in5);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String BatchSendSMS(String in0,String in1,String in2,String in3);
	@WebResult(name="out",targetNamespace="http://service.canv.com")  
	@WebMethod
	public String IsIncludeKeyWord(String in0);
	
	
	
	
}
