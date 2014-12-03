/**
* @FileName RoleServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 下午5:20:52
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.RoleInfo;
import com.igrow.mall.service.admin.intf.RoleService;
import com.igrow.mall.ws.intf.RoleWs;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO【角色Service接口实现】
 * @Author Brights
 * @Date 2013-11-11 下午5:20:52
 */
@Service("roleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<RoleInfo, String> implements
		RoleService {
	@Resource(name = "roleWsImpl")
	public void setBaseWs(RoleWs roleWs) {
		super.setBaseWs(roleWs);
	}
	
}
