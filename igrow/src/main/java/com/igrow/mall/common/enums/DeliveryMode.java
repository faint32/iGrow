/**
* @FileName DeliveryType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 上午11:03:44
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName DeliveryType
 * @Description TODO【【配送方式（前台领取、快递发货）】
 * @Author Shiyz
 * @Date 2013-10-29 上午11:13:45
 */
@Alias("EdeliveryMode")
public enum DeliveryMode {
	
	RECEPTION_COLLECTED(0, "前台领取",1), EXPRESS_DELIVERY(1, "快递发货",2);
	private int value;
	private String desc;
	private int code;

	private DeliveryMode(int value, String desc,int code) {
		this.value = value;
		this.desc = desc;
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public static DeliveryMode valueOf(int value){
		for(DeliveryMode deliveryType:DeliveryMode.values()){
			if(deliveryType.getValue()==value){
			return deliveryType;
		}
	   }
	    return null;
	}
	
	public static DeliveryMode codeOf(int code){
		for(DeliveryMode deliveryType:DeliveryMode.values()){
			if(deliveryType.getCode() == code){
			return deliveryType;
		}
	   }
	    return null;
	}
	
}
