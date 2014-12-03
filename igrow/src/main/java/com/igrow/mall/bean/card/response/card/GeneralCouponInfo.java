/**
* @FileName GeneralCoupon.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:48:32
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName GeneralCoupon
 * @Description TODO【团购券信息】
 * @Author brights
 * @Date 2014年10月21日 下午4:48:32
 */
@XStreamAlias("general_coupon")
public class GeneralCouponInfo implements Serializable {
	private static final long serialVersionUID = -5384791726485141573L;
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfo baseInfo; //基本的卡券数据
	
	@XStreamAlias("default_detail")
	@JsonProperty("default_detail")
	private String defaultDetail; //描述文本
	
	/**
	 * @return the baseInfo
	 */
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	/**
	 * @return the defaultDetail
	 */
	public String getDefaultDetail() {
		return defaultDetail;
	}
	/**
	 * @param defaultDetail the defaultDetail to set
	 */
	public void setDefaultDetail(String defaultDetail) {
		this.defaultDetail = defaultDetail;
	}
	
	
}
