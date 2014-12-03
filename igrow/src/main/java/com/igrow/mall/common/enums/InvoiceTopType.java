/**
* @FileName InvoiceTopType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-7 下午11:17:21
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName InvoiceTopType
 * @Description TODO【发票头部类型】
 * @Author Brights
 * @Date 2013-11-7 下午11:17:21
 */
@Alias("EinvoiceTopType")
public enum InvoiceTopType {
	NONE(0, "无"),PERSONAL(1, "个人"), COMPANY(2, "公司");
	
	private int value;
	private String desc;

	private InvoiceTopType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static InvoiceTopType valueOf(int value){
		for(InvoiceTopType type:InvoiceTopType.values()){
			if(type.getValue()==value){
			return type;
		}
	   }
	    return null;
	}

}
