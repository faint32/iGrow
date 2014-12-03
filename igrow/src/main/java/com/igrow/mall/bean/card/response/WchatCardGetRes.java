/**
* @FileName WchatCardGetRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午1:07:55
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.card.Card;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardGetRes
 * @Description TODO【查询卡券详情-请求返回】
 * @Author brights
 * @Date 2014年10月22日 下午1:07:55
 */
public class WchatCardGetRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = -7003674408509488286L;
	
	@XStreamAlias("card")
	@JsonProperty("card")
	private Card card;

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
