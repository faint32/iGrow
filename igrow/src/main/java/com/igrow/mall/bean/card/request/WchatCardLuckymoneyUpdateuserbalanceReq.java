/**
* @FileName GeneralCouponCard.java
* @Package com.igrow.mall.bean.card.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:43:59
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardLuckymoneyUpdateuserbalanceReq
 * @Description TODO【红包-更新红包金额】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */

public class WchatCardLuckymoneyUpdateuserbalanceReq  implements Serializable{
	
	/*支持领取红包后通过调用“更新红包”接口update 红包余额。*/
	private static final long serialVersionUID = -3161749518036321859L;
	public final String  req_url = "https://api.weixin.qq.com/card/luckymoney/updateuserbalance?access_token=TOKEN"; //请求地址
	
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;		//红包的序列号
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;		//自定义code 的卡券必填。非自定义code 可不填。
	
	
	@XStreamAlias("balance")
	@JsonProperty("balance")
	private Long balance;		//红包余额


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}


	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	/**
	 * @return the balance
	 */
	public Long getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	

}
