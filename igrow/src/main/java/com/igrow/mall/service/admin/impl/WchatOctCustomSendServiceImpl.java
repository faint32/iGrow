/**
* @FileName WchatOctCustomSendServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午10:55:10
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;
import com.igrow.mall.service.admin.intf.WchatOctCustomSendService;
import com.igrow.mall.ws.intf.WchatOctCustomSendWs;

/**
 * @ClassName WchatOctCustomSendServiceImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月18日 上午10:55:10
 */
@Service("wchatOctCustomSendServiceImpl")
public class WchatOctCustomSendServiceImpl extends BaseServiceImpl<WchatOctCustomSendDetail, String>
		implements WchatOctCustomSendService {
	@Resource(name = "wchatOctCustomSendWsImpl")
	private WchatOctCustomSendWs wchatOctCustomSendWs;
	
	@Resource(name = "wchatOctCustomSendWsImpl")
	public void setBaseWs(WchatOctCustomSendWs wchatOctCustomSendWs) {
		super.setBaseWs(wchatOctCustomSendWs);
	}

	/**
	* @Title findLastBy
	* @Description 
	* @param operId
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatOctCustomSendService#findLastBy(java.lang.String)
	*/ 
	@Override
	public WchatOctCustomSendDetail findLastBy(String operId) {
		return wchatOctCustomSendWs.findLastBy(operId);
	}

}
