/**
* @FileName WchatCardCodeConsumeRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:03:47
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.consume.Card;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeConsumeRes
 * @Description TODO【卡券核销-消耗code-请求返回】
 * @Author brights
 * @Date 2014年10月22日 下午12:03:47
 */
public class WchatCardCodeConsumeRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = -6398241965289616404L;
	
	@XStreamAlias("openid")
	@JsonProperty("openid")
	private String openid;  //用户openid
	
	@XStreamAlias("card")
	@JsonProperty("card")
	private Card card; //卡券

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

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}

}
