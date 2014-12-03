/**
* @FileName RoleWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 下午4:56:53
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import java.util.HashMap;
import java.util.List;

import com.igrow.mall.bean.entity.RoleInfo;

/**
 * @ClassName RoleWs
 * @Description TODO【角色】
 * @Author Brights
 * @Date 2013-11-11 下午4:56:53
 */
public interface RoleWs extends BaseWs<RoleInfo, String> {
	/**
	* @Title findSystemList
	* @Description TODO【查询系统内置角色列表】
	* @return 
	* @Return List<RoleInfo> 返回类型
	* @Throws 
	*/ 
	public List<RoleInfo> findSystemList();
	
	/**
	* @Title deleteRolePurviewRefByRole
	* @Description TODO【删除角色权限关系】
	* @param role 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void deleteRolePurviewRefByRole(RoleInfo role);
	
	/**
	* @Title saveRoleAdminUserRef
	* @Description TODO【保存角色管理员关系】
	* @param values 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public void saveRoleAdminUserRef(HashMap values);
	

}
