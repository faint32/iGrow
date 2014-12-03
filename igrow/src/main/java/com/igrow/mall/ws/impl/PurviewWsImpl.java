/**
* @FileName PurviewWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 上午10:16:36
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.dao.mybatis.intf.PurviewDao;
import com.igrow.mall.ws.intf.PurviewWs;

/**
 * @ClassName PurviewWsImpl
 * @Description TODO【权限资源Ws接口实现】
 * @Author Brights
 * @Date 2013-11-11 上午10:16:36
 */
@Service("purviewWsImpl")
public class PurviewWsImpl extends BaseWsImpl<PurviewInfo, String> implements PurviewWs {
	@Resource(name = "purviewDao")
	private PurviewDao purviewDao;

	@Resource(name = "purviewDao")
	public void setBaseDao(PurviewDao purviewDao) {
		super.setBaseDao(purviewDao);
	}

	@Override
	public List<PurviewInfo> findMenuRoot() {
		return purviewDao.findMenuRoot();
	}

	@Override
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent) {
		return purviewDao.findMenuListByParent(parent);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void savePurviewRoleRef(HashMap values) {
		purviewDao.savePurviewRoleRef(values);
	}
	
	
	

}
