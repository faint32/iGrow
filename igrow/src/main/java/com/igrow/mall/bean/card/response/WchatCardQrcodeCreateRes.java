/**
* @FileName WchatCardQrcodeCreateRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:50:56
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardQrcodeCreateRes
 * @Description TODO【生成卡券二维码请求返回】
 * @Author brights
 * @Date 2014年10月22日 上午11:50:56
 */
public class WchatCardQrcodeCreateRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = 4131273678201611405L;
	
	@XStreamAlias("ticket")
	@JsonProperty("ticket")
	private String ticket ;  //获取的二维码ticket，凭借此ticket 可以在有效时间内换取二维码。
	
	@XStreamAlias("url")
	@JsonProperty("url")
	private String url;

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
