/**
* @FileName InvoiceType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-8 上午10:01:21
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName InvoiceType
 * @Description TODO【发票类型】
 * @Author Brights
 * @Date 2013-11-8 上午10:01:21
 */
@Alias("EinvoiceType")
public enum InvoiceType {
	
	GENERAL(0, "普通发票"), VAT(1, " 增值税发票"), PROFESSION(2, " 专业发票"), OTHER(3, " 其他");
	
	private int value;
	private String desc;

	private InvoiceType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static InvoiceType valueOf(int value){
		for(InvoiceType type:InvoiceType.values()){
			if(type.getValue()==value){
			return type;
		}
	   }
	    return null;
	}
}
