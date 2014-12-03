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
 * @ClassName WchatCardBoardingpassCheckinReq
 * @Description TODO【飞机票-在线选座】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */
			/*飞机票与其他卡券相比具有更强的时效性和特殊性，故机票生成后无需经过微信审核，即时生效。
				机票使用场景主要分为以下两种：
				1、通过微信购买后直接添加至卡包，可值机时段由卡包在线办理登机牌。
				2、在微信商户（一般为航空公司）公众号内完成值机后，添加至微信卡包。
				
				第一种场景： 用户点击商户 H5 页面“添加至卡包”的 JS API（2.2添加到卡包 JS API）后，
				商户根据用户机票信息，调用接口创建卡券（1.1 创建卡券接口），获取card_id 后，将机票下
				发给用户。在可值机时段，用户点击商户指定的URL 在线办理登机牌。办理成功后，商户调用
				选座接口（6.3.1 在线选座接口），将值机信息同步。
				
				第二种场景： 用户点击商户 H5 页面提供的 JS API（2.2 添加到卡包 JS API）后，商户根据用
				户机票信息，调用接口生成卡券（1.1 创建卡券接口），获取card_id 后，将机票下发给用户。
				并立即调用选座接口（6.3.1.在线选座接口），将值机信息同步。*/

public class WchatCardBoardingpassCheckinReq  implements Serializable{
	
	/*在线选座*/
	
	private static final long serialVersionUID = 11281056868504794L;
	public final String  req_url = "https://api.weixin.qq.com/card/boardingpass/checkin?access_token=TOKEN"; //请求地址
	
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;		//飞机票的序列号
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;		//需办理值机的机票card_id。自定义code 的飞机票为必填
	
	
	@XStreamAlias("passenger_name")
	@JsonProperty("passenger_name")
	private String passengerName;		//乘客姓名，上限为15 个汉字
	
	@XStreamAlias("class")
	@JsonProperty("class")
	private String aircraftClass;		//舱等，如头等舱等，上限为5 个汉字
	
	@XStreamAlias("seat")
	@JsonProperty("seat")
	private String seat;		//乘客座位号
	
	@XStreamAlias("gate")
	@JsonProperty("gate")
	private String gate;		//登机口。如发生登机口变更，建议商家实时调用该接口变更
	
	@XStreamAlias("boarding_time")
	@JsonProperty("boarding_time")
	private String boardingTime;		//登机时间，只显示“时分”不显示日期，按时间戳格式填写。如发生登机时间变更，建议商家实时调用该接口变更
	
	@XStreamAlias("etkt_bnr")
	@JsonProperty("etkt_bnr")
	private String etktBnr;		//电子客票号，上限为14 个数字
	
	@XStreamAlias("qrcode_data")
	@JsonProperty("qrcode_data")
	private String qrcodeData;		//二维码数据。乘客用于值机的二维码字符串，微信会通过此	数据为用户生成值机用的二维码。
	
	@XStreamAlias("is_cancel")
	@JsonProperty("is_cancel")
	private Boolean isCancel = false;		//是否取消值机。填写true 或false。true 代表取消，如填写true 上述字段（如calss 等）均不做判断，机票返回未值机状态，乘客可重新值机。默认填写false

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
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * @param passengerName the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * @return the aircraftClass
	 */
	public String getAircraftClass() {
		return aircraftClass;
	}

	/**
	 * @param aircraftClass the aircraftClass to set
	 */
	public void setAircraftClass(String aircraftClass) {
		this.aircraftClass = aircraftClass;
	}

	/**
	 * @return the seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * @param seat the seat to set
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * @return the gate
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * @param gate the gate to set
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	/**
	 * @return the boardingTime
	 */
	public String getBoardingTime() {
		return boardingTime;
	}

	/**
	 * @param boardingTime the boardingTime to set
	 */
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	/**
	 * @return the etktBnr
	 */
	public String getEtktBnr() {
		return etktBnr;
	}

	/**
	 * @param etktBnr the etktBnr to set
	 */
	public void setEtktBnr(String etktBnr) {
		this.etktBnr = etktBnr;
	}

	/**
	 * @return the qrcodeData
	 */
	public String getQrcodeData() {
		return qrcodeData;
	}

	/**
	 * @param qrcodeData the qrcodeData to set
	 */
	public void setQrcodeData(String qrcodeData) {
		this.qrcodeData = qrcodeData;
	}

	/**
	 * @return the isCancel
	 */
	public Boolean getIsCancel() {
		return isCancel;
	}

	/**
	 * @param isCancel the isCancel to set
	 */
	public void setIsCancel(Boolean isCancel) {
		this.isCancel = isCancel;
	}
	

	
	

}
