/**
* @FileName BillPayController.java
* @Package com.igrow.mall.web.controller.payment
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年7月24日 下午4:27:26
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
 * @ClassName BillPayController
 * @Description TODO【快钱支付】
 * @Author Shiyz
 * @Date 2014年7月24日 下午4:27:26
 */
@Controller
@RequestMapping("/payment/billpay/")
@Scope("prototype")
public class BillPayController extends BaseController {
	
	/**
	* @Title mnp
	* @Description TODO【快钱支付实时通知】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("notify/mnp")
	public void mnp(HttpServletRequest request,ModelMap modelMap){
		System.out.println(PaymentIntfs.CARD_99BILL_PAY__NOTIFY.getImpl());
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(PaymentIntfs.CARD_99BILL_PAY__NOTIFY.getImpl());
		dataHandler.process(request,modelMap);
	} 
	
	/**
	* @Title mnp
	* @Description TODO【快钱支付订单查询服务】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("query/oqs")
	public void oqs(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean("card99BillPayOrderQueryHandleImpl");
		dataHandler.process(request,modelMap);
	} 

}
