/**
* @FileName IntsVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-21 下午2:06:25
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;


import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName IntsVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-21 下午2:06:25
 */
@XStreamAlias("intf")
public class CommonIntfVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XStreamAlias("r")
	private Integer code; //返回码
	@XStreamAlias("ac")
	private String actionMethod;//方法
	@XStreamAlias("m")
	private String message;//消息
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the actionMethod
	 */
	public String getActionMethod() {
		return actionMethod;
	}
	/**
	 * @param actionMethod the actionMethod to set
	 */
	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
