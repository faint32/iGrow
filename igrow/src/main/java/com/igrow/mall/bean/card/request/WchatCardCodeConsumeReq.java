/**
* @FileName WchatCardCodeConsumeReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:56:35
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeConsumeReq
 * @Description TODO【卡券核销-消耗code请求】
 * @Author brights
 * @Date 2014年10月22日 上午11:56:35
 */
public class WchatCardCodeConsumeReq implements Serializable {
	 /*	消耗code 接口是核销卡券的唯一接口。
		自定义code（use_custom_code 为true）的优惠券，在code 被核销时，必须调用此接口。用
		于将用户客户端的code 状态变更。
		自定义code 的卡券调用接口时， post 数据中需包含card_id，非自定义code 不需上报。*/
	private static final long serialVersionUID = -1872575477477184238L;
	public final String  req_url = "https://api.weixin.qq.com/card/code/consume?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;  //要消耗的序列号
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //要消耗序列号所述的card_id，创建卡券时use_custom_code 填写true 时必填。非自定义code	不必填写。

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
