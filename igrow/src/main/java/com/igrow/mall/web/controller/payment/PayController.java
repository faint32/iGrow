/**
* @FileName AlipayController.java
* @Package com.igrow.mall.web.controller.payment
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-14 下午3:44:48
* @Version V1.0.1
*/
package com.igrow.mall.web.controller.payment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.PaymentIntfs;
import com.igrow.mall.common.util.SpringUtil;
import com.igrow.mall.service.protocol.intf.IntfsDataHandle;
import com.igrow.mall.web.controller.core.BaseController;

/**
 * @ClassName AlipayController
 * @Description TODO【支付宝支付处理控制器】
 * @Author Brights
 * @Date 2013-11-14 下午3:44:48
 */
@Controller
@RequestMapping("/payment/notify/")
@Scope("prototype")
public class PayController extends BaseController {
	
	/**
	* @Title alipayApp
	* @Description TODO【app支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("alipay/app_{sn}")
	public void alipayApp(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.ALIPAY_APP_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.ALIPAY_APP_NOTIFY.getImpl());
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title alipayApk
	* @Description TODO【apk支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("alipay/apk_{sn}")
	public void alipayApk(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.ALIPAY_APK_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.ALIPAY_APK_NOTIFY.getImpl());
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title alipayWap
	* @Description TODO【wap支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("alipay/wap_{sn}")
	public void alipayWap(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.ALIPAY_WAP_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.ALIPAY_WAP_NOTIFY.getImpl());
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title alipayWap
	* @Description TODO【wap支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("common/{sn}")
	public void common(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.COMMON_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.COMMON_NOTIFY.getImpl());
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 
	
	
	/**
	* @Title alipaySettle
	* @Description TODO【结算异步通知出来】
	* @param sn 
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("alipay/settle_{sn}")
	public void alipayApp(HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.ALIPAY_SETTLE_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.ALIPAY_SETTLE_NOTIFY.getImpl());
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title wxpay
	* @Description TODO【app支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("wxpay/app_{sn}")
	public void wxpayApp(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.WXPAY_APP_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.WXPAY_APP_NOTIFY.getImpl());	
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 

	/**
	* @Title wxpay
	* @Description TODO【wap支付异步通知出来】
	* @param sn
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("wxpay/wap_{sn}")
	public void wxpayWap(@PathVariable("sn") String sn,HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.WXPAY_WAP_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.WXPAY_WAP_NOTIFY.getImpl());	
		request.setAttribute(SystemConstants.SN_FIELD, sn);
		dataHandler.process(request,modelMap);
	} 
	
}
