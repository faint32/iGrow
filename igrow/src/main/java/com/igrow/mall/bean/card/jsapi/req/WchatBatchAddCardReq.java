/**
* @FileName WchatbatchAddCard.java
* @Package com.igrow.mall.bean.card.jsapi
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午1:37:20
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi.req;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.jsapi.batchadd.CardInfo;

/**
 * @ClassName WchatBatchAddCardReq
 * @Description TODO【batchAddCard -请求】
 * @Author brights
 * @Date 2014年10月24日 下午1:37:20
 */
public class WchatBatchAddCardReq implements Serializable {
	private static final long serialVersionUID = -1722594539579935192L;
	
	public static final String js_api_name = "batchAddCard";
	
	@JsonProperty("card_list")
	private List<CardInfo> cards;   //卡列表

	/**
	 * @return the cards
	 */
	public List<CardInfo> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<CardInfo> cards) {
		this.cards = cards;
	}

}
