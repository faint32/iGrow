/**
* @FileName Location.java
* @Package com.igrow.mall.bean.card.request.location
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:49:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.Location;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @ClassName Location
 * @Description TODO【门店】
 * @Author brights
 * @Date 2014年10月22日 上午10:49:12
 */
public class Location implements Serializable {
	private static final long serialVersionUID = -7054638219505654626L;
	//https://api.weixin.qq.com/card/location/batchadd?access_token=TOKEN
	
	//@XStreamAlias("id")
	@JsonProperty("id")
	private Integer id;  //门店ID
	
	//@XStreamAlias("name")
	@JsonProperty("name")
	private String name;  //门店名称
	
	//@XStreamAlias("phone")
	@JsonProperty("phone")
	private String phone;  //联系电话
	
	//@XStreamAlias("address")
	@JsonProperty("address")
	private String address;  //详细地址
	
	//@XStreamAlias("longitude")
	@JsonProperty("longitude")
	private Float longitude;  //经度
	
	//@XStreamAlias("latitude")
	@JsonProperty("latitude")
	private Float latitude;  //纬度

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}


	

}
