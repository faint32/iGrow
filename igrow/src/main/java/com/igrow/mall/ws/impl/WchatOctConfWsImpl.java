/**
* @FileName WchatOctConfWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月17日 下午7:11:11
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctConfInfo;
import com.igrow.mall.dao.mybatis.intf.WchatOctConfDao;
import com.igrow.mall.ws.intf.WchatOctConfWs;

/**
 * @ClassName WchatOctConfWsImpl
 * @Description TODO【微信配置信息】
 * @Author brights
 * @Date 2014年10月17日 下午7:11:11
 */
@Service("wchatOctConfWsImpl")
public class WchatOctConfWsImpl extends BaseWsImpl<WchatOctConfInfo, String> implements
		WchatOctConfWs {
	@Resource(name = "wchatOctConfDao")
	private WchatOctConfDao wchatOctConfDao;
	@Resource(name = "wchatOctConfDao")
	public void setBaseDao(WchatOctConfDao wchatOctConfDao) {
		super.setBaseDao(wchatOctConfDao);
	}



	/**
	 * @Title findBySn
	 * @Description 
	 * @param sn
	 * @return
	 * @see com.igrow.mall.ws.intf.WchatOctConfWs#findBySn(java.lang.String)
	 */
	@Override
	public WchatOctConfInfo findBySn(String sn) {
		return wchatOctConfDao.findBySn(sn);
	}

}
