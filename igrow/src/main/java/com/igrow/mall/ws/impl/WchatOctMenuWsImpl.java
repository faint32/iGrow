/**
* @FileName WchatOctMenuWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午2:33:36
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.dao.mybatis.intf.WchatOctMenuDao;
import com.igrow.mall.ws.intf.WchatOctMenuWs;

/**
 * @ClassName WchatOctMenuWsImpl
 * @Description TODO【1克拉微信公众平台菜单】
 * @Author brights
 * @Date 2014年10月13日 下午2:33:36
 */
@Service("wchatOctMenuWsImpl")
public class WchatOctMenuWsImpl extends BaseWsImpl<WchatOctMenuInfo, String> implements
		WchatOctMenuWs {
	@Resource(name = "wchatOctMenuDao")
	private WchatOctMenuDao wchatOctMenuDao;
	
	@Resource(name = "wchatOctMenuDao")
	public void setBaseDao(WchatOctMenuDao wchatOctMenuDao) {
		super.setBaseDao(wchatOctMenuDao);
	}



	/**
	* @Title findMainMenus
	* @Description 
	* @return
	* @see com.igrow.mall.ws.intf.WchatOctMenuWs#findMainMenus()
	*/ 
	@Override
	public List<WchatOctMenuInfo> findMainMenus() {
		return wchatOctMenuDao.findMainMenus();
	}



	/**
	* @Title findByKey
	* @Description 
	* @param key
	* @return
	* @see com.igrow.mall.ws.intf.WchatOctMenuWs#findByKey(java.lang.String)
	*/ 
	@Override
	public WchatOctMenuInfo findByKey(String key) {
		return wchatOctMenuDao.findByKey(key);
	}


}
