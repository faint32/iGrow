/**
* @FileName Card.java
* @Package com.igrow.mall.bean.card.request.qrcode
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:45:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.qrcode;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;



/**
 * @ClassName Card
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月22日 上午11:45:12
 */
public class Card implements Serializable {
	private static final long serialVersionUID = 3166700156636810254L;
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId ;  //卡券ID
	
	
	@XStreamAlias("code")
	@JsonProperty("code")
	private String code ;  //指定卡券code 码，只能被领一次。use_custom_code 字段为true 的卡券必须填写，非自定义code 不必填写。
	
	
	@XStreamAlias("openid")
	@JsonProperty("openid")
	private String openid ;  //指定领取者的openid，只有该用户能领取。bind_openid 字段为true 的卡券必须填写，非自定义openid 不必填写。
	
	
	@XStreamAlias("expire_seconds")
	@JsonProperty("expire_seconds")
	private Integer expireSeconds ;  //指定二维码的有效时间，范围是60 ~ 1800 秒。不填默认为永久有效。
	
	
	
	@XStreamAlias("is_unique_code")
	@JsonProperty("is_unique_code")
	private Boolean isUniqueCode = false ;  //指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true 或false。默认false。



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



	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}



	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}



	/**
	 * @return the expireSeconds
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}



	/**
	 * @param expireSeconds the expireSeconds to set
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}



	/**
	 * @return the isUniqueCode
	 */
	public Boolean getIsUniqueCode() {
		return isUniqueCode;
	}



	/**
	 * @param isUniqueCode the isUniqueCode to set
	 */
	public void setIsUniqueCode(Boolean isUniqueCode) {
		this.isUniqueCode = isUniqueCode;
	}




}
