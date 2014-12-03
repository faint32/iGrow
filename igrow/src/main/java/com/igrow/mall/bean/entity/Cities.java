/**
* @FileName Cities.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:55:39
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Cities
 * @Description TODO【城市】
 * @Author Brights
 * @Date 2013-10-13 下午8:55:39
 */
@Alias("Tcities")
public class Cities implements Serializable {
	private static final long serialVersionUID = -4070057555800793491L;
	
	private String id;
	private String citySn;//城市ID
	private String name;//名称
	private String provinceSn;//省ID
	private Provinces province;
	private List<Areas> areas;
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
	public Provinces getProvince() {
		return province;
	}
	public void setProvince(Provinces province) {
		this.province = province;
	}
	public String getCitySn() {
		return citySn;
	}
	public void setCitySn(String citySn) {
		this.citySn = citySn;
	}
	public String getProvinceSn() {
		return provinceSn;
	}
	public void setProvinceSn(String provinceSn) {
		this.provinceSn = provinceSn;
	}
	public List<Areas> getAreas() {
		return areas;
	}
	public void setAreas(List<Areas> areas) {
		this.areas = areas;
	}
	
	

}
