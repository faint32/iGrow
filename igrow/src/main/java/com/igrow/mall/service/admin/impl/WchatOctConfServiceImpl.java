/**
* @FileName WchatOctConfServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月17日 下午7:13:58
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctConfInfo;
import com.igrow.mall.service.admin.intf.WchatOctConfService;
import com.igrow.mall.ws.intf.WchatOctConfWs;

/**
 * @ClassName WchatOctConfServiceImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月17日 下午7:13:58
 */
@Service("wchatOctConfServiceImpl")
public class WchatOctConfServiceImpl extends BaseServiceImpl<WchatOctConfInfo, String> implements
		WchatOctConfService {
	@Resource(name= "wchatOctConfWsImpl")
	private WchatOctConfWs wchatOctConfWs;
	
	@Resource(name= "wchatOctConfWsImpl")
	public void setBaseWs(WchatOctConfWs wchatOctConfWs) {
		super.setBaseWs(wchatOctConfWs);
	}

	/**
	 * @Title findBySn
	 * @Description 
	 * @param sn
	 * @return
	 * @see com.igrow.mall.service.admin.intf.WchatOctConfService#findBySn(java.lang.String)
	 */
	@Override
	public WchatOctConfInfo findBySn(String sn) {
		return wchatOctConfWs.findBySn(sn);
	}

}
