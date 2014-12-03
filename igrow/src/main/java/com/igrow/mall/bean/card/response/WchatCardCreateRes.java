/**
* @FileName WchatCardCreateRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:32:33
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCreateRes
 * @Description TODO【创建卡券】
 * @Author brights
 * @Date 2014年10月22日 上午10:32:33
 */
public class WchatCardCreateRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = -5830687321569162355L;
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;   // 卡券ID
	

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
