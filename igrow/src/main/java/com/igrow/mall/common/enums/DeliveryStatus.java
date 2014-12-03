/**
* @FileName DeliveryStatus.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-8 上午9:47:40
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName DeliveryStatus
 * @Description TODO【物流状态】
 * @Author Brights
 * @Date 2013-11-8 上午9:47:40
 */
@Alias("EdeliveryStatus")
public enum DeliveryStatus {
	UNSHIPPED(0, "未发货"), 
	PARTSHIPPED(1, "部分发货"), 
	SHIPPED(2, "已发货"), 
	PARTRESHIPED(3, "部分退货"), 
	RESHIPED(4, "全部退货"),
	RECEIPTED(5, "已收货");
	private int value;
	private String desc;

	private DeliveryStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static DeliveryStatus valueOf(int value){
		for(DeliveryStatus deliveryStatus:DeliveryStatus.values()){
			if(deliveryStatus.getValue()==value){
			return deliveryStatus;
		}
	   }
	    return null;
	}

}
