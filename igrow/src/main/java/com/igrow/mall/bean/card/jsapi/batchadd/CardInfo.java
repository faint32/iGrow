/**
* @FileName CardInfo.java
* @Package com.igrow.mall.bean.card.h5
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午12:57:05
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi.batchadd;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @ClassName CardInfo
 * @Description TODO【卡信息】
 * @Author brights
 * @Date 2014年10月24日 下午12:57:05
 */
public class CardInfo implements Serializable {
	private static final long serialVersionUID = -2755364299956133297L;
	
	@JsonProperty("card_id")
	private String cardId;   //生成卡券时获得的card_id
	
	@JsonProperty("card_ext")
	private CardExtInfo cardExt;   //商户为该张卡券分配的唯一性信息


	/**
	 * @return the cardExt
	 */
	public CardExtInfo getCardExt() {
		return cardExt;
	}

	/**
	 * @param cardExt the cardExt to set
	 */
	public void setCardExt(CardExtInfo cardExt) {
		this.cardExt = cardExt;
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
