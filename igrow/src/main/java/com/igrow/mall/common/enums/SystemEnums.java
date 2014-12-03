package com.igrow.mall.common.enums;

import org.apache.commons.lang.StringUtils;

/**
* @ClassName SystemEnums
* @Description TODO【系统相关枚举】
* @Author Brights
* @Date 2013-10-24 上午10:15:00
*/ 
public class SystemEnums {
	
	/**
	* @ClassName OrderRemind
	* @Description TODO【订单提醒枚举】
	* @Author Brights
	* @Date 2013-10-24 上午10:21:24
	*/ 
	public enum OrderRemind{
		IS_SMS(0,"是否短信提醒"),
		IS_EMAIL(1,"是否邮件提醒");
		private int value;
		private String desc;

		private OrderRemind(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}
		
		/**
		* @Title valueOf
		* @Description TODO【获取枚举类型】
		* @param value
		* @return 
		* @Return OrderRemind 返回类型
		* @Throws 
		*/ 
		public OrderRemind valueOf(int value){
			for(OrderRemind remind: OrderRemind.values()){
				if(remind.getValue() == value){
					return remind;
				}
			}
			return null;
		}
		
		public int getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}
	
	/**
	* @ClassName OperateStatus
	* @Description TODO【操作状态】
	* @Author Brights
	* @Date 2013-10-24 下午2:21:55
	*/ 
	public enum OperateStatus {
		ERROR("n","操作失败"), SUCCESS("y","操作成功");
		private OperateStatus(String status,String message){
			this.message = message;
			this.status = status;
		}
		
		private String status;
		private String message;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	/**
	* @ClassName SmsBusinessType
	* @Description TODO【短信业务类型】
	* @Author Brights
	* @Date 2013-10-28 上午10:58:05
	*/ 
	public enum SmsBusinessType{
		/**
		 * 注册
		 */
		SMS_REG(0,"注册",3),
		/**
		 * 注册
		 */
		SMS_LOGIN(1,"登录",3),
		/**
		 * 支付
		 */
		SMS_PAY(2,"支付",3),
		/**
		 * 物流
		 */
		SMS_LGS(3,"物流",1),
		/**
		 * 群发
		 */
		SMS_MASS(4,"群发",1);
		
		private int value;
		private String desc;
		private int priority;
		
		private SmsBusinessType(int value, String desc,int priority) {
			this.value = value;
			this.desc = desc;
			this.priority = priority;
		}
		public int getValue() {
			return value;
		}
		public String getDesc() {
			return desc;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
	}
	
	/**
	* @ClassName MessagePassage
	* @Description TODO【消息通道】
	* @Author Brights
	* @Date 2013-10-28 下午2:33:19
	*/ 
	public enum MessagePassage{
		SMS(0,"sms"),
		EMAIL(1,"email");
		
		private int value;
		private String desc;
		
		private MessagePassage(int value, String desc) {
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
	
	/**
	* @ClassName SmsSupplier
	* @Description TODO【短信供应商】
	* @Author Brights
	* @Date 2014-1-14 下午12:47:37
	*/ 
	public enum SmsSupplier{
		MD(0,"md","漫道"),
		emay(1,"emay","亿美");
		
		private int value;
		private String code;
		private String name;
		
		private SmsSupplier(int value, String code,String name) {
			this.value = value;
			this.code = code;
		}
		public int getValue() {
			return value;
		}
		
		public static SmsSupplier valueOf(int value){
			for(SmsSupplier ss: SmsSupplier.values()){
				if(ss.getValue() == value){
					return ss;
				}
			}
			return null;
		}
		
		public static SmsSupplier codeOf(String code){
			if(StringUtils.isNotBlank(code)){
				for(SmsSupplier ss: SmsSupplier.values()){
					if(ss.getCode().equals(code)){
						return ss;
					}
				}
			}
			return null;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	}
	
	
	
	
}
