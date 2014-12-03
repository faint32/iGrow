/**
* @FileName WchatCardMembercardUpdateuserRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午2:38:09
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardMembercardUpdateuserRes
 * @Description TODO【会员卡-会员卡交易-返回】
 * @Author brights
 * @Date 2014年10月22日 下午2:38:09
 */
public class WchatCardMembercardUpdateuserRes extends BaseRes implements
		Serializable {
	private static final long serialVersionUID = -1430482408691138182L;
	
	@XStreamAlias("result_bonus")
	@JsonProperty("result_bonus")
	private String resultBonus;		//当前用户积分总额
	
	@XStreamAlias("result_balance")
	@JsonProperty("result_balance")
	private String resultBalance;		//当前用户预存总金额
	
	@XStreamAlias("openid")
	@JsonProperty("openid")
	private String openid;		//用户openid

	/**
	 * @return the resultBonus
	 */
	public String getResultBonus() {
		return resultBonus;
	}

	/**
	 * @param resultBonus the resultBonus to set
	 */
	public void setResultBonus(String resultBonus) {
		this.resultBonus = resultBonus;
	}

	/**
	 * @return the resultBalance
	 */
	public String getResultBalance() {
		return resultBalance;
	}

	/**
	 * @param resultBalance the resultBalance to set
	 */
	public void setResultBalance(String resultBalance) {
		this.resultBalance = resultBalance;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	


}
