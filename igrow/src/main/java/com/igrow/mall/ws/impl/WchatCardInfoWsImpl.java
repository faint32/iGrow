/**
* @FileName WchatCardInfoWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:14:57
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatCardInfo;
import com.igrow.mall.dao.mybatis.intf.WchatCardInfoDao;
import com.igrow.mall.ws.intf.WchatCardInfoWs;

/**
 * @ClassName WchatCardInfoWsImpl
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:14:57
 */
@Service("wchatCardInfoWsImpl")
public class WchatCardInfoWsImpl extends BaseWsImpl<WchatCardInfo, String> implements
		WchatCardInfoWs {
	@Resource(name = "wchatCardInfoDao")
	private WchatCardInfoDao wchatCardInfoDao;

	@Resource(name = "wchatCardInfoDao")
	public void setBaseDao(WchatCardInfoDao wchatCardInfoDao) {
		super.setBaseDao(wchatCardInfoDao);
	}

	/**
	* @Title findByCardId
	* @Description 
	* @param cardId
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardInfoWs#findByCardId(java.lang.String)
	*/ 
	@Override
	public WchatCardInfo findByCardId(String cardId) {
		return wchatCardInfoDao.findByCardId(cardId);
	}
	
	
	


}
