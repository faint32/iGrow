/**
* @FileName WchatCardMemberServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:25:57
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.card.request.WchatCardCodeGetReq;
import com.igrow.mall.bean.card.response.WchatCardCodeGetRes;
import com.igrow.mall.bean.entity.WchatCardMemberDetail;
import com.igrow.mall.common.wchat.WchatRequestBean;
import com.igrow.mall.service.admin.intf.WchatCardMemberService;
import com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService;
import com.igrow.mall.ws.intf.WchatCardMemberWs;

/**
 * @ClassName WchatCardMemberServiceImpl
 * @Description TODO【会员微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:25:57
 */
@Service("wchatCardMemberServiceImpl")
public class WchatCardMemberServiceImpl extends BaseServiceImpl<WchatCardMemberDetail, String>
		implements WchatCardMemberService {
	@Resource(name = "wchatCardMemberWsImpl")
	private WchatCardMemberWs wchatCardMemberWs;

	@Resource(name = "wchatCardMemberWsImpl")
	public void setBaseWs(WchatCardMemberWs wchatCardMemberWs) {
		super.setBaseWs(wchatCardMemberWs);
	}
	
	
	@Resource(name = "wchatCardCodeProcessServiceImpl")
	private WchatCardCodeProcessService wchatCardCodeProcessService;

	/**
	* @Title userGetCard
	* @Description 
	* @param wchatRequest
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatCardMemberService#userGetCard(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public boolean userGetCard(WchatRequestBean wchatRequest) {
		if(wchatRequest  != null){
			WchatCardMemberDetail entity = new WchatCardMemberDetail();
			entity.setCardCode(wchatRequest.getUserCardCode());
			entity.setCardId(wchatRequest.getCardId());
			entity.setOpenId(wchatRequest.getFromUserName());
			entity.setIsGive(wchatRequest.getIsGiveByFriend());
			entity.setFromOpenId(wchatRequest.getFriendUserName());
			entity.setStatus(0); //未试用
			return wchatCardMemberWs.userGetCard(entity,null);
		}
		return false;
	}
	
	/**
	* @Title userGetCardGiveByFriend
	* @Description 
	* @param wchatRequest
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatCardMemberService#userGetCardGiveByFriend(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public boolean userGetCardGiveByFriend(WchatRequestBean wchatRequest) {
		if(wchatRequest  != null && wchatRequest.getIsGiveByFriend() == 1){ //转赠
			List<WchatCardMemberDetail> cardMembers  = new ArrayList<WchatCardMemberDetail>();
			//查询转赠好友的本地库所有卡券
			HashMap values = new HashMap();
			if(StringUtils.isNotBlank(wchatRequest.getFriendUserName()) && StringUtils.isNotBlank(wchatRequest.getCardId()) ){
				values.put("openid", wchatRequest.getFriendUserName());
				values.put("cardid", wchatRequest.getCardId());
				values.put("status", 0);
				List<WchatCardMemberDetail> cardMemberTemps = wchatCardMemberWs.findListBy(values);
				if(cardMemberTemps != null && cardMemberTemps.size() > 0){
					for(WchatCardMemberDetail cardMember : cardMemberTemps){
						if(cardMember != null && StringUtils.isNotBlank(cardMember.getCardCode())){
							//调用接口获取code信息和所属的用户
							WchatCardCodeGetReq req = new WchatCardCodeGetReq();
							req.setCode(cardMember.getCardCode());
							WchatCardCodeGetRes res = wchatCardCodeProcessService.get(req);
							if(res != null && res.getErrcode() == 0){
								if(res.getOpenid().equals(cardMember.getOpenId())){ //判断该领取的卡code所属的用户是否相同
									continue;
								}else{
									cardMember.setStatus(3); //已转赠
									cardMembers.add(cardMember); //进行标识已
								}
							}
						}
					}
				}
			}
			WchatCardMemberDetail entity = new WchatCardMemberDetail();
			entity.setCardCode(wchatRequest.getUserCardCode());
			entity.setCardId(wchatRequest.getCardId());
			entity.setOpenId(wchatRequest.getFromUserName());
			entity.setIsGive(wchatRequest.getIsGiveByFriend());
			entity.setFromOpenId(wchatRequest.getFriendUserName());
			entity.setStatus(0); //未试用
			return wchatCardMemberWs.userGetCard(entity,cardMembers);
		}
		return false;
	}

	/**
	* @Title userDelCard
	* @Description 
	* @param wchatRequest
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatCardMemberService#userDelCard(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public boolean userDelCard(WchatRequestBean wchatRequest) {
		if(wchatRequest  != null){
			WchatCardMemberDetail entity = new WchatCardMemberDetail();
			entity.setCardCode(wchatRequest.getUserCardCode());
			entity.setCardId(wchatRequest.getCardId());
			entity.setOpenId(wchatRequest.getFromUserName());
			entity.setIsGive(wchatRequest.getIsGiveByFriend());
			entity.setFromOpenId(wchatRequest.getFriendUserName());
			return wchatCardMemberWs.userDelCard(entity);
		}
		return false;
	}

	/**
	* @Title isCardByOpenId
	* @Description 
	* @param openId
	* @param amount
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatCardMemberService#isCardByOpenId(java.lang.String, java.math.BigDecimal)
	*/ 
	@Override
	public boolean isCardByOpenId(String openId, BigDecimal amount) {
		return wchatCardMemberWs.isCardByOpenId(openId, amount);
	}


	
	

}
