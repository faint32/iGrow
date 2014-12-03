/**
* @FileName WchatCardInfoWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:07:35
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.entity.WchatCardInfo;

/**
 * @ClassName WchatCardInfoWs
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:07:35
 */
public interface WchatCardInfoWs extends BaseWs<WchatCardInfo, String> {
	
	/**
	* @Title findByCardId
	* @Description TODO【按cardId获取优惠券详情】
	* @param cardId
	* @return 
	* @Return WchatCardInfo 返回类型
	* @Throws 
	*/ 
	public  WchatCardInfo findByCardId(String cardId);

}
