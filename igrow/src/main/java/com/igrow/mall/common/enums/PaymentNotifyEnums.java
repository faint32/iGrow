/**
* @FileName PaymentNotifyEnums.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年7月8日 上午10:10:19
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName PaymentNotifyEnums
 * @Description TODO【支付通知枚举】
 * @Author brights
 * @Date 2014年7月8日 上午10:10:19
 */
public class PaymentNotifyEnums {
	
	/**
	* @ClassName CommonNotifyResult
	* @Description TODO【通知返回结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:13:36
	*/ 
	public enum CommonNotifyResult {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private CommonNotifyResult(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	* @ClassName CommonTradeStatus
	* @Description TODO【交易结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:31:43
	*/ 
	public enum CommonTradeStatus {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private CommonTradeStatus(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	* @ClassName AlipayNotifyResult
	* @Description TODO【支付包通知返回结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:13:36
	*/ 
	public enum AlipayNotifyResult {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private AlipayNotifyResult(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	* @ClassName AlipayTradeStatus
	* @Description TODO【支付宝交易结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:31:43
	*/ 
	public enum AlipayTradeStatus {
		FINISHED(0,"TRADE_FINISHED"),SUCCESS(1,"TRADE_SUCCESS");
		private AlipayTradeStatus(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	
	/**
	* @ClassName WxNotifyResult
	* @Description TODO【微信通知返回结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:13:36
	*/ 
	public enum WxNotifyResult {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private WxNotifyResult(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	* @ClassName WxTradeStatus
	* @Description TODO【微信交易结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:31:43
	*/ 
	public enum WxTradeStatus {
		SUCCESS(0,"TRADE_SUCCESS");
		private WxTradeStatus(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	
	/**
	* @ClassName BillPayNotifyResult
	* @Description TODO【快钱通知返回结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:13:36
	*/ 
	public enum BillPayNotifyResult {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private BillPayNotifyResult(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	* @ClassName BillTradeStatus
	* @Description TODO【快钱交易结果】
	* @Author Brights
	* @Date 2013-11-15 上午11:31:43
	*/ 
	public enum BillTradeStatus {
		SUCCESS(0,"success"),FAIL(1,"fail");
		private BillTradeStatus(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		private int value;
		private String desc;
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	
	
}
