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
 * @Description TODO【会员卡-会员卡交易】
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

public class WchatCardMembercardUpdateuserReq  implements Serializable{
	
	/*会员卡交易后每次积分及余额变更需通过接口通知微信，便于后续消息通知及其他扩展功能。*/
	
	private static final long serialVersionUID = 1815507224430008415L;
	public final String  req_url = "https://api.weixin.qq.com/card/membercard/updateuser?access_token=TOKEN"; //请求地址
	
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;		//要消耗的序列号
	
	@XStreamAlias("add_bonus")
	@JsonProperty("add_bonus")
	private Long addBonus;		//需要变更的积分，扣除积分用“-“表示
	
	@XStreamAlias("record_bonus")
	@JsonProperty("record_bonus")
	private String recordBonus;		//商家自定义积分消耗记录，不超过14 个汉字
	
	@XStreamAlias("add_balance")
	@JsonProperty("add_balance")
	private Long addBalance;		//需要变更的余额，扣除金额用“-”表示。单位为分
	
	@XStreamAlias("record_balance")
	@JsonProperty("record_balance")
	private String recordBalance;		//商家自定义金额消耗记录，不超过14 个汉字
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;		//要消耗序列号所述的card_id。自定义code 的会员卡必填

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
	 * @return the addBonus
	 */
	public Long getAddBonus() {
		return addBonus;
	}

	/**
	 * @param addBonus the addBonus to set
	 */
	public void setAddBonus(Long addBonus) {
		this.addBonus = addBonus;
	}

	/**
	 * @return the recordBonus
	 */
	public String getRecordBonus() {
		return recordBonus;
	}

	/**
	 * @param recordBonus the recordBonus to set
	 */
	public void setRecordBonus(String recordBonus) {
		this.recordBonus = recordBonus;
	}

	/**
	 * @return the addBalance
	 */
	public Long getAddBalance() {
		return addBalance;
	}

	/**
	 * @param addBalance the addBalance to set
	 */
	public void setAddBalance(Long addBalance) {
		this.addBalance = addBalance;
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
	 * @return the recordBalance
	 */
	public String getRecordBalance() {
		return recordBalance;
	}

	/**
	 * @param recordBalance the recordBalance to set
	 */
	public void setRecordBalance(String recordBalance) {
		this.recordBalance = recordBalance;
	}

	
	
	
	

}
