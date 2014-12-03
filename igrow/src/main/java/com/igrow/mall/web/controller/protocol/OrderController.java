/**
* @FileName OrderController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-24 下午1:56:26
* @Version V1.0.1
*/
package com.igrow.mall.web.controller.protocol;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.Intfs;
import com.igrow.mall.common.util.SpringUtil;
import com.igrow.mall.service.protocol.intf.IntfsDataHandle;
import com.igrow.mall.web.controller.core.BaseController;

/**
 * @ClassName OrderController
 * @Description TODO【订单控制器】
 * @Author Brights
 * @Date 2013-10-24 下午1:56:26
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class OrderController extends BaseController{
	
	/**
	* @Title findOrderList
	* @Description TODO【获取订单列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("orderlist")
	public void findOrderList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ORDERLIST.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title referOrder
	* @Description TODO【提交订单】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("submitorders")
	public void referOrder(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.SUBMITORDERS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title getOrderDetail
	* @Description TODO【获取订单详情】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("order")
	public void getsOrderDetail(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ORDER.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title receiptOrder
	* @Description TODO【订单收货】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("receipt")
	public void receiptOrder(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.RECEIPT.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findLogistics
	* @Description TODO【查看订单物流】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("logistics")
	public void findOrderLogisticList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.LOGISTICS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findSellerInfo
	* @Description TODO【查询商户】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("sellerinfo")
	public void findSellerInfo(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.SELLERINFO.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title applyOrderAfftermarket
	* @Description TODO【申请售后】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("afftermarket")
	public void applyOrderAfftermarket(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.AFFTERMARKET.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title directReferOrder
	* @Description TODO【未登录直接下单】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("directorders")
	public void directReferOrder(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.DIRECTORDERS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title selfReferOrder
	* @Description TODO【自助售卖提交订单】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("selfreferorders")
	public void selfReferOrder(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.SELFREFERORDERS.getImpl());
		dataHandler.process(request, modelMap);
	}


}
