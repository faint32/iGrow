/**
* @FileName SupplierDeliverStatus.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年6月18日 上午9:52:05
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName SupplierDeliverStatus
 * @Description TODO【供应商物流状态】
 * @Author Brights
 * @Date 2014年6月18日 上午9:52:05
 */
@Alias("EsupplierDeliverStatus")
public enum SupplierDeliverStatus {
	WAITRECEIPT(0, "待收货"), 
	RECEIPTED(1, "已收货"), 
	WAITCANCEL(2, "待取消"), 
	CANCELLED(3, "已取消");
	private int value;
	private String desc;

	private SupplierDeliverStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static SupplierDeliverStatus valueOf(int value){
		for(SupplierDeliverStatus deliveryStatus:SupplierDeliverStatus.values()){
			if(deliveryStatus.getValue()==value){
			return deliveryStatus;
		}
	   }
	    return null;
	}
}
