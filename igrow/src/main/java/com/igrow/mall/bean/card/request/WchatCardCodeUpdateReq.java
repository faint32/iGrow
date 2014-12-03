/**
* @FileName WchatCardCodeGetReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:41:50
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeGetReq
 * @Description TODO【更改code-请求】
 * @Author brights
 * @Date 2014年10月22日 下午12:41:50
 */
public class WchatCardCodeUpdateReq  implements Serializable{
	
		/*	为确保转赠后的安全性，微信允许自定义code的商户对已下发的code进行更改。
		注：为避免用户疑惑，建议仅在发生转赠行为后（发生转赠后，微信会通过事件推送的方式告
		知商户被转赠的卡券code）对用户的code进行更改。*/
	
	private static final long serialVersionUID = 7031761862557092584L;
	public final String  req_url = "https://api.weixin.qq.com/card/code/update?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;  //卡券的code 编码
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //卡券ID
	
	@XStreamAlias("new_code")
	@JsonProperty("new_code")
	private String newCode;  //新的卡券code 编码

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
	 * @return the newCode
	 */
	public String getNewCode() {
		return newCode;
	}

	/**
	 * @param newCode the newCode to set
	 */
	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}

}
