/**
* @FileName PaymentNotifyUrlUtils.java
* @Package com.igrow.mall.common.payment.core
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-27 下午9:39:01
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.core;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.bean.common.Setting;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.Device;
import com.igrow.mall.common.enums.PaymentProduct;
import com.igrow.mall.common.payment.tenpay.util.WXUtil;
import com.igrow.mall.common.util.SpringUtil;

/**
 * @ClassName PaymentNotifyUrlUtils
 * @Description TODO【支付通知URL】
 * @Author Brights
 * @Date 2013-11-27 下午9:39:01
 */
public class PaymentNotifyUrlUtils {
	
	private static Setting setting;
	
	static{
		setting = (Setting) SpringUtil.getBean("setting");
	}
	
	/**
	* @Title getPaymentNotifyUrl
	* @Description TODO【生成htm后缀的回调地址】
	* @param device
	* @param paymentInfo
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	/*public static String notifyUrlHtmSuffix(int device,HotelPaymentInfo paymentInfo,String wap){
		StringBuffer notifyUrlsb = new StringBuffer();
		notifyUrlsb.append(setting.getSystemMallUrl());
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		if(StringUtils.isNotBlank(wap) && wap.equals("wap")){ //请求工具
			notifyUrlsb.append("wap");	
		}else{ //不是手机网页端请求
			if(Device.valueOf(device) != null){
				notifyUrlsb.append(Device.valueOf(device).getCode());
			}else{
				notifyUrlsb.append("app");
			}
		}
		notifyUrlsb.append(SystemConstants.UNDER_LINE_DELIMITER);
		if(paymentInfo.getPaymentProduct() != null){
			notifyUrlsb.append(paymentInfo.getPaymentProduct().getPaymentOrg().getCode());
		}else{
			notifyUrlsb.append("alipay");
		}
		notifyUrlsb.append(SystemConstants.UNDER_LINE_DELIMITER);
		notifyUrlsb.append(SystemConstants.PAY_NOTIFY_HTM);
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		notifyUrlsb.append(paymentInfo.getHotelPaymentSn() );
		notifyUrlsb.append(SystemConstants.PAYMENT_NOTIFY_SUFFIX);
		System.out.println(notifyUrlsb.toString());
		return notifyUrlsb.toString();
	}*/
	
	
	/**
	* @Title notifyUrlHtmSuffix
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param device
	* @param paymentProduct
	* @param wap
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String notifyUrlHtmSuffix(int device,PaymentProduct paymentProduct,String wap){
		StringBuffer notifyUrlsb = new StringBuffer();
		notifyUrlsb.append(setting.getSystemMallUrl());
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		if(StringUtils.isNotBlank(wap) && wap.equals("wap")){ //请求工具
			notifyUrlsb.append("wap");	
		}else{ //不是手机网页端请求
			if(Device.valueOf(device) != null){
				notifyUrlsb.append(Device.valueOf(device).getCode());
			}else{
				notifyUrlsb.append("app");
			}
		}
		notifyUrlsb.append(SystemConstants.UNDER_LINE_DELIMITER);
		if(paymentProduct != null){
			notifyUrlsb.append(paymentProduct.getPaymentOrg().getCode());
		}else{
			notifyUrlsb.append("alipay");
		}
		notifyUrlsb.append(SystemConstants.UNDER_LINE_DELIMITER);
		notifyUrlsb.append(SystemConstants.PAY_NOTIFY_HTM);
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		notifyUrlsb.append(WXUtil.buildPaySn() );
		notifyUrlsb.append(SystemConstants.PAYMENT_NOTIFY_SUFFIX);
		System.out.println(notifyUrlsb.toString());
		return notifyUrlsb.toString();
	}
	
	
	/**
	* @Title getPaymentNotifyUrl
	* @Description TODO【生成Ac后缀的回调地址】
	* @param device
	* @param paymentInfo
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	/*public static String notifyUrlAcSuffix(int device,HotelPaymentInfo paymentInfo,String wap){
		StringBuffer notifyUrlsb = new StringBuffer();
		notifyUrlsb.append(setting.getSystemMallUrl());
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		notifyUrlsb.append(SystemConstants.PAYMENT_NOTIFY_AC);
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		if(StringUtils.isNotBlank(wap) && wap.equals("wap")){ //请求工具
			notifyUrlsb.append("wap");	
		}else{ //不是手机网页端请求
			if(Device.valueOf(device) != null){
				notifyUrlsb.append(Device.valueOf(device).getCode());
			}else{
				notifyUrlsb.append("app");
			}
		}
		notifyUrlsb.append(SystemConstants.SLASH_DELIMITER);
		if(paymentInfo.getPaymentProduct() != null){
			notifyUrlsb.append(paymentInfo.getPaymentProduct().getPaymentOrg().getCode());
		}else{
			notifyUrlsb.append("alipay");
		}
		notifyUrlsb.append(SystemConstants.UNDER_LINE_DELIMITER);
		notifyUrlsb.append(paymentInfo.getHotelPaymentSn() );
		notifyUrlsb.append(SystemConstants.INTF_ACTION_SUFFIX);
		System.out.println(notifyUrlsb.toString());
		return notifyUrlsb.toString();
	}*/

}
