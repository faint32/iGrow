/**
* @FileName MemberCard.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午5:20:38
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName MemberCard
 * @Description TODO【会员卡】
 * @Author brights
 * @Date 2014年10月21日 下午5:20:38
 */
@XStreamAlias("member_card")
public class MemberCardInfoUpdate implements Serializable {
	
	private static final long serialVersionUID = 3266271153149647015L;
	public static final String  CARD_TYPE = "MEMBER_CARD"; //卡类型-会员卡

	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoUpdate baseInfo; //基本的卡券数据
	
	@XStreamAlias("bonus_cleared")
	@JsonProperty("bonus_cleared")
	private String bonusCleared; //积分清零规则
	
	@XStreamAlias("bonus_rules")
	@JsonProperty("bonus_rules")
	private String bonusRules; //积分规则
	
	@XStreamAlias("balance_rules")
	@JsonProperty("balance_rules")
	private String balanceRules; //储值说明
	
	@XStreamAlias("prerogative")
	@JsonProperty("prerogative")
	private String prerogative; //特权说明

	/**
	 * @return the baseInfo
	 */
	public BaseInfoUpdate getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfoUpdate baseInfo) {
		this.baseInfo = baseInfo;
	}

	/**
	 * @return the bonusCleared
	 */
	public String getBonusCleared() {
		return bonusCleared;
	}

	/**
	 * @param bonusCleared the bonusCleared to set
	 */
	public void setBonusCleared(String bonusCleared) {
		this.bonusCleared = bonusCleared;
	}

	/**
	 * @return the bonusRules
	 */
	public String getBonusRules() {
		return bonusRules;
	}

	/**
	 * @param bonusRules the bonusRules to set
	 */
	public void setBonusRules(String bonusRules) {
		this.bonusRules = bonusRules;
	}

	/**
	 * @return the balanceRules
	 */
	public String getBalanceRules() {
		return balanceRules;
	}

	/**
	 * @param balanceRules the balanceRules to set
	 */
	public void setBalanceRules(String balanceRules) {
		this.balanceRules = balanceRules;
	}

	/**
	 * @return the prerogative
	 */
	public String getPrerogative() {
		return prerogative;
	}

	/**
	 * @param prerogative the prerogative to set
	 */
	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}
	
	

}
