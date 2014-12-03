/**
* @FileName WchatCardMemberDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午2:22:04
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatCardMemberDetail
 * @Description TODO【会员微信卡券明细表】
 * @Author brights
 * @Date 2014年10月27日 下午2:22:04
 */
@Alias("TwchatCardMemberDetail")
public class WchatCardMemberDetail extends BaseEntity {
	private static final long serialVersionUID = -1961831753290387593L;
	
	private String memberId;
	private String  openId;
	private String  cardId;
	private String  cardCode;
	private String  fromOpenId;
	private Integer  isGive;  //是否为转赠，1 代表是，0 代表否。
	private Integer  status;   //0-未使用，1-待核销，2-已核销 3-已转赠
	
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @return the cardCode
	 */
	public String getCardCode() {
		return cardCode;
	}
	/**
	 * @return the fromOpenId
	 */
	public String getFromOpenId() {
		return fromOpenId;
	}
	/**
	 * @return the isGive
	 */
	public Integer getIsGive() {
		return isGive;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/**
	 * @param cardCode the cardCode to set
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	/**
	 * @param fromOpenId the fromOpenId to set
	 */
	public void setFromOpenId(String fromOpenId) {
		this.fromOpenId = fromOpenId;
	}
	/**
	 * @param isGive the isGive to set
	 */
	public void setIsGive(Integer isGive) {
		this.isGive = isGive;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


}
