/**
* @FileName RoleWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 下午4:57:37
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.RoleInfo;
import com.igrow.mall.dao.mybatis.intf.RoleDao;
import com.igrow.mall.ws.intf.RoleWs;

/**
 * @ClassName RoleWsImpl
 * @Description TODO【角色】
 * @Author Brights
 * @Date 2013-11-11 下午4:57:37
 */
@Service("roleWsImpl")
public class RoleWsImpl extends BaseWsImpl<RoleInfo, String> implements RoleWs {
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	
	@Resource(name = "roleDao")
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}

	/**
	 * @Title findSystemList
	 * @Description 
	 * @return
	 * @see com.igrow.mall.ws.intf.RoleWs#findSystemList()
	 */
	@Override
	public List<RoleInfo> findSystemList() {
		return roleDao.findSystemList();
	}

	@Override
	public void deleteRolePurviewRefByRole(RoleInfo role) {
		roleDao.deleteRolePurviewRefByRole(role);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void saveRoleAdminUserRef(HashMap values) {
		roleDao.saveRoleAdminUserRef(values);
	}

}
