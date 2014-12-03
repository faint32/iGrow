/**
* @FileName MemberController.java
* @Package com.igrow.mall.web.controller.server
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午6:05:06
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
 * @ClassName MemberController
 * @Description TODO【会员Controller】
 * @Author Brights
 * @Date 2013-10-18 下午6:05:06
 */
@Controller
@RequestMapping(SystemConstants.INTF_SERVICE_MAPPING_URL)
@Scope("prototype")
public class MemberController extends BaseController {
	
	/**
	* @Title login
	* @Description TODO【登录】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("login")
	public void login(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.LOGIN.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title logout
	* @Description TODO【注销】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,ModelMap modelMap) {
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.LOGOUT.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title register
	* @Description TODO【注册】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("register")
	public void register(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.REGISTER.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title getsVcode
	* @Description TODO【获取验证码】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/  
	@RequestMapping("vcode")
	public void getsVcode(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.VCODE.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title editAccount
	* @Description TODO【修改账户】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("edituser")
	public void editAccount(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.EDITUSER.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title addFeedback
	* @Description TODO【意见反馈】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("feedback")
	public void addFeedback(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.FEEDBACK.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title getmembersn
	* @Description TODO【获取用户编号】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("getmembersn")
	public void getMemberSn(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.GETMEMBERSN.getImpl());
		dataHandler.process(request,modelMap);
	}
	
	/**
	* @Title getmemberwin
	* @Description TODO【获取用户是否中奖以及抽奖次数】
	* @param request
	* @param modelMap 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@RequestMapping("getmemberwin")
	public void getMemberWin(HttpServletRequest request,ModelMap modelMap){
		IntfsDataHandle dataHandler = (IntfsDataHandle) SpringUtil.getBean(Intfs.GETMEMBERWIN.getImpl());
		dataHandler.process(request,modelMap);
	}
}
