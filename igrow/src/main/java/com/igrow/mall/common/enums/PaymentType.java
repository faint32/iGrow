package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
* @ClassName PaymentType
* @Description TODO【支付类型】
* @Author Brights
* @Date 2013-11-8 上午9:44:31
*/ 
@Alias("EpaymentType")
public enum PaymentType {
	ONLINE(0, "在线"), OFFLINE(1, "线下"),OTHER(2, "other");
	//1，线下；2，微信；4，支付宝 6:线上（支付宝+微信） 7：两者（线上线下）都有（支付宝+微信+线下）
	private int value;
	private String desc;

	private PaymentType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static PaymentType valueOf(int value){
		for(PaymentType paymentType:PaymentType.values()){
			if(paymentType.getValue()==value){
			return paymentType;
		}
	   }
	    return null;
	}

}
