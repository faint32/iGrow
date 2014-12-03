/**
* @FileName SystemRepairServiceImpl.java
* @Package com.igrow.mall.service.common.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-13 下午1:04:48
* @Version V1.0.1
*/
package com.igrow.mall.service.common.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.bean.entity.RoleInfo;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.service.common.intf.SystemRepairService;
import com.igrow.mall.ws.intf.AdminUserWs;
import com.igrow.mall.ws.intf.PurviewWs;
import com.igrow.mall.ws.intf.RoleWs;

/**
 * @ClassName SystemRepairServiceImpl
 * @Description TODO【系统修复接口实现】
 * @Author Brights
 * @Date 2013-11-13 下午1:04:48
 */
@Service("systemRepairServiceImpl")
public class SystemRepairServiceImpl implements SystemRepairService {
	
	@Resource(name = "adminUserWsImpl")
	private AdminUserWs adminUserWs;
	@Resource(name = "roleWsImpl")
	private RoleWs roleWs;
	@Resource(name = "purviewWsImpl")
	private PurviewWs purviewWs;

	@Override
	synchronized public void repair() {
		repairAdminUser();
		repairRole();
	}

	@Override
	synchronized public void deleteAndRepair() {
		deleteAndRepairAdminRoleRef();
		deleteAndRepairRolePurviewRef();
	}
	
	/**
	* @Title repairAdminUser
	* @Description TODO【修复管理员】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	private void repairAdminUser(){
		//管理员内置用户
		AdminUserInfo adminUser = adminUserWs.find("1");
		if(adminUser != null){
			adminUser.setEmail("brights@atbora.com");
			adminUser.setIsAccountEnabled(Bool.TRUE);
			adminUser.setIsAccountLocked(Bool.FALSE);
			adminUser.setIsOnline(Bool.FALSE);
			adminUser.setLoginFailureCount(0);
			adminUser.setMobile("15382397262");
			adminUser.setName("系统管理员");
			adminUser.setUserName("admin");
			adminUser.setUserSn("admin");
			//adminUser.setPassword(DigestUtils.md5Hex("123456"));
			adminUserWs.update(adminUser);
		}else{
			adminUser  = new AdminUserInfo();
			adminUser.setEmail("brights@atbora.com");
			adminUser.setIsAccountEnabled(Bool.TRUE);
			adminUser.setIsAccountLocked(Bool.FALSE);
			adminUser.setIsOnline(Bool.FALSE);
			adminUser.setLoginFailureCount(0);
			adminUser.setMobile("15382397262");
			adminUser.setName("系统管理员");
			adminUser.setUserName("admin");
			adminUser.setUserSn("admin");
			adminUser.setPassword(DigestUtils.md5Hex("123456"));
			adminUserWs.insert(adminUser);
		}
		//修复
		adminUserWs.repair();
	}
	
	private void repairRole(){
		RoleInfo role = roleWs.find("1");
		if(role != null){
			role.setCode("99");
			role.setDescription("系统管理员");
			role.setName("系统管理员");
			role.setIsDelete(Bool.FALSE);
			role.setIsSystem(Bool.TRUE);
			roleWs.update(role);
		}else{
			role = new RoleInfo();
			role.setCode("99");
			role.setDescription("系统管理员");
			role.setName("系统管理员");
			role.setIsDelete(Bool.FALSE);
			role.setIsSystem(Bool.TRUE);
			role.setCreateOperator(SystemConstants.AUTO_OPERATOR);
			role.setModifyOperator(SystemConstants.AUTO_OPERATOR);
			roleWs.update(role);
		}
	}
	
	/**
	* @Title deleteAndRepairRolePurviewRef
	* @Description TODO【修复内置角色关系】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void deleteAndRepairRolePurviewRef(){
		//删除
		List<RoleInfo> roleInfos = roleWs.findSystemList();
		if(roleInfos != null && roleInfos.size() > 0){
			for(RoleInfo role : roleInfos){
				if(role != null){
					//删除角色权限配置
					roleWs.deleteRolePurviewRefByRole(role);
					//获取权限
					List<PurviewInfo> purviews = purviewWs.findAllList();
					if(purviews != null && purviews.size() > 0){
						for(PurviewInfo pur:purviews){
							if(pur != null){
								HashMap values = new HashMap();
								values.put("role", role);
								values.put("purview", pur);
								purviewWs.savePurviewRoleRef(values);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	* @Title deleteAndRepairAdminRoleRef
	* @Description TODO【】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void deleteAndRepairAdminRoleRef(){
		//管理员内置用户
		AdminUserInfo adminUser = adminUserWs.find("1");
		if(adminUser != null){
			adminUserWs.deleteAdminUserRoleRef(adminUser);
			List<RoleInfo> roleInfos = roleWs.findSystemList();
			if(roleInfos != null && roleInfos.size() > 0){
				for(RoleInfo role : roleInfos){
					if(role != null){
						HashMap values = new HashMap();
						values.put("role", role);
						values.put("user", adminUser);
						roleWs.saveRoleAdminUserRef(values);
					}
				}
			}
		}
	}
	
	
	
}
