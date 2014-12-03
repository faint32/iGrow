/**
* @FileName WchatCardCodeEncryptRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:35:51
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeEncryptRes
 * @Description TODO【code解码接口-请求-返回】
 * @Author brights
 * @Date 2014年10月22日 下午12:35:51
 */
public class WchatCardCodeEncryptRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = 3287076438727023063L;
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code;  //卡券真实序列号

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
