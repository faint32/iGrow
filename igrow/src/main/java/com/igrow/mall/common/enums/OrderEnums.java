/**
* @FileName OrderEnums.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-23 上午11:04:27
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName OrderEnums
 * @Description TODO【订单相关枚举】
 * @Author Brights
 * @Date 2013-11-23 上午11:04:27
 */
public class OrderEnums {
	
	public enum OrderClientStatus {
		
		WAIT_PAID(0, "待付款",1),
		WAIT_DELIVER(1, "待发货",2), 
		WAIT_RECEIPTED(2, "待收货",4),
		WAIT_EVALUATE(3, "待评价",8), 
		YES_FINISH(4, "已完成",16), 
		APPLY_RETURN(5, "申请退货",32), 
		YES_RETREAT(6, "已退货",64),
		YES_CANCEL(7, "已取消",128);
		
		private int value;
		private String desc;
		private int code;

		private OrderClientStatus(int value, String desc,int code) {
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

		/**
		 * @return the code
		 */
		public int getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public void setCode(int code) {
			this.code = code;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * @param desc the desc to set
		 */
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
}
