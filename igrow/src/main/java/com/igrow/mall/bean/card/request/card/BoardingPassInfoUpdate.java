/**
* @FileName BoardingPassInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:06:46
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName BoardingPassInfo
 * @Description TODO【飞机票】
 * @Author brights
 * @Date 2014年10月21日 下午6:06:46
 */
@XStreamAlias("boarding_pass")
public class BoardingPassInfoUpdate implements Serializable {
	private static final long serialVersionUID = 6439918754486591374L;
	
	public static final String  CARD_TYPE = "BOARDING_PASS"; //卡类型-飞机票
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoUpdate baseInfo; //基本的卡券数据
	
	
	@XStreamAlias("departure_time")
	@JsonProperty("departure_time")
	private Boolean departureTime;  //起飞时间，上限为17 个汉字
	
	@XStreamAlias("landing_time")
	@JsonProperty("landing_time")
	private Boolean landingTime;  //降落时间，上限为17 个汉字

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
	 * @return the departureTime
	 */
	public Boolean getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(Boolean departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the landingTime
	 */
	public Boolean getLandingTime() {
		return landingTime;
	}

	/**
	 * @param landingTime the landingTime to set
	 */
	public void setLandingTime(Boolean landingTime) {
		this.landingTime = landingTime;
	}
	



}
