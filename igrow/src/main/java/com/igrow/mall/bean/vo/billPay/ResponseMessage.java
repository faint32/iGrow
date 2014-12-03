/**
* @FileName ResponseMessage.java
* @Package com.igrow.mall.bean.vo.billPay
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年7月8日 上午11:53:55
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo.billPay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ResponseMessage
 * @Description TODO【返回信息】
 * @Author brights
 * @Date 2014年7月8日 上午11:53:55
 */
@XStreamAlias("ResponseMessage")
public class ResponseMessage {
		@XStreamAlias("MAC")
		private  String mac; //签名
		@XStreamAlias("MessageContent")
		private  MessageContent messageContent; //消息内容
		
		/**
		 * @return the mac
		 */
		public String getMac() {
			return mac;
		}

		/**
		 * @param mac the mac to set
		 */
		public void setMac(String mac) {
			this.mac = mac;
		}

		/**
		 * @return the messageContent
		 */
		public MessageContent getMessageContent() {
			return messageContent;
		}

		/**
		 * @param messageContent the messageContent to set
		 */
		public void setMessageContent(MessageContent messageContent) {
			this.messageContent = messageContent;
		}

		/**
		* @ClassName MessageContent
		* @Description TODO【消息内容】
		* @Author Shiyz
		* @Date 2014年7月8日 下午3:19:10
		*/ 
		@XStreamAlias("MessageContent")
		public static class MessageContent {
			@XStreamAlias("reqTime")
			private  String reqTime; //请求时间
			@XStreamAlias("respTime")
			private  String respTime; //返回时间
			@XStreamAlias("responseCode")
			private  String responseCode; //返回码
			@XStreamAlias("responseMsg")
			private String responseMsg; //商户自定义错误
			@XStreamAlias("message")
			private  Message message; //消息
			
			/**
			 * @return the responseMsg
			 */
			public String getResponseMsg() {
				return responseMsg;
			}

			/**
			 * @param responseMsg the responseMsg to set
			 */
			public void setResponseMsg(String responseMsg) {
				this.responseMsg = responseMsg;
			}

			/**
			 * @return the reqTime
			 */
			public String getReqTime() {
				return reqTime;
			}

			/**
			 * @param reqTime the reqTime to set
			 */
			public void setReqTime(String reqTime) {
				this.reqTime = reqTime;
			}

			/**
			 * @return the respTime
			 */
			public String getRespTime() {
				return respTime;
			}

			/**
			 * @param respTime the respTime to set
			 */
			public void setRespTime(String respTime) {
				this.respTime = respTime;
			}

			/**
			 * @return the responseCode
			 */
			public String getResponseCode() {
				return responseCode;
			}

			/**
			 * @param responseCode the responseCode to set
			 */
			public void setResponseCode(String responseCode) {
				this.responseCode = responseCode;
			}

			/**
			 * @return the message
			 */
			public Message getMessage() {
				return message;
			}

			/**
			 * @param message the message to set
			 */
			public void setMessage(Message message) {
				this.message = message;
			}

			/**
			* @ClassName Message
			* @Description TODO【消息类】
			* @Author Shiyz
			* @Date 2014年7月8日 下午3:18:18
			*/ 
			public static class Message { 
				@XStreamAlias("orderId")
				private String orderId; //订单ID
				@XStreamAlias("merchantId")
				private String merchantId; //商户ID
				@XStreamAlias("merchantName")
				private String merchantName; //商户名称
				@XStreamAlias("amt")
				private String amt; //订单金额
				@XStreamAlias("amt2")
				private String amt2; //预留金额2
				@XStreamAlias("amt3")
				private String amt3; //预留金额3
				@XStreamAlias("amt4")
				private String amt4; //预留金额4
				@XStreamAlias("ext")
				private Ext ext; //预留商户自定义信息
				@XStreamAlias("desc")
				private String desc; //备注
				
				/**
				 * @return the orderId
				 */
				public String getOrderId() {
					return orderId;
				}

				/**
				 * @param orderId the orderId to set
				 */
				public void setOrderId(String orderId) {
					this.orderId = orderId;
				}

				/**
				 * @return the merchantId
				 */
				public String getMerchantId() {
					return merchantId;
				}

				/**
				 * @param merchantId the merchantId to set
				 */
				public void setMerchantId(String merchantId) {
					this.merchantId = merchantId;
				}

				/**
				 * @return the merchantName
				 */
				public String getMerchantName() {
					return merchantName;
				}

				/**
				 * @param merchantName the merchantName to set
				 */
				public void setMerchantName(String merchantName) {
					this.merchantName = merchantName;
				}

