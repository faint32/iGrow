/**
* @FileName AdminUserAction.java
* @Package com.igrow.mall.web.action.admin
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午6:08:37
* @Version V1.0.1
*/
package com.igrow.mall.web.action.admin;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.igrow.mall.bean.dto.AdminUserInfoDto;
import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.common.annotation.OperationAuth;
import com.igrow.mall.common.constant.AuthConstant;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.SystemEnums.OperateStatus;
import com.igrow.mall.service.admin.intf.AdminUserService;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName AdminUserAction
 * @Description TODO【管理员用户Action】
 * @Author Brights
 * @Date 2013-10-18 下午6:08:37
 */
@Namespace("/admin/user")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0505")
})
public class AdminUserAction extends BaseAction {
	private static final long serialVersionUID = -1887714219428189911L;
	@Resource(name = "adminUserServiceImpl")
	private AdminUserService adminUserService;
	
	private AdminUserInfoDto search;
	private AdminUserInfo result;
	private AdminUserInfo form;
	private String password;
	private String newPassword;
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	@OperationAuth(code= AuthConstant.ADMINUSER_LIST_AUTH)
	public String list(){
		if(StringUtils.isBlank(idx))idx = "0505";
		if(search == null) search = new AdminUserInfoDto();
		pager = adminUserService.findPagerBy(search, pager);
		return LIST;
	}
	
	/**
	* @Title add
	* @Description TODO【添加】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(ADD)
	public String add(){
		return INPUT;
	}
	
	/**
	* @Title save
	* @Description TODO【保存】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(SAVE)
	public String save(){
		if(form == null) return ajax(OperateStatus.ERROR,"添加失败!");
		if(StringUtils.isNotBlank(form.getPassword())){
			form.setPassword(DigestUtils.md5Hex(form.getPassword()));
		}else{
			form.setPassword(DigestUtils.md5Hex("123456"));
		}
		adminUserService.insert(form);
		return ajax(OperateStatus.SUCCESS,"添加成功!",form.getId());
	}
	
	/**
	* @Title edit
	* @Description TODO【编辑】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(EDIT)
	public String edit(){
		result = adminUserService.find(id);
		return INPUT;
	}
	
	/**
	* @Title update
	* @Description TODO【修改】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(UPDATE)
	public String update(){
		if(form == null) return ajax(OperateStatus.ERROR,"修改失败!",form.getId());
		AdminUserInfo adminUser = adminUserService.find(form.getId());
		if(adminUser == null)return ajax(OperateStatus.ERROR,"修改失败!",form.getId());
		adminUser.setEmail(form.getEmail());
		adminUser.setUserName(form.getUserName());
		adminUser.setMobile(form.getMobile());
		adminUser.setName(form.getName());
		if(form.getAccountEnabled() != null){
			Bool boolEnabled = Bool.valueOf(Integer.parseInt(form.getAccountEnabled()));
			adminUser.setIsAccountEnabled(boolEnabled);
		}
		adminUserService.update(adminUser);
		return ajax(OperateStatus.SUCCESS,"修改成功!",form.getId());
	}
	
	
	/**
	* @Title findByUserName
	* @Description TODO【查找账号是否存在】
	* @return 
	* @Return String 返回类型 
	* @Throws 
	*/ 
	@Action("findByUn")
	public String findByUserName(){
		AdminUserInfo au = adminUserService.find(id);
		if(au == null){
			AdminUserInfo adminUser = adminUserService.findByUserName(param.trim());
			if(adminUser != null){
				return ajax(OperateStatus.ERROR,"登录账户名已存在!");
			}else{
				return ajax(OperateStatus.SUCCESS,"登录账户名不存在,可以添加!");
			}
		}else{
			if(au.getUserName().trim().equals(param.trim())){
				return ajax(OperateStatus.SUCCESS,"");
			}else{
				AdminUserInfo adminUser = adminUserService.findByUserName(param.trim());
				if(adminUser != null){
					 return ajax(OperateStatus.ERROR,"登录账户已存在!");
				}else{
					return ajax(OperateStatus.SUCCESS,"登录账户名不存在,可以修改!");
				}
			}
		}
	}
	
	/**
	* @Title delete
	* @Description TODO【删除】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DELETE)
	public String delete(){
		return SUCCESS;
	}
	
	/**
	* @Title detail
	* @Description TODO【详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DETAIL)
	public String detail(){
		return SUCCESS;
	}
	

	@Action("password")
	public String password(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajax(OperateStatus.ERROR,"密码修改失败!");
		}
		if(!adminUser.getPassword().equals(DigestUtils.md5Hex(password))){
			return ajax(OperateStatus.ERROR,"当前密码错误!");
		}
		if(StringUtils.isBlank(newPassword)){
			return ajax(OperateStatus.ERROR,"新密码为空!");
		}
		adminUser.setPassword(DigestUtils.md5Hex(newPassword));
		adminUserService.update(adminUser);
		return ajax(OperateStatus.SUCCESS,"密码修改成功!");
	}
	
	@Action("resetpwd")
	public String reSetPassword(){
		AdminUserInfo adminUser = adminUserService.find(id);
		if(adminUser == null){
			return ajax(OperateStatus.ERROR,"账户不存在!");
		}
		adminUser.setPassword(DigestUtils.md5Hex("123456"));
		adminUserService.update(adminUser);
		return ajax(OperateStatus.SUCCESS,"重置密码成功!");
	}

	public AdminUserInfoDto getSearch() {
		return search;
	}

	public void setSearch(AdminUserInfoDto search) {
		this.search = search;
	}

	public AdminUserInfo getResult() {
		return result;
	}

	public void setResult(AdminUserInfo result) {
		this.result = result;
	}

	public AdminUserInfo getForm() {
		return form;
	}

	public void setForm(AdminUserInfo form) {
		this.form = form;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
