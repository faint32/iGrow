/**
* @FileName Bool.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午3:44:57
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Bool
 * @Description TODO【是否】
 * @Author Brights
 * @Date 2013-10-18 下午3:44:57
 */
@Alias("Ebool")
public enum Bool {
	FALSE(0, "否"), TRUE(1, "是");
	private int value;
	private String desc;

	private Bool(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Bool valueOf(int value){
		for(Bool bool:Bool.values()){
			if(bool.getValue()==value){
			return bool;
		}
	   }
	    return null;
	}
}
