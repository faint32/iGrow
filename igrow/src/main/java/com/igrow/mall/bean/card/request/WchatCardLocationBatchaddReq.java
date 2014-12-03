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
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.request.location.Location;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardLocationBatchaddReq
 * @Description TODO【批量导入门店】
 * @Author brights
 * @Date 2014年10月22日 上午10:55:21
 */
public class WchatCardLocationBatchaddReq implements Serializable {
	private static final long serialVersionUID = 6817887978364255129L;
	public final String  req_url = "https://api.weixin.qq.com/card/location/batchadd?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("location_list")
	@JsonProperty("location_list")
	private List<Location> locationList = new ArrayList<Location>();

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
}
