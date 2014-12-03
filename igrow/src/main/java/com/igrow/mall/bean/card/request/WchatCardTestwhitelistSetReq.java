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
 * @ClassName WchatCardTestwhitelistSetReq
 * @Description TODO【设置测试用户白名单】
 * @Author brights
 * @Date 2014年10月21日 下午6:43:59
 */
public class WchatCardTestwhitelistSetReq  implements Serializable{
	private static final long serialVersionUID = 6699975667934684510L;
	
	/*由于卡券有审核要求，为方便公众号调试，可以设置一些测试帐号，这些帐号可以领取未通过审核
	的卡券，体验整个流程。
	注：同时支持“openid”、“username”两种字段设置白名单，总数上限为10 个*/

	public final String  req_url = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("openid")
	@JsonProperty("openid")
	private String[] openid; //测试的openid 列表
	
	@XStreamAlias("username")
	@JsonProperty("username")
	private String[] username; //测试的微信号列表

	/**
	 * @return the openid
	 */
	public String[] getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String[] openid) {
		this.openid = openid;
	}

	/**
	 * @return the username
	 */
	public String[] getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String[] username) {
		this.username = username;
	}

	
	
	
	

}
