/**
* @FileName GrouponInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:53:17
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName GrouponInfo
 * @Description TODO【团购券】
 * @Author brights
 * @Date 2014年10月21日 下午4:53:17
 */
@XStreamAlias("groupon")
public class GrouponInfo implements Serializable {
	private static final long serialVersionUID = 6817730431554492246L;
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfo baseInfo; //基本的卡券数据
	
	@XStreamAlias("deal_detail")
	@JsonProperty("deal_detail")
	private String dealDetail; //团购券专用，团购详情
	
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
	 * @return the dealDetail
	 */
	public String getDealDetail() {
		return dealDetail;
	}
	/**
	 * @param dealDetail the dealDetail to set
	 */
	public void setDealDetail(String dealDetail) {
		this.dealDetail = dealDetail;
	}
}
