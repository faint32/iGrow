/**
* @FileName GeneralCouponCard.java
* @Package com.igrow.mall.bean.card.card.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月21日 下午6:43:59
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardBatchgetReq
 * @Description TODO【批量查询卡列表】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */
public class WchatCardBatchgetReq  implements Serializable{
	private static final long serialVersionUID = 5572379352486146213L;
	
	public final String  req_url = "https://api.weixin.qq.com/card/batchget?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("offset")
	@JsonProperty("offset")
	private Integer offset; //查询卡列表的起始偏移量，从0 开始，即offset: 5 是指从从列表里的第六个开始读取
	
	
	@XStreamAlias("count")
	@JsonProperty("count")
	private Integer count; //需要查询的卡片的数量（数量最大50）


	/**
	 * @return the offset
	 */
	public Integer getOffset() {
		return offset;
	}


	/**
	 * @param offset the offset to set
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}


	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}


	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	
	

}
