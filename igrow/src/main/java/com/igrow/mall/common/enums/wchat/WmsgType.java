/**
* @FileName MsgType.java
* @Package com.fwchat.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月13日 下午4:58:02
* @Version V1.0.1
*/
package com.igrow.mall.common.enums.wchat;

/**
 * @ClassName WmsgType
 * @Description TODO【消息类型】
 * @Author 消息类型
 * @Date 2014年8月13日 下午4:58:02
 */
public enum WmsgType {
	
	TEXT(0,"text"),//文本
	IMAGE(1,"image"),//图片
	VOICE(2,"voice"),//音频
	VIDEO(2,"video"),//视频
	NEWS(2,"news"),//图文
	LOCATION(2,"location"),//地理
	LINK(2,"link"),//链接
	EVENT(2,"event"), //事件
	TRANSFER_CUSTOMER_SERVICE(2,"transfer_customer_service"); //转发多客服
	
    private int value;
	private String desc;
	
	private WmsgType(int value,String desc){
		this.value=value;
		this.desc=desc;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
