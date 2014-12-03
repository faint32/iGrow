/**
* @FileName CashInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:57:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName CashInfo
 * @Description TODO【代金券】
 * @Author brights
 * @Date 2014年10月21日 下午4:57:12
 */
@XStreamAlias("cash")
public class CashInfoAdd implements Serializable {
	private static final long serialVersionUID = -3623345256088535177L;
	public static final String  CARD_TYPE = "CASH"; //卡类型-代金券
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	
	@XStreamAlias("least_cost")
	@JsonProperty("least_cost")
	private Long leastCost; //代金券专用，表示起用金额（单位为分）  --否
	@XStreamAlias("reduce_cost")
	@JsonProperty("reduce_cost")
	private Long reduceCost; //代金券专用，表示减免金额（单位为分）
	
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
	 * @return the leastCost
	 */
	public Long getLeastCost() {
		return leastCost;
	}
	/**
	 * @param leastCost the leastCost to set
	 */
	public void setLeastCost(Long leastCost) {
		this.leastCost = leastCost;
	}
	/**
	 * @return the reduceCost
	 */
	public Long getReduceCost() {
		return reduceCost;
	}
	/**
	 * @param reduceCost the reduceCost to set
	 */
	public void setReduceCost(Long reduceCost) {
		this.reduceCost = reduceCost;
	}

}
