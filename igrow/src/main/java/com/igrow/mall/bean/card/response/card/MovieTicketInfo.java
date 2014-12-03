/**
* @FileName MovieTicketInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:04:25
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

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
public class MovieTicketInfo implements Serializable {
	private static final long serialVersionUID = 5013623988419203345L;

	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfo baseInfo; //基本的卡券数据
	
	@XStreamAlias("detail")
	@JsonProperty("detail")
	private Boolean detail;  //电影票详情

	/**
	 * @return the baseInfo
	 */
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfo baseInfo) {
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
