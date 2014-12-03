/**
* @FileName WchatOctMenuServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午2:38:24
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.service.admin.intf.WchatOctMenuService;
import com.igrow.mall.ws.intf.WchatOctMenuWs;

/**
 * @ClassName WchatOctMenuServiceImpl
 * @Description TODO【1克拉微信公众平台菜单】
 * @Author brights
 * @Date 2014年10月13日 下午2:38:24
 */
@Service("wchatOctMenuServiceImpl")
public class WchatOctMenuServiceImpl extends BaseServiceImpl<WchatOctMenuInfo, String> implements
		WchatOctMenuService {
	@Resource(name = "wchatOctMenuWsImpl")
	private WchatOctMenuWs wchatOctMenuWs;
	@Resource(name = "wchatOctMenuWsImpl")
	public void setBaseWs(WchatOctMenuWs wchatOctMenuWs) {
		super.setBaseWs(wchatOctMenuWs);
	}
	/**
	* @Title findMainMenus
	* @Description 
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatOctMenuService#findMainMenus()
	*/ 
	@Override
	public List<WchatOctMenuInfo> findMainMenus() {
		return wchatOctMenuWs.findMainMenus();
	}
	/**
	* @Title findByKey
	* @Description 
	* @param key
	* @return
	* @see com.igrow.mall.service.admin.intf.WchatOctMenuService#findByKey(java.lang.String)
	*/ 
	@Override
	public WchatOctMenuInfo findByKey(String key) {
		return wchatOctMenuWs.findByKey(key);
	}
	
	

}
