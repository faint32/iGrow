/**
* @FileName ActiveController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-30 下午9:17:06
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
 * @ClassName ActiveController
 * @Description TODO【活动控制器】
 * @Author Brights
 * @Date 2013-11-30 下午9:17:06
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class ActiveController extends BaseController {
	
	/**
	* @Title findActiveList
	* @Description TODO【活动列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/
	@RequestMapping("activitylist")
	public void findActiveList(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ACTIVITYLIST.getImpl());
		dataHandler.process(request,modelMap);
	}

	/**
	* @Title addActiveLottery
	* @Description TODO【添加活动抽奖次数】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/
	@RequestMapping("addactivelottery")
	public void addActiveLottery(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ADDACTIVELOTTERY.getImpl());
		dataHandler.process(request,modelMap);
	}
}
