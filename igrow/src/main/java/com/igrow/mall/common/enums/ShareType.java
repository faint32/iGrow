/**
* @FileName ShareType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-31 上午10:49:48
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName ShareType
 * @Description TODO【分享类型】
 * @Author shiyz
 * @Date 2014-04-24 上午10:49:48
 */
@Alias("EshareType")
public enum ShareType {
	MOMENTS(0, "朋友圈"), FRIEND(1, "微信好友"),WEIBO(2, "微博");
	private int value;
	private String desc;

	private ShareType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static ShareType getShareType(int value){
		for(ShareType shareType : ShareType.values()){
			if(shareType.getValue() == value){
				return shareType;
			}
	   }
	    return null;
	}

}
