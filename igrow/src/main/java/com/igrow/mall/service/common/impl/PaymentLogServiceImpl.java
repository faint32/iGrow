/**
* @FileName LogServiceImpl.java
* @Package com.igrow.mall.service.common.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-24 下午2:51:02
* @Version V1.0.1
*/
package com.igrow.mall.service.common.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Setting;
import com.igrow.mall.common.enums.PaymentOrg;
import com.igrow.mall.common.payment.alipay.util.AlipayAppNotify;
import com.igrow.mall.common.payment.tenpay.util.WXUtil;
import com.igrow.mall.common.util.LogUtils;
import com.igrow.mall.service.common.intf.PaymentLogService;

/**
 * @ClassName PaymentLogServiceImpl
 * @Description TODO【支付日志实现类】
 * @Author Brights
 * @Date 2013-11-24 下午2:51:02
 */
@Service("paymentLogServiceImpl")
public class PaymentLogServiceImpl implements PaymentLogService{
	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	@Resource(name = "setting")
	private Setting setting;

	@Override
	public void paymentLogProcess(PaymentOrg paymentOrg,
			HttpServletRequest request, Map<String, String> params,String sn) {
		if(setting.isPaymentLogStatus()){ //是否开启日志，开启
			paymentLogProcessTask(paymentOrg,request,params,sn);
		}
	}
	
	/**
	* @Title paymentLogProcessTask
	* @Description TODO【日志输出异步处理任务】
	* @param dirName
	* @param fileName
	* @param message 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void paymentLogProcessTask(final PaymentOrg paymentOrg,final HttpServletRequest request,final Map<String, String> params,final String sn) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					String fileName = setting.getPaymentLogFilename();
					String message = "";
					if(paymentOrg == PaymentOrg.ALIPAY){
						fileName = paymentOrg.getCode();
						message = AlipayAppNotify.getLogResultTxt(params,request,sn);
					}else if(paymentOrg == PaymentOrg.WXPAY ){
						fileName = paymentOrg.getCode();
						message = WXUtil.getLogResultTxt(params,request,sn);
					}else if(paymentOrg ==PaymentOrg.BILLPAY){
						fileName = paymentOrg.getCode();
						//message = RequestParamsUtil.getLogResultTxt(params, request, sn);
					}
					LogUtils logUtils = new LogUtils(setting.getPaymentLogUrl(),fileName,false);
					logUtils.processLog(message);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title productPaymentLogProcess
	* @Description 
	* @param request
	* @param paymentOrg
	* @param orderSn
	* @param totalFee
	* @param tradeStatus
	* @param tradeNo
	* @param logMsg
	* @see com.igrow.mall.service.common.intf.PaymentLogService#productPaymentLogProcess(javax.servlet.http.HttpServletRequest, com.igrow.mall.common.enums.PaymentOrg, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	*/ 
	@Override
	public void productPaymentLogProcess(HttpServletRequest request,
			PaymentOrg paymentOrg, String orderSn, String totalFee,
			String tradeStatus, String tradeNo, String logMsg,int code) {
		if(setting.isPaymentLogStatus()){ //是否开启日志，开启
			productPaymentLogProcessTask( request,paymentOrg, orderSn, totalFee,tradeStatus, tradeNo, logMsg,code);
		}
	}
	
	public void productPaymentLogProcessTask(final HttpServletRequest request,
			final PaymentOrg paymentOrg,final String orderSn,final String totalFee,
			final String tradeStatus, final String tradeNo, final String logMsg,final int code) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					String fileName = setting.getPaymentLogFilename();
					String message = "logMsg";
					 if(paymentOrg ==PaymentOrg.BILLPAY){
						fileName = paymentOrg.getCode();
						if(code == 0){
							fileName = fileName + "_success";
						}else if(code == 1){
							fileName = fileName + "_erro";
						}
						try {
							//message = RequestParamsUtil.getLogResultTxt(request,orderSn, totalFee, tradeStatus,tradeNo,logMsg,code);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					LogUtils logUtils = new LogUtils(setting.getPaymentLogUrl(),fileName,false);
					logUtils.processLog(message);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
