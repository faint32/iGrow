/**
* @FileName MessageSendLogWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午4:15:58
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.MessageSendLog;
import com.igrow.mall.dao.mybatis.intf.MessageSendLogDao;
import com.igrow.mall.ws.intf.MessageSendLogWs;

/**
 * @ClassName MessageSendLogWsImpl
 * @Description TODO【消息发送日志】
 * @Author Brights
 * @Date 2013-10-28 下午4:15:58
 */
@Service("messageSendLogWsImpl")
public class MessageSendLogWsImpl extends BaseWsImpl<MessageSendLog, String> implements
		MessageSendLogWs {
	@Resource(name = "messageSendLogDao")
	public void setBaseDao(MessageSendLogDao messageSendLogDao) {
		super.setBaseDao(messageSendLogDao);
	}
}