				/**
				 * @return the amt
				 */
				public String getAmt() {
					return amt;
				}

				/**
				 * @param amt the amt to set
				 */
				public void setAmt(String amt) {
					this.amt = amt;
				}

				/**
				 * @return the amt2
				 */
				public String getAmt2() {
					return amt2;
				}

				/**
				 * @param amt2 the amt2 to set
				 */
				public void setAmt2(String amt2) {
					this.amt2 = amt2;
				}

				/**
				 * @return the amt3
				 */
				public String getAmt3() {
					return amt3;
				}

				/**
				 * @param amt3 the amt3 to set
				 */
				public void setAmt3(String amt3) {
					this.amt3 = amt3;
				}

				/**
				 * @return the amt4
				 */
				public String getAmt4() {
					return amt4;
				}

				/**
				 * @param amt4 the amt4 to set
				 */
				public void setAmt4(String amt4) {
					this.amt4 = amt4;
				}

				/**
				 * @return the ext
				 */
				public Ext getExt() {
					return ext;
				}

				/**
				 * @param ext the ext to set
				 */
				public void setExt(Ext ext) {
					this.ext = ext;
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

				/**
				* @ClassName Ext
				* @Description TODO【预留商户自定义信息】
				* @Author Shiyz
				* @Date 2014年7月8日 下午3:17:39
				*/ 
				public static class Ext{  
					@XStreamAlias("userdata1")
					private Userdata userdata1; //用户自定义POS机显示字段
					@XStreamAlias("userdata2")
					private Userdata userdata2; //用户自定义POS机显示字段
					@XStreamAlias("userdata3")
					private Userdata userdata3; //用户自定义POS机显示字段
					@XStreamAlias("userdata4")
					private Userdata userdata4; //用户自定义小票备注打印字段
					@XStreamAlias("userdata5")
					private Userdata userdata5; //用户自定义小票备注打印字段
					@XStreamAlias("userdata6")
					private Userdata userdata6; //用户自定义小票备注打印字段
					
					/**
					 * @return the userdata1
					 */
					public Userdata getUserdata1() {
						return userdata1;
					}

					/**
					 * @param userdata1 the userdata1 to set
					 */
					public void setUserdata1(Userdata userdata1) {
						this.userdata1 = userdata1;
					}

					/**
					 * @return the userdata2
					 */
					public Userdata getUserdata2() {
						return userdata2;
					}

					/**
					 * @param userdata2 the userdata2 to set
					 */
					public void setUserdata2(Userdata userdata2) {
						this.userdata2 = userdata2;
					}

					/**
					 * @return the userdata3
					 */
					public Userdata getUserdata3() {
						return userdata3;
					}

					/**
					 * @param userdata3 the userdata3 to set
					 */
					public void setUserdata3(Userdata userdata3) {
						this.userdata3 = userdata3;
					}

					/**
					 * @return the userdata4
					 */
					public Userdata getUserdata4() {
						return userdata4;
					}

					/**
					 * @param userdata4 the userdata4 to set
					 */
					public void setUserdata4(Userdata userdata4) {
						this.userdata4 = userdata4;
					}

					/**
					 * @return the userdata5
					 */
					public Userdata getUserdata5() {
						return userdata5;
					}

					/**
					 * @param userdata5 the userdata5 to set
					 */
					public void setUserdata5(Userdata userdata5) {
						this.userdata5 = userdata5;
					}

					/**
					 * @return the userdata6
					 */
					public Userdata getUserdata6() {
						return userdata6;
					}

					/**
					 * @param userdata6 the userdata6 to set
					 */
					public void setUserdata6(Userdata userdata6) {
						this.userdata6 = userdata6;
					}

					/**
					* @ClassName Userdata
					* @Description TODO【商户自定义数据字段类】
					* @Author brights
					* @Date 2014年7月8日 下午3:16:49
					*/ 
					public static class Userdata{ 
						@XStreamAlias("value")
						private String value;//自定义字段值
						@XStreamAlias("chnName")
						private String chnName; //自定义字段值解释
						
						/**
						 * @return the value
						 */
						public String getValue() {
							return value;
						}
						/**
						 * @param value the value to set
						 */
						public void setValue(String value) {
							this.value = value;
						}
						/**
						 * @return the chnName
						 */
						public String getChnName() {
							return chnName;
						}
						/**
						 * @param chnName the chnName to set
						 */
						public void setChnName(String chnName) {
							this.chnName = chnName;
						}
					}
					
				}
				
				
			}
			
			
	}
		
}
