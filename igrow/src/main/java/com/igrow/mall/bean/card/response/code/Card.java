/**
* @FileName Card.java
* @Package com.igrow.mall.bean.card.request.qrcode
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:45:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.code;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName Card
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月22日 上午11:45:12
 */
@XStreamAlias("card")
public class Card implements Serializable {
	private static final long serialVersionUID = 3166700156636810254L;
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId ;  //卡券ID
	
	@XStreamAlias("begin_time")
	@JsonProperty("begin_time")
	private String beginTime ;  //起始使用时间
	
	@XStreamAlias("end_time")
	@JsonProperty("end_time")
	private String endTime ;  //结束时间
	
	

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

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
