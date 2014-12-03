/**
* @FileName EmailWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午9:22:01
* @Version V1.0.1
*/
package com.igrow.mall.service.common.impl;

import java.io.StringWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;


import org.apache.commons.lang.StringUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Setting;
import com.igrow.mall.bean.entity.MessageSendLog;
import com.igrow.mall.bean.entity.MessageTemplate;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.SystemEnums.MessagePassage;
import com.igrow.mall.common.util.TemplateUtils;
import com.igrow.mall.service.common.intf.EmailService;
import com.igrow.mall.ws.intf.MessageSendLogWs;
import com.igrow.mall.ws.intf.MessageTemplateWs;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @ClassName EmailWsImpl
 * @Description TODO【邮件接口实现】
 * @Author Brights
 * @Date 2013-10-13 下午9:22:01
 */
@Service("emailServiceImpl")
public class EmailServiceImpl implements EmailService {
	@Resource(name = "javaMailSender")
	private JavaMailSender javaMailSender;
	@Resource(name = "messageTemplateWsImpl")
	private MessageTemplateWs messageTemplateWs;
	@Resource(name = "messageSendLogWsImpl")
	private MessageSendLogWs messageSendLogWs;
	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	@Resource(name = "setting")
	private Setting setting;
	
	@Override
	public void sendSyncMail(String subject, String tCode,
			Map<String, Object> data, String[] toMails) {
		try {
			MessageTemplate emailTemplate = messageTemplateWs.findByCode(tCode);
			if(emailTemplate != null){
				Configuration configuration = TemplateUtils.getConfiguration();
				StringTemplateLoader loader = new StringTemplateLoader();
				loader.putTemplate(emailTemplate.getCode(), emailTemplate.getContent(), emailTemplate.getModifyDate().getTime());
				configuration.setTemplateLoader(loader);
				Template template = configuration.getTemplate(emailTemplate.getCode());
				StringWriter writer = new StringWriter();
				template.process(data, writer);
				sendMail(subject,writer.toString(),toMails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendSyncMail(String subject, String content, String[] toMails) {
		if(StringUtils.isNotBlank(subject) && StringUtils.isNotBlank(content) && toMails != null){
			sendMail(subject,content,toMails);
		}
	}
	
	@Override
	public void sendAsyncMail(String subject, String tCode,
			Map<String, Object> data, String[] toMails) {
		try {
			MessageTemplate emailTemplate = messageTemplateWs.findByCode(tCode);
			if(emailTemplate != null){
				Configuration configuration = TemplateUtils.getConfiguration();
				StringTemplateLoader loader = new StringTemplateLoader();
				loader.putTemplate(emailTemplate.getCode(), emailTemplate.getContent(), emailTemplate.getModifyDate().getTime());
				configuration.setTemplateLoader(loader);
				Template template = configuration.getTemplate(emailTemplate.getCode());
				StringWriter writer = new StringWriter();
				template.process(data, writer);
				addSendAsyncMailTask(subject,writer.toString(),toMails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendAsyncMail(String subject, String content, String[] toMails) {
		try {
			addSendAsyncMailTask(subject,content,toMails);
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
	public void addSendAsyncMailTask(final String subject, final String content, final String[] toMails) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					sendMail(subject,content,toMails);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title sendMail
	* @Description TODO【发送邮件】
	* @param subject
	* @param content
	* @param toMails 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public int sendMail(final String subject, final String content, final String[] toMails){
		int status = -1;
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			mimeMessageHelper.setFrom(MimeUtility.encodeWord(setting.getSystemMallname()) + " <" + setting.getEmailFrom() + ">");
			mimeMessageHelper.setTo(toMails);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content, true);
			javaMailSender.send(mimeMessage);
			status = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		saveEmailSendLog(toMails,content,status);
		return status;
	}
	
	
	/**
	* @Title saveEmailSendLog
	* @Description TODO【保存短信发送日志】
	* @param mobile
	* @param content
	* @param status 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void saveEmailSendLog(String[] toMails,String content,int status){
		MessageSendLog entity = new MessageSendLog();
		entity.setContent(content);
		if(toMails != null && toMails.length > 0){
			StringBuffer sb = new StringBuffer();
			for(String mail: toMails){
				sb.append(mail);
				sb.append(",");
			}
			entity.setEmail(sb.toString());
		}
		entity.setStatus(String.valueOf(status));
		entity.setPassage(MessagePassage.EMAIL.getDesc());
		entity.setCreateOperator(SystemConstants.AUTO_OPERATOR);
		entity.setModifyOperator(SystemConstants.AUTO_OPERATOR);
		messageSendLogWs.insert(entity);
	}


	

}
