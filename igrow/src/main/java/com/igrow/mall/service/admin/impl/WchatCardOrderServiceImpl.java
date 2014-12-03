/**
* @FileName WchatCardOrderServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:29:19
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatCardOrderDetail;
import com.igrow.mall.service.admin.intf.WchatCardOrderService;
import com.igrow.mall.ws.intf.WchatCardOrderWs;

/**
 * @ClassName WchatCardOrderServiceImpl
 * @Description TODO【订单微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:29:19
 */
@Service("wchatCardOrderServiceImpl")
public class WchatCardOrderServiceImpl extends BaseServiceImpl<WchatCardOrderDetail, String> implements
		WchatCardOrderService {
	
	@Resource(name = "wchatCardOrderWsImpl")
	public void setBaseWs(WchatCardOrderWs wchatCardOrderWs) {
		super.setBaseWs(wchatCardOrderWs);
	}
	
	
}
