/**
* @FileName MovieTicketInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:04:25
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName MovieTicketInfo
 * @Description TODO【电影票】
 * @Author brights
 * @Date 2014年10月21日 下午6:04:25
 */
@XStreamAlias("movie_ticket")
public class MovieTicketInfoUpdate implements Serializable {
	private static final long serialVersionUID = 5013623988419203345L;
	public static final String  CARD_TYPE = "MOVIE_TICKET"; //卡类型-电影票

	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoUpdate baseInfo; //基本的卡券数据
	
	@XStreamAlias("detail")
	@JsonProperty("detail")
	private Boolean detail;  //电影票详情

	/**
	 * @return the baseInfo
	 */
	public BaseInfoUpdate getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfoUpdate baseInfo) {
		this.baseInfo = baseInfo;
	}

	/**
	 * @return the detail
	 */
	public Boolean getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(Boolean detail) {
		this.detail = detail;
	}


}
