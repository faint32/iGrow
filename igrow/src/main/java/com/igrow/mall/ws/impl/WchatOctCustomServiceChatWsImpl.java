/**
* @FileName WchatOctCustomServiceChatWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午10:57:55
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctCustomServiceChatDetail;
import com.igrow.mall.dao.mybatis.intf.WchatOctCustomServiceChatDao;
import com.igrow.mall.ws.intf.WchatOctCustomServiceChatWs;

/**
 * @ClassName WchatOctCustomServiceChatWsImpl
 * @Description TODO【微信多客服会话记录】
 * @Author brights
 * @Date 2014年10月18日 上午10:57:55
 */
@Service("wchatOctCustomServiceChatWsImpl")
public class WchatOctCustomServiceChatWsImpl extends BaseWsImpl<WchatOctCustomServiceChatDetail, String>
		implements WchatOctCustomServiceChatWs {

	@Resource(name = "wchatOctCustomServiceChatDao")
	public void setBaseDao(WchatOctCustomServiceChatDao wchatOctCustomServiceChatDao) {
		super.setBaseDao(wchatOctCustomServiceChatDao);
	}
	
	
}
