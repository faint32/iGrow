/**
* @FileName ProductController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-24 下午1:55:12
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
 * @ClassName ProductController
 * @Description TODO【商品控制器】
 * @Author Brights
 * @Date 2013-10-24 下午1:55:12
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class ProductController extends BaseController {
	
	/**
	* @Title getsProductDetail
	* @Description TODO【商品详情】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("productdetails")
	public void getsProductDetail(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.PRODUCTDETAILS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title getsProductDcode
	* @Description TODO【获取商品二维码】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("qrcode")
	public void getsProductDcode(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.QRCODE.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findProductList
	* @Description TODO【商品列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("productlist")
	public void findProductList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.PRODUCTLIST.getImpl());
		dataHandler.process(request,modelMap);
	}

}
