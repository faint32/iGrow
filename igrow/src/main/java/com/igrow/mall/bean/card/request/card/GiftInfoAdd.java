/**
* @FileName GiftInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:55:47
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName GiftInfo
 * @Description TODO【礼品券信息】
 * @Author brights
 * @Date 2014年10月21日 下午4:55:47
 */
@XStreamAlias("gift")
public class GiftInfoAdd implements Serializable {
	private static final long serialVersionUID = 9136006349217908775L;
	public static final String  CARD_TYPE = "GIFT"; //卡类型-礼品券
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	@XStreamAlias("gift")
	@JsonProperty("gift")
	private String gift; //礼品券专用，表示礼品名字
	
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
	 * @return the gift
	 */
	public String getGift() {
		return gift;
	}
	/**
	 * @param gift the gift to set
	 */
	public void setGift(String gift) {
		this.gift = gift;
	}
	
}
