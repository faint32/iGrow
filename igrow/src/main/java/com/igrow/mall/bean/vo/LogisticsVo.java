/**
* @FileName LogisticsVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:21:36
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LogisticsVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:21:36
 */
public class LogisticsVo implements Serializable {

	private static final long serialVersionUID = -4447995488131227010L;
	@XStreamAlias("tip")
	private String content;
	@XStreamAlias("time")
	private String operatieTime;
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
	 * @return the operatieTime
	 */
	public String getOperatieTime() {
		return operatieTime;
	}
	/**
	 * @param operatieTime the operatieTime to set
	 */
	public void setOperatieTime(String operatieTime) {
		this.operatieTime = operatieTime;
	}

}
