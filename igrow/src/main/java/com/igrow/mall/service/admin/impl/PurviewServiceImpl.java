/**
* @FileName PurviewServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 上午10:19:30
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.service.admin.intf.PurviewService;
import com.igrow.mall.ws.intf.PurviewWs;
import com.igrow.mall.ws.intf.RoleWs;

/**
 * @ClassName PurviewServiceImpl
 * @Description TODO【权限资源Service接口实现】
 * @Author Brights
 * @Date 2013-11-11 上午10:19:30
 */
@Service("purviewServiceImpl")
public class PurviewServiceImpl extends BaseServiceImpl<PurviewInfo, String> implements
		PurviewService {
	@Resource(name = "purviewWsImpl")
	private PurviewWs purviewWs;
	@Resource(name = "purviewWsImpl")
	public void setBaseWs(PurviewWs purviewWs) {
		super.setBaseWs(purviewWs);
	}
	@Resource(name = "roleWsImpl")
	public RoleWs roleWs;
	@Override
	public void save(String id, PurviewInfo entity, String[] ignoreProperties) {
		if(StringUtils.isNotBlank(id)){
			PurviewInfo purview = purviewWs.find(id);
			if(purview != null){
				BeanUtils.copyProperties(entity, purview, ignoreProperties);
				purviewWs.update(purview);
			}else{
				purviewWs.insert(entity);
			}
			//插入内置角色
		}
	}
	@Override
	public List<PurviewInfo> findMenuRoot() {
		return purviewWs.findMenuRoot();
	}
	@Override
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent) {
		return purviewWs.findMenuListByParent(parent);
	}
	
}
