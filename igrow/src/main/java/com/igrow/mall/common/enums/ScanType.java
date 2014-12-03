/**
* @FileName ScanType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-31 上午10:49:48
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName ScanType
 * @Description TODO【扫描类型】
 * @Author Brights
 * @Date 2013-10-31 上午10:49:48
 */
@Alias("EscanType")
public enum ScanType {
	SHARE(0, "分享"), OTHER(1, "其他");
	private int value;
	private String desc;

	private ScanType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static ScanType getScanType(int value){
		for(ScanType scanType : ScanType.values()){
			if(scanType.getValue() == value){
				return scanType;
			}
	   }
	    return null;
	}

}
