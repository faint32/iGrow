/**
* @FileName OrderAllStatus.java
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
 * @Description TODO【订单总的查询状态】
 * @Author Shiyz
 * @Date 2013-10-29 上午11:03:44
 */
@Alias("EorderQueryStatus")
public enum OrderQueryStatus {
	
	WAIT_PAID(0, "待付款"),
	WAIT_DELIVER(1, "待发货"), 
	WAIT_RECEIPTED(2, "待收货"),
	YES_FINISH(3, "已完成"), 
	APPLY_RETURN(4, "申请退货"), 
	YES_RETREAT(5, "已退货"),
	YES_CANCEL(6, "已取消"),
	YES_GET(7, "前台已领");
	
	private int value;
	private String desc;

	private OrderQueryStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static OrderQueryStatus valueOf(int value){
		for(OrderQueryStatus orderAllStatus:OrderQueryStatus.values()){
			if(orderAllStatus.getValue()==value){
			return orderAllStatus;
		}
	   }
	    return null;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
