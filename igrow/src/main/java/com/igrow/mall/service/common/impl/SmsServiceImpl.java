/**
* @FileName SmsServiceImpl.java
* @Package com.igrow.mall.service.common.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午9:53:50
* @Version V1.0.1
*/
package com.igrow.mall.service.common.impl;

import java.io.StringWriter;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;


import com.igrow.mall.bean.common.Setting;
import com.igrow.mall.bean.common.SmsMDClient;
import com.igrow.mall.bean.entity.MessageSendLog;
import com.igrow.mall.bean.entity.MessageTemplate;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.SystemEnums;
import com.igrow.mall.common.enums.SystemEnums.MessagePassage;
import com.igrow.mall.common.enums.SystemEnums.SmsBusinessType;
import com.igrow.mall.common.enums.SystemEnums.SmsSupplier;
import com.igrow.mall.common.util.TemplateUtils;
import com.igrow.mall.service.common.intf.SmsService;
import com.igrow.mall.ws.intf.MessageSendLogWs;
import com.igrow.mall.ws.intf.MessageTemplateWs;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @ClassName SmsServiceImpl
 * @Description TODO【短信服务接口实现】
 * @Author Brights
 * @Date 2013-10-29 上午9:53:50
 */
@Service("smsServiceImpl")
public class SmsServiceImpl implements SmsService {
	
	@Resource(name = "messageTemplateWsImpl")
	private MessageTemplateWs messageTemplateWs;
	@Resource(name = "messageSendLogWsImpl")
	private MessageSendLogWs messageSendLogWs;
	@Resource(name = "smsMdClient")
	private SmsMDClient smsMdClient;//漫道
	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	@Resource(name = "setting")
	private Setting setting;

	@Override
	public int sendSyncSms(String[] mobiles, String content,
			SmsBusinessType sbType) {
		return sendSms(mobiles, content, sbType.getPriority());
	}

	@Override
	public int sendSyncSms(String[] mobiles,
			SmsBusinessType sbType, String tCode, Map<String, Object> data) {
		int status = -1;
		try {
			MessageTemplate smsTemplate = messageTemplateWs.findByCode(tCode);
			if(smsTemplate != null){
				Configuration configuration = TemplateUtils.getConfiguration();
				StringTemplateLoader loader = new StringTemplateLoader();
				loader.putTemplate(smsTemplate.getCode(), smsTemplate.getContent(), smsTemplate.getModifyDate().getTime());
				configuration.setTemplateLoader(loader);
				Template template = configuration.getTemplate(smsTemplate.getCode());
				StringWriter writer = new StringWriter();
				template.process(data, writer);
				status = sendSms(mobiles, writer.toString(), sbType.getPriority());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	* @Title sendSms
	* @Description TODO【发送短信】
	* @return 
	* @Return int 返回类型
	* @Throws 
	*/ 
	public int sendSms(String[] mobiles,String content,Integer priority){
		int status = -1;
		SmsSupplier ssr = getSmsSupplier(setting.getSmsSupplier());
		if(mobiles!= null && mobiles.length > 0 && StringUtils.isNotBlank(content) && priority != null){
			//Client smsClient = EmaySmsUtils.getSmsClient();
			if(ssr == SmsSupplier.MD){
				status = smsMdClient.sendSMS(mobiles, content,priority);
			}else if(ssr == SmsSupplier.emay){
				//status = smsEmayClient.sendSMS(mobiles, content,priority);
			}else{
				status = smsMdClient.sendSMS(mobiles, content,priority);
			}
		}
		//插入短信日志
		saveSmsSendLog(mobiles,content,status,ssr);
		return status;
	}
	
	@Override
	public void sendAsyncSms(String[] mobiles, String content,
			SmsBusinessType sbType){
		try {
			addSendAsyncSmsTask(mobiles,content,sbType.getPriority());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendAsyncSms(String[] mobiles, SmsBusinessType sbType,
			String tCode, Map<String, Object> data) {
		try {
			System.out.println("code="+tCode);
			MessageTemplate smsTemplate = messageTemplateWs.findByCode(tCode);
			System.out.println("code="+tCode);
			if(smsTemplate != null){
				Configuration configuration = TemplateUtils.getConfiguration();
				StringTemplateLoader loader = new StringTemplateLoader();
				loader.putTemplate(smsTemplate.getCode(), smsTemplate.getContent(), smsTemplate.getModifyDate().getTime());
				configuration.setTemplateLoader(loader);
				Template template = configuration.getTemplate(smsTemplate.getCode());
				StringWriter writer = new StringWriter();
				template.process(data, writer);
				
				addSendAsyncSmsTask(mobiles,writer.toString(),sbType.getPriority());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title addSendAsyncMailTask
	* @Description TODO【增加异步发送任务】
	* @param subject
	* @param content
	* @param toMails 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void addSendAsyncSmsTask(final String[] mobiles,final String content,final Integer priority) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					sendSms(mobiles,content,priority);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title saveSmsSendLog
	* @Description TODO【保存短信发送日志】
	* @param mobile
	* @param content
	* @param status 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void saveSmsSendLog(String[] mobiles,String content,int status,SmsSupplier ssr){
		MessageSendLog entity = new MessageSendLog();
		entity.setContent("供应商："+ssr.getCode()+ "|内容：" +content);
		if(mobiles != null && mobiles.length > 0){
			StringBuffer sb = new StringBuffer();
			for(String mail: mobiles){
				sb.append(mail);
				sb.append(",");
			}
			entity.setMobile(sb.toString());
		}
		entity.setStatus(String.valueOf(status));
		entity.setPassage(MessagePassage.SMS.getDesc());
		entity.setCreateOperator(SystemConstants.AUTO_OPERATOR);
		entity.setModifyOperator(SystemConstants.AUTO_OPERATOR);
		messageSendLogWs.insert(entity);
	}
	
	/**
	* @Title getSmsSupplier
	* @Description TODO【短信供应商】
	* @return 
	* @Return SmsSupplier 返回类型
	* @Throws 
	*/ 
	public SmsSupplier getSmsSupplier(String code){
		if(StringUtils.isNotBlank(code)){
			SmsSupplier smsSupplier = SmsSupplier.codeOf(code);
			if(smsSupplier != null){
				return smsSupplier;
			}
		}
		return SystemEnums.SmsSupplier.MD;
	}

	
	

}
