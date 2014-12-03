/**
* @FileName Provinces.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:53:41
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Provinces
 * @Description TODO【省】
 * @Author Brights
 * @Date 2013-10-13 下午8:53:41
 */
@Alias("Tprovinces")
public class Provinces implements Serializable {
	private static final long serialVersionUID = -1143541423610208802L;
	
	private String id;
	private String provinceSn;//省ID
	private String name;//名称
	private List<Cities> cities;
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
	public String getProvinceSn() {
		return provinceSn;
	}
	public void setProvinceSn(String provinceSn) {
		this.provinceSn = provinceSn;
	}
	public List<Cities> getCities() {
		return cities;
	}
	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}
	

}
