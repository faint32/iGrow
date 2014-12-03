/**
* @FileName AdminUserServiceImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午5:02:58
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.dto.AdminUserInfoDto;
import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.service.admin.intf.AdminUserService;
import com.igrow.mall.ws.intf.AdminUserWs;

/**
 * @ClassName AdminUserServiceImpl
 * @Description TODO【用户管理Service层接口实现】
 * @Author Brights
 * @Date 2013-10-18 下午5:02:58
 */
@Service("adminUserServiceImpl")
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUserInfo, String> implements AdminUserService {
	
	@Resource(name = "adminUserWsImpl")
	private AdminUserWs adminUserWs;
	
	@Resource(name = "adminUserWsImpl")
	public void setBaseWs(AdminUserWs adminUserWs) {
		super.setBaseWs(adminUserWs);
	}
	
	@Override
	public AdminUserInfo findByUserName(String userName) {
		return adminUserWs.findByUserName(userName);
	}

	@Override
	public boolean verifyAdminUser(String userName, String password) {
		AdminUserInfo adminUserInfo = adminUserWs.findByUserName(userName);
		if(adminUserInfo != null && adminUserInfo.getPassword().equals(DigestUtils.md5Hex(password))){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Pager findPagerBy(AdminUserInfoDto memberInfoDto, Pager pager) {
		return adminUserWs.findPagerBy(memberInfoDto, pager);
	}

	@Override
	public void insert(AdminUserInfo adminUserInfo,Integer groupId, Integer guserId){
		adminUserWs.insert(adminUserInfo,groupId,guserId);
	}

	@Override
	public AdminUserInfo findByRole(String id, String string) {
		return adminUserWs.findByRole(id,string);
	}
}
