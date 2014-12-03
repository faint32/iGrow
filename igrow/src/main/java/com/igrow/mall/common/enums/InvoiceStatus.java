/**
* @FileName InvoiceStatus.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-23 上午10:59:31
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName InvoiceStatus
 * @Description TODO【开票状态】
 * @Author Brights
 * @Date 2013-12-23 上午10:59:31
 */
@Alias("EinvoiceStatus")
public enum InvoiceStatus {
	
	PENDING(0, "申请中"), PASSED(1, "已通过"), UNPASSED(2, "未通过");
	
	private int value;
	private String desc;

	private InvoiceStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
