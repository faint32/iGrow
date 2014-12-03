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

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @ClassName WchatCardLocationBatchaddRes
 * @Description TODO【批量添加门店返回】
 * @Author brights
 * @Date 2014年10月22日 上午11:00:15
 */
public class WchatCardLocationBatchaddRes extends BaseRes  implements Serializable {
	private static final long serialVersionUID = -890865015468515169L;
	
	
	
	@JsonProperty("location_id_list")
	private Integer[] locationIdList;   //门店ID。插入失败的门店返回数值“-1”，请核查必填字段后单独调用接口导入。
	

	/**
	 * @return the locationIdList
	 */
	public Integer[] getLocationIdList() {
		return locationIdList;
	}

	/**
	 * @param locationIdList the locationIdList to set
	 */
	public void setLocationIdList(Integer[] locationIdList) {
		this.locationIdList = locationIdList;
	}


}
