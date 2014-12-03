/**
* @FileName WechatController.java
* @Package com.igrow.mall.web.controller.payment
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月14日 上午10:01:08
* @Version V1.0.1
*/
package com.igrow.mall.web.controller.payment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igrow.mall.common.enums.PaymentIntfs;
import com.igrow.mall.common.util.SpringUtil;
import com.igrow.mall.service.protocol.intf.IntfsDataHandle;
import com.igrow.mall.web.controller.core.BaseController;

/**
 * @ClassName WechatController
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年8月14日 上午10:01:08
 */
@Controller
@RequestMapping("/payment/notify/")
@Scope("prototype")
public class WechatController extends BaseController {
	
	/**
	* @Title rights
	* @Description TODO【维权】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("wechat/rights")
	public void rights(HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.WXPAY_RIGHTS_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.WXPAY_RIGHTS_NOTIFY.getImpl());
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title notice
	* @Description TODO【告警】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("wechat/notice")
	public void notice(HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.WXPAY_NOTICE_NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.WXPAY_NOTICE_NOTIFY.getImpl());
		dataHandler.process(request,modelMap);
	} 

}
