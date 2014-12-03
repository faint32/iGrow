/**
* @FileName WchatCardInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午2:08:54
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatCardInfo
 * @Description TODO【微信卡券表】
 * @Author brights
 * @Date 2014年10月27日 下午2:08:54
 */
@Alias("TwchatCardInfo")
public class WchatCardInfo extends BaseEntity {

	private static final long serialVersionUID = -333539917105079142L;
	
	private String cardId;   //微信卡券id
	private Integer cardType;  //卡券类型
	private String cardTypeName;  //卡券类型名称
	private String cardTitle;  //卡券标题
	private BigDecimal reduceCost;  //减免额度 ，单位：元
	private BigDecimal leastCost;  //起用额度 ，单位：元
	private Long totalQuantity;   //投放数量
	private Long totalGetQuantity;  //领取数量
	private Long totalUseQuantity;  //使用数量
	private Integer status;   //0-未知，1：待审核，2：审核失败，3：通过审核， 4：已删除;(飞机票的status 字段为1：正常2：已删除)
	private String  customUrl;  //跳转地址
	
	private Long createTime;  //创建时间
	private Long updateTime; //修改时间
	
	//投放参数
	private String signature;  //签名
	private Long timestamp; //时间戳
	
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @return the cardType
	 */
	public Integer getCardType() {
		return cardType;
	}
	/**
	 * @return the cardTypeName
	 */
	public String getCardTypeName() {
		return cardTypeName;
	}
	/**
	 * @return the cardTitle
	 */
	public String getCardTitle() {
		return cardTitle;
	}
	/**
	 * @return the totalQuantity
	 */
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	/**
	 * @return the totalGetQuantity
	 */
	public Long getTotalGetQuantity() {
		return totalGetQuantity;
	}
	/**
	 * @return the totalUseQuantity
	 */
	public Long getTotalUseQuantity() {
		return totalUseQuantity;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	/**
	 * @param cardTypeName the cardTypeName to set
	 */
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	/**
	 * @param cardTitle the cardTitle to set
	 */
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	/**
	 * @param totalGetQuantity the totalGetQuantity to set
	 */
	public void setTotalGetQuantity(Long totalGetQuantity) {
		this.totalGetQuantity = totalGetQuantity;
	}
	/**
	 * @param totalUseQuantity the totalUseQuantity to set
	 */
	public void setTotalUseQuantity(Long totalUseQuantity) {
		this.totalUseQuantity = totalUseQuantity;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the reduceCost
	 */
	public BigDecimal getReduceCost() {
		return reduceCost;
	}
	/**
	 * @param reduceCost the reduceCost to set
	 */
	public void setReduceCost(BigDecimal reduceCost) {
		this.reduceCost = reduceCost;
	}
	/**
	 * @return the leastCost
	 */
	public BigDecimal getLeastCost() {
		return leastCost;
	}
	/**
	 * @param leastCost the leastCost to set
	 */
	public void setLeastCost(BigDecimal leastCost) {
		this.leastCost = leastCost;
	}
	/**
	 * @return the customUrl
	 */
	public String getCustomUrl() {
		return customUrl;
	}
	/**
	 * @param customUrl the customUrl to set
	 */
	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Long getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}


}
