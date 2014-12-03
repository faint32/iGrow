/**
* @FileName StatementStatus.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-17 下午12:43:42
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName StatementStatus
 * @Description TODO【结算状态】
 * @Author Brights
 * @Date 2013-12-17 下午12:43:42
 */
@Alias("EstatementStatus")
public enum StatementStatus {

	UNHANDLED(0, "待处理"), PENDING(1, "待结算"), SETTLED(2, "已结算"), NOTSETTLED(2, "暂不结算");
	
	private int value;
	private String desc;

	private StatementStatus(int value, String desc) {
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
