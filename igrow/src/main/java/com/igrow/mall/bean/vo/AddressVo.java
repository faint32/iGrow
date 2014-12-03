/**
* @FileName AddressVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 上午11:05:54
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName AddressVo
 * @Description TODO【地址】
 * @Author Brights
 * @Date 2013-10-25 上午11:05:54
 */
public class AddressVo implements Serializable{
	private static final long serialVersionUID = -920810911675693803L;
	@XStreamAlias("aid")
	private String id;
	@XStreamAlias("contact")
	private String name;
	@XStreamAlias("city")
	private String areaId;
	@XStreamAlias("city_name")
	private String area;
	@XStreamAlias("phone")
	private String mobile;
	@XStreamAlias("road")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
