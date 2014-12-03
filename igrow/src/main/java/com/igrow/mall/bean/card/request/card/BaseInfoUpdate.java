/**
* @FileName BaseInfo.java
* @Package com.igrow.mall.bean.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:44:20
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName BaseInfo
 * @Description TODO【基本的卡券数据】
 * @Author brights
 * @Date 2014年10月21日 下午4:44:20
 */
@XStreamAlias("base_info")
public class BaseInfoUpdate implements Serializable {
	private static final long serialVersionUID = -854381994873104139L;
	
	@XStreamAlias("logo_url")
	@JsonProperty("logo_url")
	private String logoUrl; //LOGO,卡券的商户logo，尺寸为300*300。
	
	@XStreamAlias("color")
	@JsonProperty("color")
	private String color; //券颜色。按色彩规范标注填写Color010-Color100
	
	@XStreamAlias("notice")
	@JsonProperty("notice")
	private String notice; //使用提醒，字数上限为9 个汉字。（一句话描述，展示在首页）
	
	@XStreamAlias("service_phone")
	@JsonProperty("service_phone")
	private String servicePhone; //客服电话
	
	@XStreamAlias("description")
	@JsonProperty("description")
	private String description; //使用说明。长文本描述，可以分行，上限为1000 个汉字
	
	@XStreamAlias("location_id_list")
	@JsonProperty("location_id_list")
	private Integer[] locationIdList; //门店位置ID。商户需在mp 平台上录入门店信息或调用批量导入门店信息接口获取门店位置ID。
	/* "URL_NAME_TYPE_TAKE_AWAY"，外卖
	"URL_NAME_TYPE_RESERVATION"，在线预订
	"URL_NAME_TYPE_USE_IMMEDIATELY"，立即使用
	"URL_NAME_TYPE_APPOINTMENT”,在线预约
	 URL_NAME_TYPE_EXCHANGE,在线兑换
	 URL_NAME_TYPE_MALL,在线商城
	"URL_NAME_TYPE_VEHICLE_INFORMATION，车辆信息
	（该权限申请及说明详见Q&A)
 */

	@XStreamAlias("url_name_type")
	@JsonProperty("url_name_type")
	private String  urlNameType; //商户自定义cell 名称
	
	@XStreamAlias("custom_url")
	@JsonProperty("custom_url")
	private String  customUrl; //商户自定义url 地址，支持卡券页内跳转,跳转页面内容需与自定义cell 名称保持一致。

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * @return the servicePhone
	 */
	public String getServicePhone() {
		return servicePhone;
	}

	/**
	 * @param servicePhone the servicePhone to set
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the locationIdList
	 */
	public Integer[] getLocationIdList() {
		return locationIdList;
	}

	/**
	 * @param locationIdList the locationIdList to set
	 */
	public void setLocationIdList(Integer[] locationIdList) {
		this.locationIdList = locationIdList;
	}

	/**
	 * @return the urlNameType
	 */
	public String getUrlNameType() {
		return urlNameType;
	}

	/**
	 * @param urlNameType the urlNameType to set
	 */
	public void setUrlNameType(String urlNameType) {
		this.urlNameType = urlNameType;
	}

	/**
	 * @return the customUrl
	 */
	public String getCustomUrl() {
		return customUrl;
	}

	/**
	 * @param customUrl the customUrl to set
	 */
	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}
	
	

}
