/**
* @FileName ScannedController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 下午4:42:26
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
 * @ClassName ShareController
 * @Description TODO【分享控制器】
 * @Author shiyz
 * @Date 2014-04-24 下午16:42:26
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class ShareController extends BaseController {
	
	/**
	* @Title addShare
	* @Description TODO【添加分享记录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("addshare")
	public void addShare(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ADDSHARE.getImpl());
		dataHandler.process(request,modelMap);
	}
	
}
