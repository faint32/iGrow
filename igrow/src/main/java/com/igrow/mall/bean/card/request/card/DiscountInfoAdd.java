/**
* @FileName DiscountInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午5:18:47
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName DiscountInfo
 * @Description TODO【折扣券信息】
 * @Author brights
 * @Date 2014年10月21日 下午5:18:47
 */
@XStreamAlias("discount")
public class DiscountInfoAdd implements Serializable {
	private static final long serialVersionUID = -8827162150151247245L;
	public static final String  CARD_TYPE = "DISCOUNT"; //卡类型-折扣券

	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	
	@XStreamAlias("discount")
	@JsonProperty("discount")
	private String discount; //折扣券专用，表示打折额度（百分比）。填30 就是七折。

	/**
	 * @return the baseInfo
	 */
	public BaseInfoAdd getBaseInfo() {
		return baseInfo;
	}

	/**
	 * @param baseInfo the baseInfo to set
	 */
	public void setBaseInfo(BaseInfoAdd baseInfo) {
		this.baseInfo = baseInfo;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
}
