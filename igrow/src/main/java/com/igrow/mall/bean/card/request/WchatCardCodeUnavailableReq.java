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
 * @ClassName WchatCardCodeUnavailableReq
 * @Description TODO【设置卡券失效接口-请求】
 * @Author brights
 * @Date 2014年10月22日 下午12:41:50
 */
public class WchatCardCodeUnavailableReq  implements Serializable{
	
		/*	为满足改票、退款等异常情况，可调用卡券失效接口将用户的卡券设置为失效状态。
			注：设置卡券失效的操作不可逆，即无法将设置为失效的卡券调回有效状态，商家须慎重调用该接口。*/
	
	private static final long serialVersionUID = 7031761862557092584L;
	public final String  req_url = "https://api.weixin.qq.com/card/code/unavailable?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;  //需要设置为失效的code
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //自定义code 的卡券必填。非自定义code 的卡	券不填。
	

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
