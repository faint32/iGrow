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

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardMovieticketUpdateuserReq
 * @Description TODO【电影票-更新电影票】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */
			/*电影票券主要分为以下两种：
				1、电影票兑换券，归属于团购券。
				2、选座电影票，在购买时需要选定电影、场次、座位，具备较强的时效性和特殊性，此类电影
				票券即文档中的电影票。
				使用场景： 用户点击商户 H5 页面提供的 JS API（2.2 添加到卡包 JS API）后，商户根据用户
				电影票信息，调用接口创建卡券（1.1 创建卡券），获取card_id 后，将带有唯一code 的电影
				票下发给用户，用户领取后通过接口（6.2.1 更新电影票）update 用户选座信息。*/

public class WchatCardMovieticketUpdateuserReq  implements Serializable{
	
	/*领取电影票后通过调用“更新电影票”接口update 电影信息及用户选座信息*/
	
	private static final long serialVersionUID = 11281056868504794L;
	public final String  req_url = "https://api.weixin.qq.com/card/movieticket/updateuser?access_token=TOKEN"; //请求地址
	
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;		//电影票的序列号
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;		//电影票card_id。自定义code 的电影票为必填，非自定义code 的电影票不必填。
	
	@XStreamAlias("ticket_class")
	@JsonProperty("ticket_class")
	private Long ticketClass;		//电影票的类别，如2D、3D
	
	@XStreamAlias("show_time")
	@JsonProperty("show_time")
	private Long showTime;		//电影放映时间对应的时间戳
	
	@XStreamAlias("duration")
	@JsonProperty("duration")
	private Integer duration;		//放映时长，填写整数,,单位：分钟
	
	@XStreamAlias("screening_room")
	@JsonProperty("screening_room")
	private String screeningRoom;		//该场电影的影厅信息
	
	@XStreamAlias("seat_number")
	@JsonProperty("seat_number")
	private String[] seatNumber;		//座位号

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

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

	/**
	 * @return the ticketClass
	 */
	public Long getTicketClass() {
		return ticketClass;
	}

	/**
	 * @param ticketClass the ticketClass to set
	 */
	public void setTicketClass(Long ticketClass) {
		this.ticketClass = ticketClass;
	}

	/**
	 * @return the showTime
	 */
	public Long getShowTime() {
		return showTime;
	}

	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(Long showTime) {
		this.showTime = showTime;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the screeningRoom
	 */
	public String getScreeningRoom() {
		return screeningRoom;
	}

	/**
	 * @param screeningRoom the screeningRoom to set
	 */
	public void setScreeningRoom(String screeningRoom) {
		this.screeningRoom = screeningRoom;
	}

	/**
	 * @return the seatNumber
	 */
	public String[] getSeatNumber() {
		return seatNumber;
	}

	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String[] seatNumber) {
		this.seatNumber = seatNumber;
	}
	

	
	
	

}
