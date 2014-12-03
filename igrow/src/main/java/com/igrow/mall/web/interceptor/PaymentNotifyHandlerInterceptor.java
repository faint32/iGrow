package com.igrow.mall.web.interceptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.PaymentNotifyEnums;
import com.igrow.mall.common.enums.PaymentProduct;
import com.igrow.mall.common.enums.PaymentNotifyEnums.AlipayNotifyResult;
import com.igrow.mall.common.enums.PaymentNotifyEnums.BillPayNotifyResult;
import com.igrow.mall.common.enums.PaymentNotifyEnums.CommonNotifyResult;
import com.igrow.mall.common.enums.PaymentNotifyEnums.WxNotifyResult;
import com.igrow.mall.common.util.OutUtils;

/**
* @ClassName PaymentNotifyHandlerInterceptor
* @Description TODO【支付处理拦截器】
* @Author Brights
* @Date 2013-11-14 下午4:28:54
*/ 
public class PaymentNotifyHandlerInterceptor  extends HandlerInterceptorAdapter{
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY) != null){
			if(modelAndView.getModelMap().get(SystemConstants.PAYMENT_PRODUCT_RESULT__PARAMS_KEY) != null){
				PaymentProduct product = (PaymentProduct) modelAndView.getModelMap().get(SystemConstants.PAYMENT_PRODUCT_RESULT__PARAMS_KEY);
				if(product.getValue() == PaymentProduct.ALIPAY_DIRECT_PAY.getValue()){ //支付宝
					AlipayNotifyResult  result = (AlipayNotifyResult) modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY);
					OutUtils.out(response, result.getDesc());
				}else if(product.getValue() == PaymentProduct.WXPAY_DIRECT_PAY.getValue()){ //微信
					WxNotifyResult  result = (WxNotifyResult) modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY);
					OutUtils.out(response, result.getDesc());
				}else if(product.getValue() == PaymentProduct.BILLPAY_CARD_PAY.getValue()){ //快钱
					BillPayNotifyResult  result = (BillPayNotifyResult) modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY);
					OutUtils.out(response, String.valueOf(result.getValue()));
				}else{
					CommonNotifyResult result = (CommonNotifyResult) modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY);
					OutUtils.out(response, result.getDesc());
				}
			}else{
				CommonNotifyResult result = (CommonNotifyResult) modelAndView.getModelMap().get(SystemConstants.PAY_RESULT_PARAMS_KEY);
				OutUtils.out(response, result.getDesc());
			}
		}else{
			OutUtils.out(response, PaymentNotifyEnums.CommonNotifyResult.FAIL.getDesc());
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取POST过来反馈信息
		System.out.println("=======================1============================");
		String pageEncode=request.getCharacterEncoding();
		String method=request.getMethod();
		System.out.println(pageEncode+"="+pageEncode);
		System.out.println(method+"="+method);
		//InputStream  is = request.getInputStream();
		//String wxMsgXml = IOUtils.toString(is,"utf-8");
		//System.out.println(wxMsgXml+"="+wxMsgXml);
		//request.setCharacterEncoding("GBK");
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			//valueStr = URLDecoder.decode(valueStr,"GBK");
			//System.out.println(name+"="+valueStr);
			params.put(name, valueStr);
		}
		System.out.println("======================2=============================");
		request.setAttribute(SystemConstants.PAY_REQUEST_PARAMS_KEY, params);
		return true;
	}

}
