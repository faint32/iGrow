/**
* @FileName WchatCardOrderDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午2:14:15
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;


import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatCardOrderDetail
 * @Description TODO【订单微信卡券明细表】
 * @Author brights
 * @Date 2014年10月27日 下午2:14:15
 */
@Alias("TwchatCardOrderDetail")
public class WchatCardOrderDetail extends BaseEntity {

	private static final long serialVersionUID = 274748030450445754L;
	
	private String orderId;  //订单id
	private String cardId;  //微信卡券id
	private String cardEncryptCode;  //微信卡券密文code码
	private String cardCode;  //微信卡券code码
	private Integer status;  ///状态（0-未知，1-待核销，2-已核销）
	private String openId;   //核销用户微信openid，唯一
	private String memberId;  //用户会员id
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @return the cardEncryptCode
	 */
	public String getCardEncryptCode() {
		return cardEncryptCode;
	}
	/**
	 * @return the cardCode
	 */
	public String getCardCode() {
		return cardCode;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/**
	 * @param cardEncryptCode the cardEncryptCode to set
	 */
	public void setCardEncryptCode(String cardEncryptCode) {
		this.cardEncryptCode = cardEncryptCode;
	}
	/**
	 * @param cardCode the cardCode to set
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
}
