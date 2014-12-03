/**
* @FileName WchatCardMemberWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:08:11
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.igrow.mall.bean.entity.WchatCardMemberDetail;
import com.igrow.mall.bean.entity.WchatCardOrderDetail;

/**
 * @ClassName WchatCardMemberWs
 * @Description TODO【会员微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:08:11
 */
public interface WchatCardMemberWs extends BaseWs<WchatCardMemberDetail, String> {
	
	/**
	* @Title userGetCard
	* @Description TODO【领取卡券】
	* @param detail
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public  boolean userGetCard(WchatCardMemberDetail detail,	List<WchatCardMemberDetail> cardMembers);
	
	/**
	* @Title userDelCard
	* @Description TODO【删除优惠券】
	* @param detail
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean userDelCard(WchatCardMemberDetail detail);
	
	/**
	* @Title findByCardAndCode
	* @Description TODO【依据CardId和code查询记录】
	* @param values
	* @return 
	* @Return WchatCardMemberDetail 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public WchatCardMemberDetail findByCardAndCode(HashMap values);
	
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
	public boolean consume(String cardId,String cardCode,String openid,WchatCardOrderDetail cardOrderDetail);
}
