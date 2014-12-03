/**
* @FileName LogService.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-24 下午2:47:33
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.igrow.mall.common.enums.PaymentOrg;

/**
 * @ClassName LogService
 * @Description TODO【日志服务接口】
 * @Author Brights
 * @Date 2013-11-24 下午2:47:33
 */
public interface PaymentLogService {
	
	/**
	* @Title paymentLogProcess
	* @Description TODO【支付日志处理】
	* @param request
	* @param params 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void paymentLogProcess(PaymentOrg paymentOrg,HttpServletRequest request,Map<String,String> params,String sn);
	
	/**
	* @Title productPaymentLogProcess
	* @Description TODO【商品支付日志】
	* @param request
	* @param paymentOrg
	* @param orderSn
	* @param totalFee
	* @param tradeStatus
	* @param tradeNo
	* @param logMsg 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void productPaymentLogProcess(HttpServletRequest request,PaymentOrg paymentOrg, String orderSn, String totalFee, String tradeStatus, String tradeNo,String logMsg,int code);
	
}
