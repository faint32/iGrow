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
 * @Description TODO【code查询接口-请求】
 * @Author brights
 * @Date 2014年10月22日 下午12:41:50
 */
public class WchatCardCodeGetReq  implements Serializable{
	
/*	为确保转赠后的安全性，微信允许自定义code的商户对已下发的code进行更改。
注：为避免用户疑惑，建议仅在发生转赠行为后（发生转赠后，微信会通过事件推送的方式告
知商户被转赠的卡券code）对用户的code进行更改。*/
	
	private static final long serialVersionUID = 7031761862557092584L;
	public final String  req_url = "https://api.weixin.qq.com/card/code/get?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;  //要查询的序列号
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //要消耗序列号所述的card_id ， 生成券时use_custom_code 填写true 时必填。非自定义code 不必填写。

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
