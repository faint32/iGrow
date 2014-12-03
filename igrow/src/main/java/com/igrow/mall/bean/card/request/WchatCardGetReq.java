/**
* @FileName WchatCardGetReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午1:01:08
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardGetReq
 * @Description TODO【查询卡券详情】
 * @Author brights
 * @Date 2014年10月22日 下午1:01:08
 */
public class WchatCardGetReq implements Serializable {
	private static final long serialVersionUID = 4337866825261369978L;
	

	public final String  req_url = "https://api.weixin.qq.com/card/get?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId; //卡券ID

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
