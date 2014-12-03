/**
* @FileName PurviewService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 上午10:18:18
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import java.util.List;

import com.igrow.mall.bean.entity.PurviewInfo;

/**
 * @ClassName PurviewService
 * @Description TODO【权限资源Service接口】
 * @Author Brights
 * @Date 2013-11-11 上午10:18:18
 */
public interface PurviewService extends BaseService<PurviewInfo, String> {
	
	/**
	* @Title save
	* @Description TODO【保存记录】
	* @param id
	* @param entity
	* @param properties 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void save(String id,PurviewInfo entity, String[] properties);
	
	/**
	* @Title findRoot
	* @Description TODO【获取主一级菜单】
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<PurviewInfo> findMenuRoot();
	
	/**
	* @Title findByParent
	* @Description TODO【获取子菜单】
	* @param entity
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent);

}
