/**
* @FileName BaseRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:31:07
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName BaseRes
 * @Description TODO【请求回复数据】
 * @Author brights
 * @Date 2014年10月22日 上午10:31:07
 */
public class BaseRes implements Serializable {

	private static final long serialVersionUID = -2778091660996272351L;
	
	public static String PREFIX_RES = "{\"res\": ";
	public static String SUFFIX_RES = "}";
	
	@XStreamAlias("errcode")
	@JsonProperty("errcode")
	protected Integer errcode;   // 错误码，0 为正常
	
	@XStreamAlias("errmsg")
	@JsonProperty("errmsg")
	protected String errmsg;   // 错误信息
	

	/**
	 * @return the errcode
	 */
	public Integer getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
