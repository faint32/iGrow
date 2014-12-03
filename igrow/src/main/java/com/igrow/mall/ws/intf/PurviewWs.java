/**
* @FileName PurviewWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-11 上午10:15:07
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import java.util.HashMap;
import java.util.List;

import com.igrow.mall.bean.entity.PurviewInfo;

/**
 * @ClassName PurviewWs
 * @Description TODO【权限资源Ws接口】
 * @Author Brights
 * @Date 2013-11-11 上午10:15:07
 */
public interface PurviewWs extends BaseWs<PurviewInfo, String> {
	
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
	
	/**
	* @Title savePurviewRoleRef
	* @Description TODO【保存权限角色关系】
	* @param values 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public void savePurviewRoleRef(HashMap values);

}
