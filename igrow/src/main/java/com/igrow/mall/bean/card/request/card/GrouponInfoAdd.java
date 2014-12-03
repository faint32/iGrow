/**
* @FileName GrouponInfo.java
* @Package com.igrow.mall.bean.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午4:53:17
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

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
public class GrouponInfoAdd implements Serializable {
	private static final long serialVersionUID = 6817730431554492246L;
	public static final String  CARD_TYPE = "GROUPON"; //卡类型-团购券
	
	@XStreamAlias("base_info")
	@JsonProperty("base_info")
	private BaseInfoAdd baseInfo; //基本的卡券数据
	@XStreamAlias("deal_detail")
	@JsonProperty("deal_detail")
	private String dealDetail; //团购券专用，团购详情
	
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
