/**
* @FileName WchatCardOrderWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:20:31
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatCardOrderDetail;
import com.igrow.mall.dao.mybatis.intf.WchatCardOrderDao;
import com.igrow.mall.ws.intf.WchatCardOrderWs;

/**
 * @ClassName WchatCardOrderWsImpl
 * @Description TODO【订单微信卡券明】
 * @Author brights
 * @Date 2014年10月27日 下午3:20:31
 */
@Service("wchatCardOrderWsImpl")
public class WchatCardOrderWsImpl extends BaseWsImpl<WchatCardOrderDetail, String> implements
		WchatCardOrderWs {
	
	@Resource(name = "wchatCardOrderDao")
	public void setBaseDao(WchatCardOrderDao wchatCardOrderDao) {
		super.setBaseDao(wchatCardOrderDao);
	}

}
