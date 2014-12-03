/**
* @FileName AdminUserWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午4:53:57
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AdminUserInfoDto;
import com.igrow.mall.bean.entity.AdminUserInfo;

/**
 * @ClassName AdminUserWs
 * @Description TODO【管理员用户WS层接口】
 * @Author Brights
 * @Date 2013-10-18 下午4:53:57
 */
public interface AdminUserWs extends BaseWs<AdminUserInfo, String> {
	
	/**
	* @Title findByUserName
	* @Description TODO【依据用户名查询登录管理】
	* @param userName
	* @return 
	* @Return AdminUserInfo 返回类型
	* @Throws 
	*/ 
	public AdminUserInfo findByUserName(String userName);
	/**
	* @Title findPagerBy
	* @Description TODO【分页查询】
	* @param adminUserInfoDto
	* @param pager
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(AdminUserInfoDto adminUserInfoDto, Pager pager);
	
	/**
	* @Title repair
	* @Description TODO【修复用户】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void repair();
	
	/**
	* @Title deleteAdminUserRoleRef
	* @Description TODO【删除管理员用户角色关系】
	* @param adminUserInfo 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void deleteAdminUserRoleRef(AdminUserInfo adminUserInfo);
	/**
	* @Title insert
	* @Description TODO【插入】
	* @param adminUserInfo 管理员对象
	* @Throws 
	*/ 
	public void insert(AdminUserInfo adminUserInfo,Integer groupId,Integer guserId);
	/**
	* @Title findByRole
	* @Description TODO【查找管理员】
	* @param adminUserInfo 管理员对象
	* @Throws 
	*/ 
	public AdminUserInfo findByRole(String id, String string);
}
