/**
* @FileName MessageSendLog.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:23:06
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName MessageSendLog
 * @Description TODO【消息发送日志】
 * @Author Brights
 * @Date 2013-10-13 下午8:23:06
 */
@Alias("TmessageSendLog")
public class MessageSendLog extends BaseEntity {
	private static final long serialVersionUID = 960088913561023974L;
	
	private String content;//内容
	private String mobile;//接收手机号码
	private String email;//接收邮箱
	private String passage;//发送通道（sms,email）
	private String status;//状态
	
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the passage
	 */
	public String getPassage() {
		return passage;
	}
	/**
	 * @param passage the passage to set
	 */
	public void setPassage(String passage) {
		this.passage = passage;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
