/**
* @FileName WchatChooseCard.java
* @Package com.igrow.mall.bean.card.jsapi
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午1:41:20
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi.req;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @ClassName WchatChooseCard
 * @Description TODO【ChooseCard接口请求】
 * @Author brights
 * @Date 2014年10月24日 下午1:41:20
 */
public class WchatChooseCardReq implements Serializable{
	
	private static final long serialVersionUID = -5996007935960078614L;
	public static final String js_api_name = "chooseCard";
	
/*	app_id 公众号appID 是
	location_id 门店信息是
	sign_type 签名方式，目前仅支持SHA1 是
	card_sign 签名是
	time_stamp 时间戳是
	nonce_str 随机字符串是
	card_id
	生成卡券时获得的card_id，可拉起指定id 的卡券列
	表。当card_id 为空时默认拉起所有卡券的列表。
	否
	card_type
	卡券类型，可拉起指定类型的卡券列表。当
	card_type 为空时，默认拉起所有卡券的列表。
	否*/
	
	@JsonProperty("app_id")
	private String appId;   //公众号appID
	
	@JsonProperty("location_id")
	private String locationId;   //门店信息id
	
	@JsonProperty("sign_type")
	private String signType;   //签名方式
	
	@JsonProperty("card_sign")
	private String cardSign;   //签名
	/*签名字段：
	字段说明是否必填
	appsecret 第三方用户唯一凭证密钥是
	app_id 公众号appID 是
	location_id 门店信息是
	time_stamp 时间戳是
	nonce_str 随机字符串是
	card_id 生成卡券时获得的card_id 否
	card_type 卡券类型否
	签名方式：
	3. 将appsecret、app_id、location_id、times_tamp、nonce_str、card_id、card_type的value
	值进行字符串的字典序排序。
	4. 将所有参数字符串拼接成一个字符串进行sha1加密，得到signature。
	5. signature中的timestamp和card_ext中的timestamp必须保持一致。*/
	
	@JsonProperty("time_stamp")
	private Integer timeStamp;   // 时间戳是
	
	@JsonProperty("nonce_str")
	private String nonceStr;   //随机字符串是
	
	@JsonProperty("card_id")
	private String cardId;   //生成卡券时获得的card_id，可拉起指定id 的卡券列表。当card_id 为空时默认拉起所有卡券的列表。
	
	@JsonProperty("card_type")
	private String cardType;   //卡券类型，可拉起指定类型的卡券列表。当card_type 为空时，默认拉起所有卡券的列表。

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * @return the signType
	 */
	public String getSignType() {
		return signType;
	}

	/**
	 * @return the cardSign
	 */
	public String getCardSign() {
		return cardSign;
	}

	/**
	 * @return the timeStamp
	 */
	public Integer getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @return the nonceStr
	 */
	public String getNonceStr() {
		return nonceStr;
	}

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	/**
	 * @param signType the signType to set
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}

	/**
	 * @param cardSign the cardSign to set
	 */
	public void setCardSign(String cardSign) {
		this.cardSign = cardSign;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Integer timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @param nonceStr the nonceStr to set
	 */
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	//注：不建议同时填写card_id 和card_type。
	
	
	
	

}
