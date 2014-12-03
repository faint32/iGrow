package com.igrow.mall.common.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
* @ClassName PaymentOrg
* @Description TODO【支付产品】
* @Author Brights
* @Date 2013-11-8 上午9:44:31
*/ 
@Alias("EpaymentProduct")
public enum PaymentProduct {
	
	ALIPAY_DIRECT_PAY(0, "支付宝及时到账","alipay_direct_pay",PaymentOrg.ALIPAY,"RSA"), 
	WXPAY_DIRECT_PAY(1, "微信及时到账","wxpay_direct_pay",PaymentOrg.WXPAY,"RSA"), 
	BILLPAY_CARD_PAY(2, "快钱刷卡支付","99billpay_card_pay",PaymentOrg.BILLPAY,"RSA"), 
	OTHER(10, "其他","other",PaymentOrg.ALIPAY,"NO");
	
	private int value;
	private String desc;
	private String code;
	private PaymentOrg paymentOrg;
	private String signType;

	private PaymentProduct(int value, String desc, String code,PaymentOrg paymentOrg,String signType) {
		this.value = value;
		this.desc = desc;
		this.code = code;
		this.paymentOrg = paymentOrg;
		this.signType = signType;
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
	/**
	* @Title valueOf
	* @Description TODO【支付产品】
	* @param value
	* @return 
	* @Return PaymentProduct 返回类型
	* @Throws 
	*/ 
	public static PaymentProduct valueOf(int value){
		for(PaymentProduct product:PaymentProduct.values()){
			if(product.getValue()==value){
			return product;
		}
	   }
	    return null;
	}
	
	/**
	* @Title valuesOf
	* @Description TODO【依据支付机构获取支付产品】
	* @param paymentOrg
	* @return 
	* @Return List<PaymentProduct> 返回类型
	* @Throws 
	*/ 
	public static List<PaymentProduct> valuesOf(PaymentOrg paymentOrg){
		List<PaymentProduct> paymentProducts = new ArrayList<PaymentProduct>();
		for(PaymentProduct product:PaymentProduct.values()){
			if(paymentOrg == product.getPaymentOrg()){
				paymentProducts.add(product);
			}else{
				continue;
			}
		}
		return paymentProducts;
	}

	public PaymentOrg getPaymentOrg() {
		return paymentOrg;
	}

	public void setPaymentOrg(PaymentOrg paymentOrg) {
		this.paymentOrg = paymentOrg;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

}
