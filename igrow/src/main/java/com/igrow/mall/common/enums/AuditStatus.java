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
 * @ClassName AuditStatus
 * @Description TODO【审核状态】
 * @Author Shiyz
 * @Date 2013-12-27 上午10:59:31
 */
@Alias("EauditStatus")
public enum AuditStatus {
	
	PENDING(0, "待审核"), PASSED(1, "在售"), UNPASSED(2, "未通过"), PULLOFF(3, "已下架");
	
	private int value;
	private String desc;

	private AuditStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public static AuditStatus valueOf(int value){
		for(AuditStatus auditStatus:AuditStatus.values()){
			if(auditStatus.getValue()==value){
			return auditStatus;
		}
	   }
	    return null;
	}
	
	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
