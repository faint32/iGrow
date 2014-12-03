/**
* @FileName WchatOctCustomSendWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午10:52:15
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;
import com.igrow.mall.dao.mybatis.intf.WchatOctCustomSendDao;
import com.igrow.mall.ws.intf.WchatOctCustomSendWs;

/**
 * @ClassName WchatOctCustomSendWsImpl
 * @Description TODO【微信客服发送消息记录】
 * @Author brights
 * @Date 2014年10月18日 上午10:52:15
 */
@Service("wchatOctCustomSendWsImpl")
public class WchatOctCustomSendWsImpl extends BaseWsImpl<WchatOctCustomSendDetail, String> implements
		WchatOctCustomSendWs {
	@Resource(name = "wchatOctCustomSendDao")
	private WchatOctCustomSendDao wchatOctCustomSendDao;
	
	@Resource(name = "wchatOctCustomSendDao")
	public void setBaseDao(WchatOctCustomSendDao wchatOctCustomSendDao) {
		super.setBaseDao(wchatOctCustomSendDao);
	}

	/**
	* @Title findLastBy
	* @Description 
	* @param operId
	* @return
	* @see com.igrow.mall.ws.intf.WchatOctCustomSendWs#findLastBy(java.lang.String)
	*/ 
	@Override
	public WchatOctCustomSendDetail findLastBy(String operId) {
		return wchatOctCustomSendDao.findLastBy(operId);
	}
	
	
	
}
