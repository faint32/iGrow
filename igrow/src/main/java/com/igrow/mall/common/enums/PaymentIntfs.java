/**
* @FileName PaymentIntfs.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-19 下午9:33:54
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName PaymentIntfs
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-11-19 下午9:33:54
 */
public enum PaymentIntfs {
	
	COMMON_NOTIFY(0,"100", "commonNotifyHandleImpl","统一支付异步通知"),
	ALIPAY_WAP_NOTIFY(1,"101", "alipayWapNotifyHandleImpl","支付宝手机网页支付异步通知"),
	ALIPAY_APP_NOTIFY(2,"102","alipayAppNotifyHandleImpl","支付宝移动快捷支付异步通知"),
	ALIPAY_APK_NOTIFY(3,"103","alipayApkNotifyHandleImpl","支付宝移动快捷支付异步通知"),
	ALIPAY_SETTLE_NOTIFY(4,"104","alipaySettleNotifyHandleImpl","支付宝付款结算异步通知"),
	WXPAY_WAP_NOTIFY(5,"201", "wxpayWapNotifyHandleImpl","微信支付手机网页支付异步通知"),
	WXPAY_APP_NOTIFY(6,"202","wxpayAppNotifyHandleImpl","微信支付移动快捷支付异步通知"),
	WXPAY_APK_NOTIFY(7,"203","wxpayApkNotifyHandleImpl","微信支付移动快捷支付异步通知"),
	WXPAY_RIGHTS_NOTIFY(9,"203","wxpayRightsNotifyHandleImpl","微信支付维权异步通知"),
	WXPAY_NOTICE_NOTIFY(10,"203","wxpayNoticeNotifyHandleImpl","微信支付告警异步通知"),
	CARD_99BILL_PAY__NOTIFY(8,"204","card99BillPayNotifyHandleImpl","刷卡快钱支付实时通知");
	
	
	private PaymentIntfs(int value,String code,String impl,String desc){
		this.value = value;
		this.code = code;
		this.impl = impl;
		this.desc = desc;
	}
	
	
	/**
	* @Title codeOf
	* @Description TODO【依据编码获取接口】
	* @param code
	* @return 
	* @Return PaymentIntfs 返回类型
	* @Throws 
	*/ 
	public static PaymentIntfs codeOf(String code){
		for(PaymentIntfs intf: PaymentIntfs.values()){
			if(code.equals(intf.getCode())){
				return intf;
			}
		}
		return null;
	}
	
	private int value;
	private String code;
	private String impl;
	private String desc;
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the impl
	 */
	public String getImpl() {
		return impl;
	}
	/**
	 * @param impl the impl to set
	 */
	public void setImpl(String impl) {
		this.impl = impl;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
