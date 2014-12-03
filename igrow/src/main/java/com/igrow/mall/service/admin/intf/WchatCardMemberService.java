/**
* @FileName WchatCardMemberService.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:10:05
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import java.math.BigDecimal;

import com.igrow.mall.bean.entity.WchatCardMemberDetail;
import com.igrow.mall.common.wchat.WchatRequestBean;
import com.igrow.mall.service.admin.intf.BaseService;

/**
 * @ClassName WchatCardMemberService
 * @Description TODO【会员微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:10:05
 */
public interface WchatCardMemberService extends BaseService<WchatCardMemberDetail, String> {
	
	/**
	* @Title userGetCard
	* @Description TODO【领取卡券】
	* @param wchatRequest
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean userGetCard(WchatRequestBean wchatRequest);
	
	/**
	* @Title userGetCardGiveByFriend
	* @Description TODO【领取好友转赠卡券】
	* @param wchatRequest
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean userGetCardGiveByFriend(WchatRequestBean wchatRequest);
	
	/**
	* @Title userDelCard
	* @Description TODO【删除卡券】
	* @param wchatRequest
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean userDelCard(WchatRequestBean wchatRequest);
	
	/**
	* @Title isCardByOpenId
	* @Description TODO【依据订单金额和OPENID确定是否i存在可用的优惠券】
	* @param openId
	* @param amount
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public  boolean isCardByOpenId(String openId,BigDecimal amount);
	
	/**
	* @Title consume
	* @Description TODO【卡片消耗操作】
	* @param cardId
	* @param cardCode
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	//public boolean consume(OrderDetail order,WchatCardOrderDetail cardOrderDetail );

}
