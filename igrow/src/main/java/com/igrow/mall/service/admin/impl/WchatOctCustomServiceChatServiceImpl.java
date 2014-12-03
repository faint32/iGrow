/**
* @FileName WchatOctCustomServiceChatServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午11:00:23
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctCustomServiceChatDetail;
import com.igrow.mall.service.admin.intf.WchatOctCustomServiceChatService;
import com.igrow.mall.ws.intf.WchatOctCustomServiceChatWs;

/**
 * @ClassName WchatOctCustomServiceChatServiceImpl
 * @Description TODO【微信多客服会话记录】
 * @Author brights
 * @Date 2014年10月18日 上午11:00:23
 */
@Service("wchatOctCustomServiceChatServiceImpl")
public class WchatOctCustomServiceChatServiceImpl extends
		BaseServiceImpl<WchatOctCustomServiceChatDetail, String> implements WchatOctCustomServiceChatService {

	@Resource(name = "wchatOctCustomServiceChatWsImpl")
	public void setBaseWs( WchatOctCustomServiceChatWs wchatOctCustomServiceChatWs) {
		super.setBaseWs(wchatOctCustomServiceChatWs);
	}
	
	
}
