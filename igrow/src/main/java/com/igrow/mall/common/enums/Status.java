/**
* @FileName Status.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 上午11:03:44
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Status
 * @Description TODO【状态】
 * @Author Brights
 * @Date 2013-10-23 上午11:03:44
 */
@Alias("Estatus")
public enum Status {
	Disabled(0, "停用"), Enabled(1, "启用");
	private int value;
	private String desc;

	private Status(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Status getStatus(int value){
		for(Status status:Status.values()){
			if(status.getValue()==value){
			return status;
		}
	   }
	    return null;
	}
}
