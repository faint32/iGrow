/**
* @FileName OrderStatus.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午11:03:44
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName OrderAllStatus
 * @Description TODO【订单的状态】
 * @Author Shiyz
 * @Date 2013-10-29 上午11:03:44
 */
@Alias("EorderStatus")
public enum OrderStatus {
	UNPROCESSED(0, "未处理"), PROCESSED(1, "已处理"), COMPLETED(2, "已完成"), INVALID(3, "已作废");
	private int value;
	private String desc;

	private OrderStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static OrderStatus valueOf(int value){
		for(OrderStatus orderStatus:OrderStatus.values()){
			if(orderStatus.getValue()==value){
			return orderStatus;
		}
	   }
	    return null;
	}
}
