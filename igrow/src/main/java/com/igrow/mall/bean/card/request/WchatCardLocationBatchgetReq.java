/**
* @FileName WchatLocationBatchaddReq.java
* @Package com.igrow.mall.bean.card.request.location
* @Description TODO【批量添加门店请求】
* @Author brights
* @Date 2014年10月22日 上午10:55:21
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatLocationBatchgetReq
 * @Description TODO【批量导入门店】
 * @Author brights
 * @Date 2014年10月22日 上午10:55:21
 */
public class WchatCardLocationBatchgetReq implements Serializable {
	private static final long serialVersionUID = 6817887978364255129L;
	
	public final String  req_url = "https://api.weixin.qq.com/card/location/batchget?access_token=TOKEN"; //请求地址
	
	//注：“offset”，“count”都为0 时默认拉取全部门店。
	
	@XStreamAlias("offset")
	@JsonProperty("offset")
	private Integer offset; //偏移量，0 开始
	
	@XStreamAlias("count")
	@JsonProperty("count")
	private Integer count; //拉取数量
	

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
