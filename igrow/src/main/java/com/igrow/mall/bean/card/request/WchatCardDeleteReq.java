/**
* @FileName WchatCardDeleteReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:38:05
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardDeleteReq
 * @Description TODO【微信卡券删除请求数据】
 * @Author brights
 * @Date 2014年10月22日 下午12:38:05
 */
public class WchatCardDeleteReq implements Serializable {
	
	/*删除卡券接口允许商户删除任意一类卡券。删除卡券后，该卡券对应已生成的领取用二维码、添加
	到卡包JS API 均会失效。
	注意：如用户在商家删除卡券前已领取一张或多张该卡券依旧有效。即删除卡券不能删除已被用户
	领取，保存在微信客户端中的卡券。*/
	
	private static final long serialVersionUID = 1317241377064234459L;
	public final String  req_url = "https://api.weixin.qq.com/card/delete?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //卡券ID
	

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
