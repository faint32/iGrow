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
* @ClassName AddressController
* @Description TODO【地址相关Controller】
* @Author Brights
* @Date 2013-10-25 下午1:21:41
*/ 
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class AddressController extends BaseController {
	
	/**
	* @Title addAddress
	* @Description TODO【添加收货地址】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("addadds")
	public void addAddress(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ADDADDS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title editAddress
	* @Description TODO【编辑收货地址】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("editadds")
	public void editAddress(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.EDITADDS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title deleteAddress
	* @Description TODO【删除收货地址】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("deladds")
	public void deleteAddress(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.DELADDS.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title findAddressList
	* @Description TODO【收货地址列表】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("addslist")
	public void findAddressList(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.ADDSLIST.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title deFalutAddress
	* @Description TODO【获取默认收货地址】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("lastadds")
	public void defaultAddress(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.LASTADDS.getImpl());
		dataHandler.process(request,modelMap);
	}

}
