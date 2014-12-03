/**
* @FileName WchatCardCodeGetRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:46:09
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.code.Card;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeGetRes
 * @Description TODO【code查询接口-请求-返回】
 * @Author brights
 * @Date 2014年10月22日 下午12:46:09
 */
public class WchatCardCodeGetRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = 8849516075634166945L;
	
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
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
	
	
	
/*	注：固定时长有效期会根据用户实际领取时间转换，如用户2013 年10 月1 日领取，固定时长有
	效期为90 天，即有效时间为2013 年10 月1 日-12 月29 日有效。*/

}
