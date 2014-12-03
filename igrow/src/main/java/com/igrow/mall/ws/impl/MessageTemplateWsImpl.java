package com.igrow.mall.ws.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.MessageTemplate;
import com.igrow.mall.dao.mybatis.intf.MessageTemplateDao;
import com.igrow.mall.ws.intf.MessageTemplateWs;

@Service("messageTemplateWsImpl")
public class MessageTemplateWsImpl extends BaseWsImpl<MessageTemplate, String> implements
		MessageTemplateWs {
	
	@Resource(name = "messageTemplateDao")
	private MessageTemplateDao messageTemplateDao;
	
	@Resource(name = "messageTemplateDao")
	public void setBaseDao(MessageTemplateDao messageTemplateDao) {
		super.setBaseDao(messageTemplateDao);
	}

	@Override
	public MessageTemplate findByCode(String code) {
		return messageTemplateDao.findByCode(code);
	}

}
