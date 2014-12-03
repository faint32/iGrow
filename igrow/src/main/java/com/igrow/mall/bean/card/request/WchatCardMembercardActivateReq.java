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
 * @ClassName WchatCardMembercardActivateReq
 * @Description TODO【会员卡-激活/绑定会员卡】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */

			/*商户调用接口创建会员卡（1.1 创建卡券）获取card_id，并将会员卡下发给用户，用户领取后需
			激活/绑定update 会员卡编号及积分信息。会员卡暂不支持转赠。
			激活/绑定会员卡支持以下两种方式：
			1.用户点击卡券内“bind_old_card_url”、“activate_url”跳转商户自定义的H5 页面，填写相
			关身份认证信息后，商户调用接口，完成激活/绑定。
			2.商户已知用户身份或无需进行绑定等操作，用户领取会员卡后，商户后台即时调用“激活/绑定
			会员卡”接口update 会员卡编号及积分信息。
			注：code 与会员卡编号membership_number 为一一对应关系。商户在调用相关查询、交易接
			口时，需使用code 字段。*/

public class WchatCardMembercardActivateReq  implements Serializable{
	
	/*支持会员卡激活或绑定，update会员卡编号及积分信息。*/
	
	private static final long serialVersionUID = 1815507224430008415L;
	public final String  req_url = "https://api.weixin.qq.com/card/membercard/activate?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("init_bonus")
	@JsonProperty("init_bonus")
	private Long initBonus;  //初始积分，不填为0。
	
	@XStreamAlias("init_balance")
	@JsonProperty("init_balance")
	private Long initBalance;	//初始余额，不填为0。
	
	@XStreamAlias("membership_number")
	@JsonProperty("membership_number")
	private String membershipNumber;	//必填，会员卡编号，作为序列号显示在用户的卡包里。
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;		//创建会员卡时获取的code。
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;		//卡券ID。自定义code 的会员卡必填card_id，非自定义code 的会员卡不必填。

	/**
	 * @return the initBonus
	 */
	public Long getInitBonus() {
		return initBonus;
	}

	/**
	 * @param initBonus the initBonus to set
	 */
	public void setInitBonus(Long initBonus) {
		this.initBonus = initBonus;
	}

	/**
	 * @return the initBalance
	 */
	public Long getInitBalance() {
		return initBalance;
	}

	/**
	 * @param initBalance the initBalance to set
	 */
	public void setInitBalance(Long initBalance) {
		this.initBalance = initBalance;
	}

	/**
	 * @return the membershipNumber
	 */
	public String getMembershipNumber() {
		return membershipNumber;
	}

	/**
	 * @param membershipNumber the membershipNumber to set
	 */
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

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
	
	
	
	
	

}
