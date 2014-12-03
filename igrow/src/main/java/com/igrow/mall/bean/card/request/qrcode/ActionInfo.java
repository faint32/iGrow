/**
* @FileName ActionInfo.java
* @Package com.igrow.mall.bean.card.request.qrcode
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:44:16
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.qrcode;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ActionInfo
 * @Description TODO【请求信息】
 * @Author brights
 * @Date 2014年10月22日 上午11:44:16
 */
@JsonIgnoreProperties(ignoreUnknown=true) 
public class ActionInfo implements Serializable {

	private static final long serialVersionUID = 7212383497484599306L;
	
	@XStreamAlias("card")
	@JsonProperty("card")
	private Card card ;
	

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
