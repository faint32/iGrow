/**
* @FileName welcomeAction.java
* @Package com.igrow.mall.web.action.admin
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-20 下午4:04:50
* @Version V1.0.1
*/
package com.igrow.mall.web.action.admin;


import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;

import com.igrow.mall.bean.common.AdminLoginUser;
import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.bean.entity.RoleInfo;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.RoleGroup;
import com.igrow.mall.common.enums.SystemEnums.OperateStatus;
import com.igrow.mall.common.util.CaptchaUtil;
import com.igrow.mall.common.util.IpUtils;
import com.igrow.mall.service.admin.intf.AdminUserService;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName WelcomeAction
 * @Description TODO【欢迎主界面】
 * @Author Brights
 * @Date 2013-10-20 下午4:04:50
 */
@Namespace("/admin/welcome")
@Results({
	@Result(name="redirect_index", type="redirect", location="index.do"),
	@Result(name = "redirect", location = "${redirectUrl}", type = "redirect")
})
public class WelcomeAction extends BaseAction {
	private static final long serialVersionUID = -7970182576005566850L;
	private String userName;//用户名
	private String password;//密码
	
	@Resource(name = "adminUserServiceImpl")
	private AdminUserService adminUserService;
	
	/**
	* @Title index
	* @Description TODO【登录页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(INDEX)
	public String index(){
		if(getLoginUser() != null){
			//if(StringUtils.isBlank(redirectUrl)){
			redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			//}
			return REDIRECT;
		}
		return INDEX;
	}
	
	/**
	* @Title main
	* @Description TODO【登陆成功后主页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("main")
	public String main(){
		if(getLoginUser() != null){
			//if(StringUtils.isBlank(redirectUrl)){
				//redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			//}
			redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			return REDIRECT;
		}
		return "redirect_index";
	}
	
	/**
	* @Title login
	* @Description TODO【登录】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LOGIN)
	public String login(){
		if(StringUtils.isBlank(userName)){
			return ajax(OperateStatus.ERROR,"用户名为空!",0);
		}
		if(StringUtils.isBlank(password)){
			return ajax(OperateStatus.ERROR,"密码为空!",0);
		}
		Integer scount = (Integer) getSession("fcount");
		if(scount != null && scount >= 3){
			if (!CaptchaUtil.validateCaptchaByRequest(getRequest())) {
				return ajax(OperateStatus.ERROR,"验证码错误!",scount);
			}
		}
		AdminUserInfo loginUser = adminUserService.findByUserName(userName);
		if(loginUser == null){
			return ajax(OperateStatus.ERROR,"管理员用户不存在!",0);
		}
		// 解除会员账户锁定
		if(loginUser.getIsAccountLocked() == Bool.TRUE) {
			if (SystemConstants.IS_LOGIN_FAILURE_LOCK) {
				int loginFailureLockTime = SystemConstants.LOGIN_FAILURE_LOCK_TIME;
				if (loginFailureLockTime > 0) {
					Date lockedDate = loginUser.getLockedDate();
					Date unlockDate = DateUtils.addMinutes(lockedDate,
							loginFailureLockTime);
					if (new Date().after(unlockDate)) {
						loginUser.setLoginFailureCount(0);
						loginUser.setIsAccountLocked(Bool.FALSE);
						loginUser.setLockedDate(null);
						adminUserService.update(loginUser);
					}
				}
			} else {
				loginUser.setLoginFailureCount(0);
				loginUser.setIsAccountLocked(Bool.FALSE);
				loginUser.setLockedDate(null);
				adminUserService.update(loginUser);
			}
		}
		if(loginUser.getIsAccountEnabled() == Bool.FALSE){
			return ajax(OperateStatus.ERROR,"管理员用户被禁用，无法登陆!",0);
		}
		
		if(loginUser.getIsAccountLocked() == Bool.TRUE){
			return ajax(OperateStatus.ERROR,"管理员用户被锁定，无法登陆!",0);
		}
		if(!adminUserService.verifyAdminUser(userName, password)){
			if (SystemConstants.IS_LOGIN_FAILURE_LOCK) {
				int loginFailureLockCount = SystemConstants.LOGIN_FAILURE_LOCK_COUNT;
				System.out.println("loginFailureLockCount="+loginFailureLockCount);
				int loginFailureCount = loginUser.getLoginFailureCount() + 1;
				System.out.println("loginFailureCount="+loginFailureCount);
				if (loginFailureCount >= loginFailureLockCount) {
					loginUser.setIsAccountLocked(Bool.TRUE);
					loginUser.setLockedDate(new Date());
				}
				loginUser.setLoginFailureCount(loginFailureCount);
				adminUserService.update(loginUser);
				setSession("fcount",loginFailureCount);
				if (SystemConstants.IS_LOGIN_FAILURE_LOCK && loginFailureLockCount - loginFailureCount <= 3) {
					return ajax(OperateStatus.ERROR,"若连续" + loginFailureLockCount + "次密码输入错误,您的管理员账户将被锁定!",loginFailureCount);
				} else {
					return ajax(OperateStatus.ERROR,"您的密码错误!",loginFailureCount);
				}
			} else {
				return ajax(OperateStatus.ERROR,"您的密码错误!",0);
			}
		}
		loginUser.setLastLoginIp(IpUtils.getIpAddr(getRequest()));
		loginUser.setLastLoginDate(new Date());
		loginUser.setLoginFailureCount(0);
		adminUserService.update(loginUser);
		setSession("fcount",0);
		// 防止Session Fixation攻击
	/*	HttpSession httpSession = getRequest().getSession();
		Enumeration enumeration = httpSession.getAttributeNames();
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			sessionMap.put(key, httpSession.getAttribute(key));
		}
		httpSession.invalidate();
		httpSession = getRequest().getSession(true);
		if(sessionMap.keySet().size() > 0){
			for (String key : sessionMap.keySet()) {
				Object value = sessionMap.get(key);
				httpSession.setAttribute(key, value);
			}
		}*/
		// 写入会员登录Session
		//httpSession.setAttribute(AdminUserInfo.ADMINUSER_USERSN_SESSION, loginUser);
		AdminLoginUser adminLoginUser = new AdminLoginUser(loginUser);
		/*if(adminLoginUser.getHotelId() != 0){
			HotelInfo hotel = hotelService.find(adminLoginUser.getHotelId()+"");
			if(hotel != null){
				adminLoginUser.setHotel(hotel);
			}
		}*/
		super.setLoginUser(adminLoginUser);
		return ajax(OperateStatus.SUCCESS,"登录成功!");
	}
	
	/**
	* @Title logout
	* @Description TODO【注销】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("logout")
	public String logout(){
		removeSession(LOGIN_ADMIN_USER);
		/*HttpSession session = ServletActionContext.getRequest().getSession();
		if (session != null) {
			session.invalidate();
		}*/
		return "redirect_index";
	}
	
	/**
	* @Title toggle
	* @Description TODO【用户切换】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("toggle")
	public String toggle(){
		if(getLoginUser() != null){
			redirectUrl = SystemConstants.DEFAULT_REDIRECT_URL;
			//获取登录用户信息
			AdminLoginUser oldLoginInfo = this.getAdmin();
			System.out.println("name:"+oldLoginInfo.getName());
			System.out.println("username:"+oldLoginInfo.getUserName());
			System.out.println("RoleGroupId:"+oldLoginInfo.getRoleGroupId());
			System.out.println("HotelId:"+oldLoginInfo.getHotelId());
			System.out.println("SupplierId:"+oldLoginInfo.getSupplierId());
			if(oldLoginInfo != null && oldLoginInfo.getRoleGroupId() == RoleGroup.ADMIN_USER.getIdx()){
				if(type.equals("1")){ //酒店
					AdminUserInfo loginUser = adminUserService.findByRole(id,"hotel_id");
					System.out.println(loginUser.getName());
					if(loginUser != null){
						AdminLoginUser newLoginInfo = new AdminLoginUser();
						String[] ignorePropertie = {"authCodes","userPurviews","hotelId","supplierId"};
						BeanUtils.copyProperties(oldLoginInfo, newLoginInfo, ignorePropertie);
						newLoginInfo.setHotelId(Integer.parseInt(id));
						newLoginInfo.setSupplierId(0);
						if(loginUser.getRoleInfos() != null && loginUser.getRoleInfos().size() > 0){
							HashSet<String> aCodes = new HashSet<String>();
							HashSet<PurviewInfo> uPurviews = new HashSet<PurviewInfo>();
							for(RoleInfo role : loginUser.getRoleInfos()){
								if(role.getPurviewInfos() != null && role.getPurviewInfos().size() > 0){
									for(PurviewInfo entity : role.getPurviewInfos()){
										uPurviews.add(entity);
										aCodes.add(entity.getCode());
									}
								}
							}
							newLoginInfo.setUserPurviews(uPurviews);
							newLoginInfo.setAuthCodes(aCodes);
						}
						super.setLoginUser(newLoginInfo); //重新设置Session
						AdminLoginUser nLoginInfo = this.getAdmin();
						System.out.println("name_1:"+nLoginInfo.getName());
						System.out.println("username_1:"+nLoginInfo.getUserName());
						System.out.println("RoleGroupId_1:"+nLoginInfo.getRoleGroupId());
						System.out.println("HotelId_1:"+nLoginInfo.getHotelId());
						System.out.println("SupplierId_1:"+nLoginInfo.getSupplierId());
					}
				}else if(type.equals("2")){//供应商
					AdminUserInfo loginUser = adminUserService.findByRole(id,"supplier_id");
					System.out.println(loginUser.getName());
					if(loginUser != null){
						AdminLoginUser newLoginInfo = new AdminLoginUser();
						String[] ignorePropertie = {"authCodes","userPurviews","hotelId","supplierId"};
						BeanUtils.copyProperties(oldLoginInfo, newLoginInfo, ignorePropertie);
						newLoginInfo.setHotelId(0);
						newLoginInfo.setSupplierId(Integer.parseInt(id));
						if(loginUser.getRoleInfos() != null && loginUser.getRoleInfos().size() > 0){
							HashSet<String> aCodes = new HashSet<String>();
							HashSet<PurviewInfo> uPurviews = new HashSet<PurviewInfo>();
							for(RoleInfo role : loginUser.getRoleInfos()){
								if(role.getPurviewInfos() != null && role.getPurviewInfos().size() > 0){
									for(PurviewInfo entity : role.getPurviewInfos()){
										uPurviews.add(entity);
										aCodes.add(entity.getCode());
									}
								}
							}
							newLoginInfo.setUserPurviews(uPurviews);
							newLoginInfo.setAuthCodes(aCodes);
						}
						super.setLoginUser(newLoginInfo); //重新设置Session
						AdminLoginUser nLoginInfo = this.getAdmin();
						System.out.println("name_1:"+nLoginInfo.getName());
						System.out.println("username_1:"+nLoginInfo.getUserName());
						System.out.println("RoleGroupId_1:"+nLoginInfo.getRoleGroupId());
						System.out.println("HotelId_1:"+nLoginInfo.getHotelId());
						System.out.println("SupplierId_1:"+nLoginInfo.getSupplierId());
					}
					
				}else{ //系统管理员
					AdminUserInfo loginUser = adminUserService.find(oldLoginInfo.getId());
					if(loginUser != null){
						AdminLoginUser newLoginInfo = new AdminLoginUser(loginUser);
						newLoginInfo.setSupplierId(0);
						newLoginInfo.setHotelId(0);
						super.setLoginUser(newLoginInfo); //重新设置Session
						//AdminLoginUser nLoginInfo = this.getAdmin();
					}
				}
			}
			
			return REDIRECT;
		}
		return "redirect_index";
	}
	/**
	* @Title header
	* @Description TODO【头部页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("header")
	public String header(){
		return SUCCESS;
	}
	
	/**
	* @Title left
	* @Description TODO【左侧页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action("left")
	public String left(){
		return SUCCESS;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
