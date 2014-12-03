/**
* @FileName WchatLocationBatchaddRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:00:15
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.Location.Location;

/**
 * @ClassName WchatLocationBatchaddRes
 * @Description TODO【批量添加门店返回】
 * @Author brights
 * @Date 2014年10月22日 上午11:00:15
 */
public class WchatCardLocationBatchgetRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = -890865015468515169L;
	
	
	@JsonProperty("location_list")
	private List<Location> locationList;   //门店列表。
	
	@JsonProperty("count")
    private Integer count; // 拉取门店数量

	/**
	 * @return the locationList
	 */
	public List<Location> getLocationList() {
		return locationList;
	}

	/**
	 * @param locationList the locationList to set
	 */
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
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
