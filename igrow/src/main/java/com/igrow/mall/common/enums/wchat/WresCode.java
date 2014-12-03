/**
* @FileName WresCode.java
* @Package com.igrow.mall.common.enums.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年11月3日 上午10:23:58
* @Version V1.0.1
*/
package com.igrow.mall.common.enums.wchat;

/**
 * @ClassName WresCode
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年11月3日 上午10:23:58
 */
public enum WresCode {
	
	SYSTEM_BUSY(-1,"系统繁忙"),
	REQUEST_SUCCESS(0,"请求成功"),
	ACCESS_TOKEN_INVALID(40001,"获取access_token时AppSecret错误，或者access_token无效"),
	VOUCHER_TYPE_ILLEGAL(40002,"不合法的凭证类型"),
	OPENID_ILLEGAL(40003,"不合法的OpenID"),
	MEDIA_FILE_TYPES_ILLEGAL(40004,"不合法的媒体文件类型"),
	FILE_TYPES_ILLEGAL(40005,"不合法的文件类型"),
	FILE_SIZE_ILLEGAL(40006,"不合法的文件大小"),
	MEDIA_FILE_ID_ILLEGAL(40007,"不合法的媒体文件id"),
	MESSAGE_TYPE_ILLEGAL(40008,"不合法的消息类型"),
	PICTURE_FILE_SIZE_ILLEGAL(40009,"不合法的图片文件大小"),
	VOICE_FILE_SIZE_ILLEGAL(40010,"不合法的语音文件大小"),
	VIDEO_FILE_SIZE_ILLEGAL(40011,"不合法的视频文件大小"),
	THUMB_FILE_SIZE_ILLEGAL(40012,"不合法的缩略图文件大小"),
/*	ILLEGAL(40013,"不合法的APPID"),
	ILLEGAL(40014,"不合法的access_token"),
	ILLEGAL(40015,"不合法的缩略图文件大小"),
	ILLEGAL(40016,"不合法的缩略图文件大小"),
	ILLEGAL(40017,"不合法的缩略图文件大小"),
	ILLEGAL(40018,"不合法的缩略图文件大小"),
	ILLEGAL(40019,"不合法的缩略图文件大小"),
	ILLEGAL(40020,"不合法的缩略图文件大小"),
	ILLEGAL(40021,"不合法的缩略图文件大小"),
	ILLEGAL(40022,"不合法的缩略图文件大小"),
	ILLEGAL(40023,"不合法的缩略图文件大小"),*/
	;
	
	private int value;
	private String desc;
	
	private WresCode(int value,String desc){
		this.value=value;
		this.desc=desc;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
