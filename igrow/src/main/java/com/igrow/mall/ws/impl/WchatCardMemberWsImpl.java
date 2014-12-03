/**
* @FileName WchatCardMemberWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:18:12
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igrow.mall.bean.entity.WchatCardInfo;
import com.igrow.mall.bean.entity.WchatCardMemberDetail;
import com.igrow.mall.bean.entity.WchatCardOrderDetail;
import com.igrow.mall.dao.mybatis.intf.WchatCardMemberDao;
import com.igrow.mall.ws.intf.WchatCardInfoWs;
import com.igrow.mall.ws.intf.WchatCardMemberWs;
import com.igrow.mall.ws.intf.WchatCardOrderWs;

/**
 * @ClassName WchatCardMemberWsImpl
 * @Description TODO【会员微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:18:12
 */
@Service("wchatCardMemberWsImpl")
public class WchatCardMemberWsImpl extends BaseWsImpl<WchatCardMemberDetail, String> implements
		WchatCardMemberWs {
	@Resource(name = "wchatCardMemberDao")
	private WchatCardMemberDao wchatCardMemberDao;

	@Resource(name = "wchatCardMemberDao")
	public void setBaseDao(WchatCardMemberDao wchatCardMemberDao) {
		super.setBaseDao(wchatCardMemberDao);
	}
	
	@Resource(name = "wchatCardInfoWsImpl")
	private WchatCardInfoWs wchatCardInfoWs;
	@Resource(name = "wchatCardOrderWsImpl")
	private WchatCardOrderWs wchatCardOrderWs;

	/**
	* @Title userGetCard
	* @Description 
	* @param detail
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardMemberWs#userGetCard(com.igrow.mall.bean.entity.WchatCardMemberDetail)
	*/ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public synchronized boolean userGetCard(WchatCardMemberDetail detail,List<WchatCardMemberDetail> details ) {
		if(detail != null){
			HashMap values = new HashMap();
			values.put("id", detail.getCardId());
			values.put("code", detail.getCardCode());
			WchatCardMemberDetail entity = wchatCardMemberDao.findByCardAndCode(values);
			if(entity == null){ //不存在领取记录，card code
				super.insert(detail);
				//更新领取数量
			}else{ //存在领取记录
				entity.setCardCode(detail.getCardCode());
				entity.setCardId(detail.getCardId());
				entity.setFromOpenId(detail.getFromOpenId());
				entity.setIsGive(detail.getIsGive());
				entity.setOpenId(detail.getOpenId());
				entity.setStatus(detail.getStatus()); //0-未试用
				super.update(entity);
			}
			if(detail.getIsGive() == 0){ //不为转赠，更新领取数
				WchatCardInfo cardInfo = wchatCardInfoWs.findByCardId(detail.getCardId());
				if(cardInfo !=null){
					if(cardInfo.getTotalGetQuantity()  == null){
						cardInfo.setTotalGetQuantity(0L);
					}
					cardInfo.setTotalGetQuantity(cardInfo.getTotalGetQuantity() + 1L);
					wchatCardInfoWs.update(cardInfo);
				}
			}else if(detail.getIsGive() == 1){  //为转赠，设置已转赠用户卡券已转赠
				if(details != null && details.size() >0){
					for(WchatCardMemberDetail cardMember : details){
						if(cardMember != null && cardMember.getStatus() == 3){ //为转赠的记录
							super.update(cardMember);
							//WchatCardMemberDetail entity = wchatCardMemberDao.find(cardMember.getId());
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	* @Title userDelCard
	* @Description 
	* @param detail
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardMemberWs#userDelCard(com.igrow.mall.bean.entity.WchatCardMemberDetail)
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean userDelCard(WchatCardMemberDetail detail) {
		if(detail != null){
			HashMap values = new HashMap();
			values.put("id", detail.getCardId());
			values.put("code", detail.getCardCode());
			WchatCardMemberDetail entity = wchatCardMemberDao.findByCardAndCode(values);
			if(entity != null){
				wchatCardMemberDao.delete(entity);
			}
			return true; 
		}
		return false;
	}

	/**
	* @Title findByCardAndCode
	* @Description 
	* @param values
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardMemberWs#findByCardAndCode(java.util.HashMap)
	*/ 
	@SuppressWarnings("rawtypes")
	@Override
	public WchatCardMemberDetail findByCardAndCode(HashMap values) {
		return wchatCardMemberDao.findByCardAndCode(values);
	}

	/**
	* @Title isCardByOpenId
	* @Description 
	* @param openId
	* @param amount
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardMemberWs#isCardByOpenId(java.lang.String, java.math.BigDecimal)
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean isCardByOpenId(String openId, BigDecimal amount) {
		HashMap values = new HashMap();
		values.put("openid", openId);
		values.put("amount", amount);
		values.put("status", 0);
		Long  count = wchatCardMemberDao.getCountBy(values);
		if(count != null && count > 0){
			return true;
		}
		return false;
	}

	/**
	* @Title consume
	* @Description 
	* @param cardId
	* @param cardCode
	* @return
	* @see com.igrow.mall.ws.intf.WchatCardMemberWs#consume(java.lang.String, java.lang.String)
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public synchronized boolean consume(String cardId, String cardCode,String openid,WchatCardOrderDetail cardOrderDetail) {
		if(StringUtils.isNotBlank(cardId) 
				&& StringUtils.isNotBlank(cardCode) 
					&& StringUtils.isNotBlank(openid)){
			HashMap values = new HashMap();
			values.put("id", cardId);
			values.put("code", cardCode);
			WchatCardMemberDetail entity = wchatCardMemberDao.findByCardAndCode(values);
			if(entity == null){
				 entity = new WchatCardMemberDetail();
				 entity.setCardCode(cardCode);
				 entity.setCardId(cardId);
				 entity.setIsGive(0);
				 entity.setOpenId(openid);
				 entity.setStatus(2); //已核销
				 super.insert(entity);
			}else{
				entity.setStatus(2); //已核销
				super.update(entity);
			}
			//更新卡片使用数量
			WchatCardInfo cardInfo = wchatCardInfoWs.findByCardId(cardId);
			if(cardInfo !=null){
				if(cardInfo.getTotalUseQuantity()  == null){
					cardInfo.setTotalUseQuantity(0L);
				}
				cardInfo.setTotalUseQuantity(cardInfo.getTotalUseQuantity() + 1L);
				wchatCardInfoWs.update(cardInfo);
			}
			//更新卡券订单状态
			WchatCardOrderDetail cardOrder =  wchatCardOrderWs.find(cardOrderDetail.getId());
			if(cardOrder != null){
				cardOrder.setStatus(2);
				wchatCardOrderWs.update(cardOrder);
			}
			
			return true;
		}
		return false;
	}
	
	

}
