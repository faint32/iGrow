/**
* @FileName AdminUserWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午5:02:58
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AdminUserInfoDto;
import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.RoleGroup;
import com.igrow.mall.dao.mybatis.intf.AdminUserDao;
import com.igrow.mall.ws.intf.AdminUserWs;

/**
 * @ClassName AdminUserWsImpl
 * @Description TODO【用户管理Ws层接口实现】
 * @Author Brights
 * @Date 2013-10-18 下午5:02:58
 */
@Service("adminUserWsImpl")
public class AdminUserWsImpl extends BaseWsImpl<AdminUserInfo, String> implements AdminUserWs {
	
	@Resource(name = "adminUserDao")
	private AdminUserDao adminUserDao;
	
	@Resource(name = "adminUserDao")
	public void setBaseDao(AdminUserDao adminUserDao) {
		super.setBaseDao(adminUserDao);
	}

	@Override
	public AdminUserInfo findByUserName(String userName) {
		return adminUserDao.findByUserName(userName);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Pager findPagerBy(AdminUserInfoDto adminUserInfoDto, Pager pager) {
		HashMap values = new HashMap();
		if(adminUserInfoDto != null && adminUserInfoDto.getName() != null && StringUtils.isNotBlank(adminUserInfoDto.getName())){
			values.put("name", adminUserInfoDto.getName());
		}
		
		if(adminUserDao != null){
			//查询数量
		}
		Long count = adminUserDao.getCountBy(values);
		pager.setTotalCount(count);
		if(pager.getPageNumber() >= pager.getPageCount()){
			pager.setPageNumber(pager.getPageCount());
		}
		if(count > 0){
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", pager.getOrderBy());
			values.put("order", pager.getOrder());
			//查询记录
			List<AdminUserInfo> admins = adminUserDao.findListBy(values);
			if(admins != null && admins.size() > 0){
				pager.setResults(admins);
				if(StringUtils.isBlank(pager.getFisrtId())){
					pager.setFisrtId(admins.get(0).getId());
				}
			}
		}else{
			pager.setFisrtId(null);
		}
		return pager;
	}

	@Override
	public void repair() {
		adminUserDao.repair();
	}

	@Override
	public void deleteAdminUserRoleRef(AdminUserInfo adminUserInfo) {
		adminUserDao.deleteAdminUserRoleRef(adminUserInfo);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public void insert(AdminUserInfo adminUserInfo,Integer groupId,Integer guserId){
		HashMap values = new HashMap();
		if(groupId == RoleGroup.ADMIN_USER.getIdx()){
			values.put("paramName","");
			adminUserInfo.setUserSn("admin");
			adminUserInfo.setName("系统管理员");
		}else if(groupId == RoleGroup.SUPPLIER_USER.getIdx()){
			values.put("paramName","supplier_id");
			adminUserInfo.setUserSn("supplier_admin");
			adminUserInfo.setName("供应商管理员");
		}else if(groupId == RoleGroup.HOTEL_USER.getIdx()){
			values.put("paramName","hotel_id");
			adminUserInfo.setUserSn("hotel_admin");
			adminUserInfo.setName("酒店管理员");
		}
		adminUserInfo.setPassword(DigestUtils.md5Hex(adminUserInfo.getPassword()));
		if(adminUserInfo.getAccountEnabled() != null){
		   Bool boolEnabled = Bool.valueOf(Integer.parseInt(adminUserInfo.getAccountEnabled()));
		   adminUserInfo.setIsAccountEnabled(boolEnabled);
		}
		super.insert(adminUserInfo);
		values.put("roleId",groupId);
		values.put("userId",adminUserInfo.getId());
		adminUserDao.insertRoleRef(values);
		values.put("groupId",groupId);
		values.put("paramValue",guserId);
		adminUserDao.insertRoleGroupRef(values);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public AdminUserInfo findByRole(String id, String string) {
		HashMap values = new HashMap();
		values.put("paramValue", id);
		values.put("paramName", string);
		return adminUserDao.findByRole(values);
	}
}
