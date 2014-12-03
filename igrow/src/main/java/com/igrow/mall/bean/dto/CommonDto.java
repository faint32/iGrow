/**
* @FileName CommonDto.java
* @Package com.igrow.mall.bean.dto
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 上午11:15:32
* @Version V1.0.1
*/
package com.igrow.mall.bean.dto;

import java.io.Serializable;

/**
 * @ClassName CommonDto
 * @Description TODO【Dto】
 * @Author Brights
 * @Date 2013-10-23 上午11:15:32
 */
public class CommonDto implements Serializable {
	private static final long serialVersionUID = 3947532001492170635L;
	
	private String code;
	private String name;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
