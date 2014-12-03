/**
* @FileName ScenicTicketInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:01:43
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ScenicTicketInfo
 * @Description TODO【门票】
 * @Author brights
 * @Date 2014年10月21日 下午6:01:43
 */
@XStreamAlias("scenic_ticket")
public class ScenicTicketInfoAdd implements Serializable {
	private static final long serialVersionUID = -311716513765008433L;
	public static final String  CARD_TYPE = "SCENIC_TICKET"; //卡类型-门票
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	
	@XStreamAlias("ticket_class")
	@JsonProperty("ticket_class")
	private Boolean ticketClass;  //票类型，例如平日全票，套票等
	
	@XStreamAlias("guide_url")
	@JsonProperty("guide_url")
	private Boolean guideUrl; //导览图url
	/**
	 * @return the baseInfo
	 */
	public BaseInfoAdd getBaseInfo() {
		return baseInfo;
	}
	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfoAdd baseInfo) {
		this.baseInfo = baseInfo;
	}
	/**
	 * @return the ticketClass
	 */
	public Boolean getTicketClass() {
		return ticketClass;
	}
	/**
	 * @param ticketClass the ticketClass to set
	 */
	public void setTicketClass(Boolean ticketClass) {
		this.ticketClass = ticketClass;
	}
	/**
	 * @return the guideUrl
	 */
	public Boolean getGuideUrl() {
		return guideUrl;
	}
	/**
	 * @param guideUrl the guideUrl to set
	 */
	public void setGuideUrl(Boolean guideUrl) {
		this.guideUrl = guideUrl;
	}
	
}
