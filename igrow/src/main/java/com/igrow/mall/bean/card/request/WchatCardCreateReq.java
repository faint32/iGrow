/**
* @FileName GeneralCouponCard.java
* @Package com.igrow.mall.bean.card.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:43:59
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.request.card.CardInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCreateReq
 * @Description TODO【微信卡券创建请求数据】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */
public class WchatCardCreateReq  implements Serializable{
	private static final long serialVersionUID = 5572379352486146213L;
	
	public final String  req_url = "https://api.weixin.qq.com/card/create?access_token=TOKEN"; //请求地址
	
	
	@XStreamAlias("card")
	@JsonProperty("card")
	private CardInfo card;


	/**
	 * @return the card
	 */
	public CardInfo getCard() {
		return card;
	}


	/**
	 * @param card the card to set
	 */
	public void setCard(CardInfo card) {
		this.card = card;
	} 
	
	
	

}
