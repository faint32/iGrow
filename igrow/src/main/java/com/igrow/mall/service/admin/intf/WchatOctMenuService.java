/**
* @FileName WchatOctMenuService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午2:37:21
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import java.util.List;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;

/**
 * @ClassName WchatOctMenuService
 * @Description TODO【1克拉微信公众平台菜单】
 * @Author brights
 * @Date 2014年10月13日 下午2:37:21
 */
public interface WchatOctMenuService extends BaseService<WchatOctMenuInfo, String> {
	
	/**
	* @Title findMainMenus
	* @Description TODO【获取主菜单列表】
	* @return 
	* @Return List<WchatOctMenuInfo> 返回类型
	* @Throws 
	*/ 
	public List<WchatOctMenuInfo> findMainMenus();
	
	/**
	* @Title findByKey
	* @Description TODO【依据KEY获取菜单】
	* @param key
	* @return 
	* @Return WchatOctMenuInfo 返回类型
	* @Throws 
	*/ 
	public WchatOctMenuInfo findByKey(String key);
}
