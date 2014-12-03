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
public class MemberCardInfoAdd implements Serializable {
	
	private static final long serialVersionUID = 3266271153149647015L;
	public static final String  CARD_TYPE = "MEMBER_CARD"; //卡类型-会员卡

	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	
	@XStreamAlias("supply_bonus")
	@JsonProperty("supply_bonus")
	private Boolean supplyBonus;  //是否支持积分，填写true 或false，如填写true，积分相关字段均为必填。填写false，积分字段无需填写。储值字段处理方式相同。
	@XStreamAlias("supply_balance")
	@JsonProperty("supply_balance")
	private Boolean supplyBalance; //是否支持储值，填写true 或false。
	
	@XStreamAlias("bonus_cleared")
	@JsonProperty("supply_balance")
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
	
	@XStreamAlias("bind_old_card_url")
	@JsonProperty("bind_old_card_url")
	private String bindOldCardUrl; //绑定旧卡的url，与“activate_url”字段二选一必填。
	
	@XStreamAlias("activate_url")
	@JsonProperty("activate_url")
	private String activateUrl; //激活会员卡的url，与“bind_old_card_url”字段二选一必填。

	/**
	 * @return the baseInfo
	 */
	public BaseInfoAdd getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfoAdd baseInfo) {
		this.baseInfo = baseInfo;
	}

	/**
	 * @return the supplyBonus
	 */
	public Boolean getSupplyBonus() {
		return supplyBonus;
	}

	/**
	 * @param supplyBonus the supplyBonus to set
	 */
	public void setSupplyBonus(Boolean supplyBonus) {
		this.supplyBonus = supplyBonus;
	}

	/**
	 * @return the supplyBalance
	 */
	public Boolean getSupplyBalance() {
		return supplyBalance;
	}

	/**
	 * @param supplyBalance the supplyBalance to set
	 */
	public void setSupplyBalance(Boolean supplyBalance) {
		this.supplyBalance = supplyBalance;
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

	/**
	 * @return the bindOldCardUrl
	 */
	public String getBindOldCardUrl() {
		return bindOldCardUrl;
	}

	/**
	 * @param bindOldCardUrl the bindOldCardUrl to set
	 */
	public void setBindOldCardUrl(String bindOldCardUrl) {
		this.bindOldCardUrl = bindOldCardUrl;
	}

	/**
	 * @return the activateUrl
	 */
	public String getActivateUrl() {
		return activateUrl;
	}

	/**
	 * @param activateUrl the activateUrl to set
	 */
	public void setActivateUrl(String activateUrl) {
		this.activateUrl = activateUrl;
	}

}
