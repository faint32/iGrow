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
public class BoardingPassInfoAdd implements Serializable {
	private static final long serialVersionUID = 6439918754486591374L;
	public static final String  CARD_TYPE = "BOARDING_PASS"; //卡类型-飞机票
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	
	@XStreamAlias("from")
	@JsonProperty("from")
	private Boolean from;  //起点，上限为18 个汉字
	
	@XStreamAlias("to")
	@JsonProperty("to")
	private Boolean to;  //终点，上限为18 个汉字
	
	@XStreamAlias("flight")
	@JsonProperty("flight")
	private Boolean flight;  //航班
	
	@XStreamAlias("departure_time")
	@JsonProperty("departure_time")
	private Boolean departureTime;  //起飞时间，上限为17 个汉字
	
	@XStreamAlias("landing_time")
	@JsonProperty("landing_time")
	private Boolean landingTime;  //降落时间，上限为17 个汉字
	
	@XStreamAlias("check_in_url")
	@JsonProperty("check_in_url")
	private Boolean checkInUrl;  //在线值机的链接
	
	@XStreamAlias("air_model")
	@JsonProperty("air_model")
	private Boolean airModel;  //机型，上限为8 个汉字

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
	 * @return the from
	 */
	public Boolean getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Boolean from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Boolean getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Boolean to) {
		this.to = to;
	}

	/**
	 * @return the flight
	 */
	public Boolean getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Boolean flight) {
		this.flight = flight;
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

	/**
	 * @return the checkInUrl
	 */
	public Boolean getCheckInUrl() {
		return checkInUrl;
	}

	/**
	 * @param checkInUrl the checkInUrl to set
	 */
	public void setCheckInUrl(Boolean checkInUrl) {
		this.checkInUrl = checkInUrl;
	}

	/**
	 * @return the airModel
	 */
	public Boolean getAirModel() {
		return airModel;
	}

	/**
	 * @param airModel the airModel to set
	 */
	public void setAirModel(Boolean airModel) {
		this.airModel = airModel;
	}

}
