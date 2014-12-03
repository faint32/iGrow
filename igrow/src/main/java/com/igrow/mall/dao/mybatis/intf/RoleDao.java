/**
* @FileName RoleDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 下午4:27:31
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import java.util.HashMap;
import java.util.List;

import com.igrow.mall.bean.entity.RoleInfo;

/**
 * @ClassName RoleDao
 * @Description TODO【角色】
 * @Author Brights
 * @Date 2013-11-11 下午4:27:31
 */
public interface RoleDao extends BaseDao<RoleInfo, String> {
	
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
	* @Title savePurviewRoleRef
	* @Description TODO【保存权限角色关系】
	* @param values 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public void saveRoleAdminUserRef(HashMap values);

}
