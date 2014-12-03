/**
* @FileName WchatOctCustomServiceChatDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午9:42:47
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatOctCustomServiceChatDetail
 * @Description TODO【微信多客服会话记录】
 * @Author brights
 * @Date 2014年10月18日 上午9:42:47
 */
@Alias("TwchatOctCustomServiceChatDetail")
public class WchatOctCustomServiceChatDetail extends BaseEntity {
	private static final long serialVersionUID = 8927257244196755141L;
	
	private  String supplierId;	 //供应商ID
	private  String supplierDesignerId;	//供应商设计ID
	private  String wchatKfAccount;	//微信客服帐号
	private  String memberId;	//会员ID
	private  String  openId;	//会员openId
	private  String  operCode;	//操作状态码
	private  String  operName;	 //操作状态名称
	private  Date  operTime;	 //操作事件
	private  String  content;	 //会话内容
	
	
	
	/**
	 * @return the supplierId
	 */
	public String getSupplierId() {
		return supplierId;
	}
	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * @return the wchatKfAccount
	 */
	public String getWchatKfAccount() {
		return wchatKfAccount;
	}
	/**
	 * @param wchatKfAccount the wchatKfAccount to set
	 */
	public void setWchatKfAccount(String wchatKfAccount) {
		this.wchatKfAccount = wchatKfAccount;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the operCode
	 */
	public String getOperCode() {
		return operCode;
	}
	/**
	 * @param operCode the operCode to set
	 */
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	/**
	 * @return the operName
	 */
	public String getOperName() {
		return operName;
	}
	/**
	 * @param operName the operName to set
	 */
	public void setOperName(String operName) {
		this.operName = operName;
	}
	/**
	 * @return the operTime
	 */
	public Date getOperTime() {
		return operTime;
	}
	/**
	 * @param operTime the operTime to set
	 */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the supplierDesignerId
	 */
	public String getSupplierDesignerId() {
		return supplierDesignerId;
	}
	/**
	 * @param supplierDesignerId the supplierDesignerId to set
	 */
	public void setSupplierDesignerId(String supplierDesignerId) {
		this.supplierDesignerId = supplierDesignerId;
	}


}
