/**
* @FileName WchatOctCustomSendDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午9:50:34
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatOctCustomSendDetail
 * @Description TODO【微信客服发送消息记录】
 * @Author brights
 * @Date 2014年10月18日 上午9:50:34
 */
@Alias("TwchatOctCustomSendDetail")
public class WchatOctCustomSendDetail extends BaseEntity {
	private static final long serialVersionUID = 4698279963742252887L;
	
	private String fromUser;	//开发者微信号 
	private String toUser;	 //普通用户openid 
	private String msgType;	//消息类型
	private String content; //发送内容
	private String supplierId; //供应商ID
	private String supplierDesignerId; //供应商设计师ID
	
	private String wchatKfAccount;
	
	
	/**
	 * @return the fromUser
	 */
	public String getFromUser() {
		return fromUser;
	}
	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	/**
	 * @return the toUser
	 */
	public String getToUser() {
		return toUser;
	}
	/**
	 * @param toUser the toUser to set
	 */
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

}
