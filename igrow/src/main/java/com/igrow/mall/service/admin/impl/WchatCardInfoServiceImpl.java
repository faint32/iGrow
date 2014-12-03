/**
* @FileName WchatCardInfoServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午3:23:13
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.card.jsapi.WchatJsapiBean;
import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.card.response.card.CashInfo;
import com.igrow.mall.bean.entity.WchatCardInfo;
import com.igrow.mall.service.admin.intf.WchatCardInfoService;
import com.igrow.mall.ws.intf.WchatCardInfoWs;

/**
 * @ClassName WchatCardInfoServiceImpl
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午3:23:13
 */
@Service("wchatCardInfoServiceImpl")
public class WchatCardInfoServiceImpl extends BaseServiceImpl<WchatCardInfo, String> implements
		WchatCardInfoService {
	@Resource(name = "wchatCardInfoWsImpl")
	private WchatCardInfoWs wchatCardInfoWs;

	@Resource(name = "wchatCardInfoWsImpl")
	public void setBaseWs(WchatCardInfoWs wchatCardInfoWs) {
		super.setBaseWs(wchatCardInfoWs);
	}

	/**
	* @Title findByCardId
	* @Description 
	* @param cardId
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatCardInfoService#findByCardId(java.lang.String)
	*/ 
	@Override
	public WchatCardInfo findByCardId(String cardId) {
		return wchatCardInfoWs.findByCardId(cardId);
	}

	/**
	* @Title cardPassCheck
	* @Description 
	* @param res
	* @see com.igrow.mall.service.admin.intf.WchatCardInfoService#cardPassCheck(com.igrow.mall.bean.card.response.WchatCardGetRes)
	*/ 
	@Override
	public void cardPassCheck(WchatCardGetRes res) {
		//优惠券写入到本地数据库中
		if(res != null && res.getCard() != null && res.getErrcode() == 0){
			if(res.getCard().getCardType().equalsIgnoreCase("GENERAL_COUPON")){ //代金券
				//
			}else if(res.getCard().getCardType().equalsIgnoreCase("GROUPON")){
				//
			}else if(res.getCard().getCardType().equalsIgnoreCase("DISCOUNT")){
				//
			}else if(res.getCard().getCardType().equalsIgnoreCase("GIFT")){
				//
			}else if(res.getCard().getCardType().equalsIgnoreCase("CASH")){
				//现金券
				CashInfo cash = res.getCard().getCash();
				if(cash != null && cash.getBaseInfo() != null && cash.getBaseInfo().getSku() != null){
					WchatCardInfo entity = wchatCardInfoWs.findByCardId(cash.getBaseInfo().getId()); //确定本地是否存在该卡券
					if(entity == null){ //不存在，新增加数据
						entity = new WchatCardInfo();
						entity.setCardId(cash.getBaseInfo().getId());
						entity.setCardTitle(cash.getBaseInfo().getTitle());
						entity.setCardType(4);
						entity.setCardTypeName(res.getCard().getCardType());
						if(cash.getReduceCost() != null){
							entity.setReduceCost(new BigDecimal(cash.getReduceCost()/100));
						}
						if(cash.getLeastCost() != null){
							entity.setLeastCost(new BigDecimal(cash.getLeastCost()/100));
						}
						entity.setStatus(cash.getBaseInfo().getStatus());
						entity.setCreateTime(cash.getBaseInfo().getCreateTime());
						entity.setUpdateTime(cash.getBaseInfo().getUpdateTime());
						entity.setCustomUrl(cash.getBaseInfo().getCustomUrl());
						entity.setTotalQuantity(cash.getBaseInfo().getSku().getQuantity());
						entity.setTotalGetQuantity(0L);
						entity.setTotalUseQuantity(0L);
						entity.setTimestamp(cash.getBaseInfo().getCreateTime()); //创建时间
						entity.setSignature(WchatJsapiBean.getWchatBatchAddCardSignature(cash.getBaseInfo().getCreateTime(), cash.getBaseInfo().getId())); //签名
						wchatCardInfoWs.insert(entity);
					}else{  //存在更新数据
						entity.setCardId(cash.getBaseInfo().getId());
						entity.setCardTitle(cash.getBaseInfo().getTitle());
						entity.setCardType(4);
						entity.setCardTypeName(res.getCard().getCardType());
						if(cash.getReduceCost() != null){
							entity.setReduceCost(new BigDecimal(cash.getReduceCost()/100));
						}
						if(cash.getLeastCost() != null){
							entity.setLeastCost(new BigDecimal(cash.getLeastCost()/100));
						}
						entity.setStatus(cash.getBaseInfo().getStatus());
						entity.setCreateTime(cash.getBaseInfo().getCreateTime());
						entity.setUpdateTime(cash.getBaseInfo().getUpdateTime());
						entity.setCustomUrl(cash.getBaseInfo().getCustomUrl());
						entity.setTotalQuantity(cash.getBaseInfo().getSku().getQuantity());
						entity.setTimestamp(cash.getBaseInfo().getCreateTime()); //创建时间
						entity.setSignature(WchatJsapiBean.getWchatBatchAddCardSignature(cash.getBaseInfo().getCreateTime(), cash.getBaseInfo().getId())); //签名
						wchatCardInfoWs.update(entity);
					}
				}
			}else{
				//
			}
		}
	}

	/**
	* @Title cardNotPassCheck
	* @Description 
	* @param res
	* @see com.igrow.mall.service.admin.intf.WchatCardInfoService#cardNotPassCheck(com.igrow.mall.bean.card.response.WchatCardGetRes)
	*/ 
	@Override
	public void cardNotPassCheck(WchatCardGetRes res) {
		cardPassCheck(res);
	}
	
	
}
