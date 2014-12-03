/**
* @FileName PaymentOrderQueryEnums.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年7月8日 下午3:48:33
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName PaymentOrderQueryEnums
 * @Description TODO【支付订单查询相关枚举】
 * @Author Shiyz
 * @Date 2014年7月8日 下午3:48:33
 */
public class PaymentOrderQueryEnums {
	
	/**
	* @ClassName BillPayOrderQueryResponseCode
	* @Description TODO【快钱支付订单查询返回码】
	* @Author Shiyz
	* @Date 2014年7月8日 下午3:50:02
	*/ 
	public enum BillPayOrderQueryResponseCode {
		
		SYSTEM_ERROR(0,"系统错误","99"),
		SYSTEM_ERRORS(1,"系统错误","96"),
		TRADE_NOT_FIND(2,"交易找不到","J0"),
		TRADE_SUCCESS(3,"交易成功","00"),
		INFORMATION_FORMAT_ERROR(4,"信息域格式错误","01"),
		MD5_SIGNATURE_ERROR(5,"MD5签名错误","02"),
		MD5_SIGNATURE_VERIFICATION_FAILED(6,"MD5验签失败","03"),
		SHA1_SIGNATURE_ERROR(7,"SHA-1签名错误","04"),
		SHA1_SIGNATURE_VERIFICATION_FAILED(8,"SHA-1验签失败","05"),
		NETWORK_CANNOT_REACH(9,"网络无法到达","06"),
		WITHOUT_MERCHANT(10,"无此商户","07"),
		WITHOUT_MERCHANT_CAMPUS(11,"无此商户对应校区号","97"),
		URL_ERROR(12,"收到URL地址错误","08"),
		XML_IS_BLANK(13,"收到XML报文为空","09"),
		CANNOT_FIND_GATEWAY_SERVICE_INTERFACE(14,"找不到网关服务接口","10"),
		MESSAGE_FORMAT_ERROR(15,"报文格式错误","11"),
		NON_SUCCESS_RESPONSE_CODE(16,"非成功应答码","12"),
		WITHOUT_SETTLEMENT_MERCHANT(17,"无此结算商户","13"),
		TOTAL_AMOUNT_FORMAT_ERROR(18,"合计金额格式错误","51"),
		REQUEST_TYPE_IS_BLANK(19,"请求类型为空","52"),
		REQUEST_TYPE_ERROR(20,"请求类型错误","53"),
		VOUCHER_NO_IS_BLANK(21,"凭证号为空","54"),
		TRADE_CANCELED(22,"该笔交易已被取消","55"),
		TRADE_IS_NOT_EXIST(23,"该笔交易不存在","56"),
		TRADE_NUMBER_IS_BLANK(24,"平台交易号为空","57"),
		BANK_ACCOUNT_IS_BLANK(25,"银行账号为空","58"),
		TOTAL_AMOUNT_IS_BLANK(26,"合计金额为空","59"),
		PAYMENT_TYPE_IS_BLANK(27,"缴费方式为空","60"),
		VEHICLE_PLATFORM_MERCHANT_IS_NOT_EXIST(28,"车辆平台对应的商户不存在","61"),
		BAR_CODE_IS_NOT_EXIST(29,"条形码不存在","62"),
		POS_MESSAGE_EXCEPTION(30,"POS机信息异常","63"),
		PSO_MESSAGE_DEFECT(31,"POS机信息缺失","64"),
		NOT_GET_CALLER_INFORMATION(32,"无法获取主叫信息","65"),
		TRADE_HAVE_ACCOUNT(33,"交易已到账","88"),
		TRADE_HAVE_EXPIRED(34,"交易号已过期","44"),
		TRADE_HAVE_PAY(35,"此订单已支付","94"),
		NOT_FIND_ORDER(36,"没有找到此订单","93"),
		GOODS_HAVE_INVALID(37,"商品已无效","C1"),
		GOODS_HAVE_EXPIRED(38,"商品已过期","C2"),
		GOODS_HAVE_SOLD_OUT(39,"商品已售完","C3"),
		SYSTEM_EXCEPTION(40,"系统异常","C4"),
		MERCHANT_OR_TERMINALNO_IS_INCORRECT(41,"商户或者终端号不正确","FJ"),
		BUSINESS_HAVE_EXPIRED(42,"该业务已过期","FK"),
		ORDER_STATUS_UNUSUAL(43,"订单状态异常","66");
		
		private BillPayOrderQueryResponseCode(int value,String desc,String code){
			this.value = value;
			this.desc = desc;
			this.code = code;
		}
		private int value;
		private String desc;
		private String code;
		
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
