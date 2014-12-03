/**
* @FileName LuckyMoneyInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:15:48
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LuckyMoneyInfo
 * @Description TODO【红包】
 * @Author brights
 * @Date 2014年10月21日 下午6:15:48
 */
@XStreamAlias("lucky_money")
public class LuckyMoneyInfoAdd implements Serializable {
	private static final long serialVersionUID = 1793666052035860901L;
	public static final String  CARD_TYPE = "LUCKY_MONEY"; //卡类型-红包
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	

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
}
