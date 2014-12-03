/**
* @FileName AlipayDirect.java
* @Package com.igrow.mall.common.payment.alipay
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-26 上午11:44:55
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.alipay;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.common.enums.PaymentNotifyEnums;
import com.igrow.mall.common.payment.core.BasePayment;

/**
 * @ClassName AlipayDirect
 * @Description TODO【支付宝及时到账支付】
 * @Author Brights
 * @Date 2013-11-26 上午11:44:55
 */
public class AlipayDirect extends BasePayment {
	
	@Override
	public String getOrderSn(HttpServletRequest httpServletRequest) {
		if (httpServletRequest == null) {
			return null;
		}
		String outTradeNo = httpServletRequest.getParameter("out_trade_no");
		if (StringUtils.isEmpty(outTradeNo)) {
			return null;
		}
		return outTradeNo;
	}


	@Override
	public String getPaymentSn(HttpServletRequest httpServletRequest) {
		return null;
	}

	@Override
	public BigDecimal getPaymentAmount(HttpServletRequest httpServletRequest) {
		if (httpServletRequest == null) {
			return null;
		}
		String totalFee = httpServletRequest.getParameter("total_fee");
		if (StringUtils.isEmpty(totalFee)) {
			return null;
		}
		return new BigDecimal(totalFee);
	}

	@Override
	public boolean isPaySuccess(HttpServletRequest httpServletRequest) {
		if (httpServletRequest == null) {
			return false;
		}
		String tradeStatus = httpServletRequest.getParameter("trade_status");
		if (StringUtils.equals(tradeStatus, PaymentNotifyEnums.AlipayTradeStatus.FINISHED.getDesc()) || StringUtils.equals(tradeStatus, PaymentNotifyEnums.AlipayTradeStatus.SUCCESS.getDesc())) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean verifySign(HttpServletRequest httpServletRequest) {
		return false;
	}	


}
