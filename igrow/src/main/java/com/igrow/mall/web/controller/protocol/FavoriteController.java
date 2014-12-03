/**
* @FileName FavoriteController.java
* @Package com.igrow.mall.web.controller.protocol
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 下午4:52:38
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
 * @ClassName FavoriteController
 * @Description TODO【收藏控制器】
 * @Author Brights
 * @Date 2013-10-25 下午4:52:38
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class FavoriteController extends BaseController {
	
	/**
	* @Title addFavorites
	* @Description TODO【添加收藏记录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("addcollection")
	public void addFavorites(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ADDCOLLECTION.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findScansList
	* @Description TODO【收藏记录列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("collectionlist")
	public void findFavoritesList(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.COLLECTIONLIST.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title deleteFavorites
	* @Description TODO【删除收藏记录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("delcollection")
	public void deleteFavorites(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.DELCOLLECTION.getImpl());
		dataHandler.process(request,modelMap);
	}

}
