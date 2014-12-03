/**
* @FileName EvaluateController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 下午5:08:00
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
 * @ClassName EvaluateController
 * @Description TODO【评价控制器】
 * @Author Brights
 * @Date 2013-10-25 下午5:08:00
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class EvaluateController extends BaseController {
	
	/**
	* @Title evaluateOrder
	* @Description TODO【评价订单】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("evaluate")
	public void evaluateOrder(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.EVALUATE.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findEvaluateOrderList
	* @Description TODO【获取评价订单列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("getevaluate")
	public void findEvaluateOrderList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.GETEVALUATE.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findProductEvaluateList
	* @Description TODO【获取货物商品评价列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("evaluatelist")
	public void findProductEvaluateList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.EVALUATELIST.getImpl());
		dataHandler.process(request,modelMap);
	}

}
