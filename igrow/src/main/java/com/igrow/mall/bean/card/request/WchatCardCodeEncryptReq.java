/**
* @FileName WchatCardCodeConsumeReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:56:35
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardCodeConsumeReq
 * @Description TODO【code解码接口-请求】
 * @Author brights
 * @Date 2014年10月22日 上午11:56:35
 */
public class WchatCardCodeEncryptReq implements Serializable {
	 /*	code 解码接口支持两种场景：
		1.商家获取choos_card_info 后，将card_id 和encrypt_code 字段通过解码接口，获取真实code。
		2.卡券内跳转外链的签名中会对code 进行加密处理，通过调用解码接口获取真实code。*/
	private static final long serialVersionUID = 4052787654188259531L;
	public final String  req_url = "https://api.weixin.qq.com/card/code/decrypt?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("encrypt_code")
	@JsonProperty("encrypt_code")
	private String encryptCode;  //通过choose_card_info 获取的加密字符

	/**
	 * @return the encryptCode
	 */
	public String getEncryptCode() {
		return encryptCode;
	}

	/**
	 * @param encryptCode the encryptCode to set
	 */
	public void setEncryptCode(String encryptCode) {
		this.encryptCode = encryptCode;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
	
	
}
