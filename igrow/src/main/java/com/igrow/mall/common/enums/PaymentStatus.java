package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
* @ClassName PaymentStatus
* @Description TODO【支付状态】
* @Author Brights
* @Date 2013-11-8 上午9:44:31
*/ 
@Alias("EpaymentStatus")
public enum PaymentStatus {
	UNPAID(0, "未支付"), PARTPAYMENT(1, "部分支付"), PAID(2, "已支付"), PARTREFUND(3, "部分退款"), REFUNDED(3, "全部退款");
	private int value;
	private String desc;

	private PaymentStatus(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static PaymentStatus valueOf(int value){
		for(PaymentStatus paymentStatus:PaymentStatus.values()){
			if(paymentStatus.getValue()==value){
			return paymentStatus;
		}
	   }
	    return null;
	}

}
