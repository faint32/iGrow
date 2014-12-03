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
 * @ClassName ScansController
 * @Description TODO【扫描控制器】
 * @Author Brights
 * @Date 2013-10-25 下午4:42:26
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class ScansController extends BaseController {
	
	/**
	* @Title addScanned
	* @Description TODO【添加扫描记录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("scanned")
	public void addScans(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.SCANNED.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findScansList
	* @Description TODO【扫描记录列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("scanlist")
	public void findScansList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.SCANLIST.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title addScanned
	* @Description TODO【删除扫描记录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("delscan")
	public void deleteScans(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.DELSCAN.getImpl());
		dataHandler.process(request,modelMap);
	}


}
