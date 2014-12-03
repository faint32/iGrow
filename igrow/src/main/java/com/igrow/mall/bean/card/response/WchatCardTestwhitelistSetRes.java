/**
* @FileName WchatCardTestwhitelistSetRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午2:19:44
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @ClassName WchatCardTestwhitelistSetRes
 * @Description TODO【设置测试用户白名单-请求返回】
 * @Author brights
 * @Date 2014年10月22日 下午2:19:44
 */
public class WchatCardTestwhitelistSetRes extends BaseRes implements
		Serializable {
	private static final long serialVersionUID = -3723398018142561363L;
	
	@JsonProperty("white_list_size")
	private Integer whiteListSize; //百名单数量

	/**
	 * @return the whiteListSize
	 */
	public Integer getWhiteListSize() {
		return whiteListSize;
	}

	/**
	 * @param whiteListSize the whiteListSize to set
	 */
	public void setWhiteListSize(Integer whiteListSize) {
		this.whiteListSize = whiteListSize;
	}

}
