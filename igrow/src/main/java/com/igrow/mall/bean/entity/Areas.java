/**
* @FileName Areas.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:57:34
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Areas
 * @Description TODO【区县】
 * @Author Brights
 * @Date 2013-10-13 下午8:57:34
 */
@Alias("Tareas")
public class Areas implements Serializable {
	private static final long serialVersionUID = -6645207465985338133L;
	
	private String id;
	private String areaSn; //区域ID
	private String citySn;//城市ID
	private String name;//名称
	private Cities city;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	public Cities getCity() {
		return city;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	public String getAreaSn() {
		return areaSn;
	}
	public void setAreaSn(String areaSn) {
		this.areaSn = areaSn;
	}
	public String getCitySn() {
		return citySn;
	}
	public void setCitySn(String citySn) {
		this.citySn = citySn;
	}

}
