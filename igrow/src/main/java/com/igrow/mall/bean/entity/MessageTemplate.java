/**
* @FileName MessageTemplate.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:19:45
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName MessageTemplate
 * @Description TODO【消息模板】
 * @Author Brights
 * @Date 2013-10-13 下午8:19:45
 */
@Alias("TmessageTemplate")
public class MessageTemplate extends BaseEntity {
	private static final long serialVersionUID = 2537008218990327952L;
	
	private String title;//标题
	private String content;//内容
	private String code;//模板编码
	private String passage;//发送通道（sms,email）
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

}
