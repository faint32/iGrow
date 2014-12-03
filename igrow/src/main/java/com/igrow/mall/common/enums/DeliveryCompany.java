/**
* @FileName DeliveryCompany.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-02 下午17:17:41
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName DeliveryCompany
 * @Description TODO【快递物流】
 * @Author Shiyz
 * @Date 2013-11-02 下午17:17:41
 */
@Alias("EdeliveryCompany")
public enum DeliveryCompany {
	RECEPTION_COLLECTED(100,"frontget", "前台领取"),
	YUAN_TONG(0,"yuantong", "圆通快递"), SHEN_TONG(1,"shentong","申通快递"), ZHONG_TONG(2,"zhongtong","中通快递"), YUN_DA(3,"yunda","韵达快递"),
	TIAN_TIAN(4,"tiantian","天天快递"),SHUN_FENG(5,"shunfeng","顺丰快递"),EMS(6,"ems","EMS"),HUI_TONG(7,"huitongkuaidi","汇通快递"),
	QUAN_FENG(8,"quanfengkuaidi","全峰快递"),YOU_ZHENG(9,"youzhengguonei","邮政快递"),GUO_TONG(10,"guotongkuaidi","国通快递");
	private int value;
	private String code;
	private String desc;

	private DeliveryCompany(int value,String code, String desc) {
		this.value = value;
		this.desc = desc;
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public String getCode() {
		return code;
	}
	
	public static DeliveryCompany valueOf(int value){
		for(DeliveryCompany deliveryCompany:DeliveryCompany.values()){
			if(deliveryCompany.getValue() == value){
			return deliveryCompany;
		}
	   }
	    return null;
	}
}
