/**
* @FileName BaseInfo.java
* @Package com.igrow.mall.bean.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:44:20
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName BaseInfo
 * @Description TODO【基本的卡券数据】
 * @Author brights
 * @Date 2014年10月21日 下午4:44:20
 */
@XStreamAlias("base_info")
public class BaseInfo implements Serializable {
	private static final long serialVersionUID = -854381994873104139L;
	
	@XStreamAlias("id")
	@JsonProperty("id")
	private String  id; //card_id
	
	@XStreamAlias("logo_url")
	@JsonProperty("logo_url")
	private String logoUrl; //LOGO,卡券的商户logo，尺寸为300*300。
	
/*	
	"CODE_TYPE_TEXT"，文本
	"CODE_TYPE_BARCODE"，一
	维码
	"CODE_TYPE_QRCODE"，二
	维码*/
	
	@XStreamAlias("code_type")
	@JsonProperty("code_type")
	private String codeType; //code 码展示类型
	
	@XStreamAlias("brand_name")
	@JsonProperty("brand_name")
	private String brandName; //商户名字,字数上限为12 个汉字。（填写直接提供服务的商户名， 第三方商户名填写在source 字段）
	
	@XStreamAlias("title")
	@JsonProperty("title")
	private String title; //券名，字数上限为9 个汉字
	
	@XStreamAlias("sub_title")
	@JsonProperty("sub_title")
	private String subTitle; //券名的副标题，字数上限为18个汉字。
	
	@XStreamAlias("color")
	@JsonProperty("color")
	private String color; //券颜色。按色彩规范标注填写Color010-Color100
	
	@XStreamAlias("notice")
	@JsonProperty("notice")
	private String notice; //使用提醒，字数上限为9 个汉字。（一句话描述，展示在首页）
	
	@XStreamAlias("service_phone")
	@JsonProperty("service_phone")
	private String servicePhone; //客服电话
	
	@XStreamAlias("source")
	@JsonProperty("source")
	private String source; //第三方来源名，例如同程旅游、格瓦拉
	
	@XStreamAlias("description")
	@JsonProperty("description")
	private String description; //使用说明。长文本描述，可以分行，上限为1000 个汉字
	
	@XStreamAlias("use_limit")
	@JsonProperty("use_limit")
	private Integer useLimit; //每人使用次数限制
	
	@XStreamAlias("get_limit")
	@JsonProperty("get_limit")
	private Integer getLimit; //每人最大领取次数，不填写默认等于quantity
	
	@XStreamAlias("use_custom_code")
	@JsonProperty("use_custom_code")
	private Boolean useCustomCode; //是否自定义code 码。填写true或false，不填代表默认为false。（该权限申请及说明详见Q&A)
	
	@XStreamAlias("bind_openid")
	@JsonProperty("bind_openid")
	private Boolean bindOpenid; //是否指定用户领取，填写true或false。不填代表默认为否
	
	@XStreamAlias("can_share")
	@JsonProperty("can_share")
	private Boolean canShare ; //领取卡券原生页面是否可分享，填写true 或false，true 代表可分享。默认可分享。
	
	@XStreamAlias("can_give_friend")
	@JsonProperty("can_give_friend")
	private Boolean can_give_friend; //卡券是否可转赠，填写true 或false,true 代表可转赠。默认可转赠。
	
	@XStreamAlias("location_id_list")
	@JsonProperty("location_id_list")
	private Integer[] locationIdList; //门店位置ID。商户需在mp 平台上录入门店信息或调用批量导入门店信息接口获取门店位置ID。
	
	@XStreamAlias("date_info")
	@JsonProperty("date_info")
	private DateInfo dateInfo; //使用日期，有效期的信息
	
	@XStreamAlias("sku")
	@JsonProperty("sku")
	private SkuInfo sku; //商品信息
	
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
	
	@XStreamAlias("status")
	@JsonProperty("status")
	private Integer  status; //1：待审核，2：审核失败，3：通过审核， 4：已删除（飞机票的status 字段为1：正常2：已删除）
	
	//create_time
	@XStreamAlias("create_time")
	@JsonProperty("create_time")
	private Long  createTime; //创建时间 -分
	
	@XStreamAlias("update_time")
	@JsonProperty("update_time")
	private Long  updateTime; //创建时间 -分 
	
	@SuppressWarnings("rawtypes")
	@XStreamAlias("js_oauth_uin_list")
	@JsonProperty("js_oauth_uin_list")
	private List jsOauthUinList;

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
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
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
	 * @return the useLimit
	 */
	public Integer getUseLimit() {
		return useLimit;
	}

	/**
	 * @param useLimit the useLimit to set
	 */
	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}

	/**
	 * @return the getLimit
	 */
	public Integer getGetLimit() {
		return getLimit;
	}

	/**
	 * @param getLimit the getLimit to set
	 */
	public void setGetLimit(Integer getLimit) {
		this.getLimit = getLimit;
	}

	/**
	 * @return the useCustomCode
	 */
	public Boolean getUseCustomCode() {
		return useCustomCode;
	}

	/**
	 * @param useCustomCode the useCustomCode to set
	 */
	public void setUseCustomCode(Boolean useCustomCode) {
		this.useCustomCode = useCustomCode;
	}

	/**
	 * @return the bindOpenid
	 */
	public Boolean getBindOpenid() {
		return bindOpenid;
	}

	/**
	 * @return the jsOauthUinList
	 */
	@SuppressWarnings("rawtypes")
	public List getJsOauthUinList() {
		return jsOauthUinList;
	}

	/**
	 * @param jsOauthUinList the jsOauthUinList to set
	 */
	@SuppressWarnings("rawtypes")
	public void setJsOauthUinList(List jsOauthUinList) {
		this.jsOauthUinList = jsOauthUinList;
	}

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @param bindOpenid the bindOpenid to set
	 */
	public void setBindOpenid(Boolean bindOpenid) {
		this.bindOpenid = bindOpenid;
	}

	/**
	 * @return the canShare
	 */
	public Boolean getCanShare() {
		return canShare;
	}

	/**
	 * @param canShare the canShare to set
	 */
	public void setCanShare(Boolean canShare) {
		this.canShare = canShare;
	}

	/**
	 * @return the can_give_friend
	 */
	public Boolean getCan_give_friend() {
		return can_give_friend;
	}

	/**
	 * @param can_give_friend the can_give_friend to set
	 */
	public void setCan_give_friend(Boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
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
	 * @return the dateInfo
	 */
	public DateInfo getDateInfo() {
		return dateInfo;
	}

	/**
	 * @param dateInfo the dateInfo to set
	 */
	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	/**
	 * @return the sku
	 */
	public SkuInfo getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(SkuInfo sku) {
		this.sku = sku;
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

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	

}
