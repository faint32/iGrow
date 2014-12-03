/**
* @FileName Location.java
* @Package com.igrow.mall.bean.card.request.location
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:49:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.location;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName Location
 * @Description TODO【门店】
 * @Author brights
 * @Date 2014年10月22日 上午10:49:12
 */
public class Location implements Serializable {
	private static final long serialVersionUID = -7054638219505654626L;
	//https://api.weixin.qq.com/card/location/batchadd?access_token=TOKEN
	
	@XStreamAlias("business_name")
	@JsonProperty("business_name")
	private String businessName; //门店名称
	
	@XStreamAlias("province")
	@JsonProperty("province")
	private String province;	//门店所在的省
	
	@XStreamAlias("city")
	@JsonProperty("city")
	private String city;	//门店所在的市
	
	@XStreamAlias("district")
	@JsonProperty("district")
	private String district;  //门店所在的区
	
	@XStreamAlias("address")
	@JsonProperty("address")
	private String address;   //门店所在的详细街道地址
	
	@XStreamAlias("telephone")
	@JsonProperty("telephone")
	private String telephone;   //门店的电话
	
	@XStreamAlias("category")
	@JsonProperty("category")
	private String category;   //门店的类型（酒店、餐饮、购物...）
	
	@XStreamAlias("longitude")
	@JsonProperty("longitude")
	private String longitude;   //门店所在地理位置的经度
	
	@XStreamAlias("latitude")
	@JsonProperty("latitude")
	private String latitude;  //门店所在地理位置的纬度
	

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	

}
