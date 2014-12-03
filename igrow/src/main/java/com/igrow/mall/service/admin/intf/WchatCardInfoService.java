/**
* @FileName WchatCardInfoService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:09:27
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.entity.WchatCardInfo;

/**
 * @ClassName WchatCardInfoService
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:09:27
 */
public interface WchatCardInfoService extends BaseService<WchatCardInfo, String> {
	
	/**
	* @Title findByCardId
	* @Description TODO【按cardId获取优惠券详情】
	* @param cardId
	* @return 
	* @Return WchatCardInfo 返回类型
	* @Throws 
	*/ 
	public  WchatCardInfo findByCardId(String cardId);
	
	/**
	* @Title cardPassCheck
	* @Description TODO【卡券审核通过】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void cardPassCheck(WchatCardGetRes res);
	
	/**
	* @Title cardPassCheck
	* @Description TODO【卡券审核不通过】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void cardNotPassCheck(WchatCardGetRes res);
	
	
	

}
