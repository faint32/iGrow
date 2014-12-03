/**
* @FileName CardExtInfo.java
* @Package com.igrow.mall.bean.card.h5
* @Description TODO【商户为该张卡券分配的唯一性信息】
* @Author brights
* @Date 2014年10月24日 下午1:00:02
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi.batchadd;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @ClassName CardExtInfo
 * @Description TODO【商户为该张卡券分配的唯一性信息】
 * @Author brights
 * @Date 2014年10月24日 下午1:00:02
 */
public class CardExtInfo implements Serializable {
	private static final long serialVersionUID = 7293368412952596939L;
	
	@JsonProperty("code")
	private String code;   //指定的卡券code 码，只能被领一次。use_custom_code字段为true 的卡券必须填写，非自定义code 不必填写
	
	@JsonProperty("openid")
	private String openid;   //指定领取者的openid，只有该用户能领取。bind_openid字段为true 的卡券必须填写，非自定义openid 不必填写。
	
	@JsonProperty("timestamp")
	private Long timestamp;   //时间戳，商户生成从1970 年1 月1 日00:00:00 至今的秒数,即当前的时间,且最终需要转换为字符串形式;由商户生成后传入。
	
	
	@JsonProperty("signature")
	private String signature;    //签名，商户将接口列表中的参数按照指定方式进行签名,签名方式使用SHA1,具体签名方案参见下文;由商户按照规范签名后传入。
	
	/*	1．将appsecret、timestamp、card_id、code、openid、balance 的value 值进行字符串的字
	典序排序。
	2．将所有参数字符串拼接成一个字符串进行sha1 加密，得到signature。
	3．signature 中的timestamp 和card_ext 中的timestamp 必须保持一致。
	4．假如数据示例中code=23456，timestamp=141231233，card_id=345667，
	appsecret=45678 则
	signature=sha1(14123123323456345667456789)=4F76593A4245644FAE4E1BC940F6422
	A0C3EC03E。*/
	
	
	@JsonProperty("balance")
	private Long balance;   //红包余额，以分为单位。红包类型必填（LUCKY_MONEY），其他卡券类型不填。

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
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	

	
	
	

}
