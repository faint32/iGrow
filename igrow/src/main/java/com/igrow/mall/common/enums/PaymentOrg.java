package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
* @ClassName PaymentOrg
* @Description TODO【支付机构】
* @Author Brights
* @Date 2013-11-8 上午9:44:31
*/ 
@Alias("EpaymentOrg")
public enum PaymentOrg {
	
	ALIPAY(0, "支付宝","alipay",PaymentType.ONLINE,"支付宝"), 
	FRONTDESK(1, "前台支付","frontDesk",PaymentType.OFFLINE,"前台"),
	WXPAY(2, "微信支付","wxpay",PaymentType.ONLINE,"微信"),
	BILLPAY(3, "快钱支付","99billpay",PaymentType.OFFLINE,"POS机");
	
	private int value;
	private String desc;
	private String code;
	private PaymentType paymentType;
	private String orgName;

	private PaymentOrg(int value, String desc, String code,PaymentType paymentType,String orgName) {
		this.value = value;
		this.desc = desc;
		this.code = code;
		this.paymentType = paymentType;
		this.orgName = orgName;
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

	public void setCode(String code) {
		this.code = code;
	}
	public static PaymentOrg valueOf(int value){
		for(PaymentOrg paymentOrg:PaymentOrg.values()){
			if(paymentOrg.getValue()==value){
			return paymentOrg;
		}
	   }
	    return null;
	}

	/**
	 * @return the paymentType
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
