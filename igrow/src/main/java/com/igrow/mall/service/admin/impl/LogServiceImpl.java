/**
* @FileName LogServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-5 下午3:29:19
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.LogDetail;
import com.igrow.mall.service.admin.intf.LogService;
import com.igrow.mall.ws.intf.LogWs;

/**
 * @ClassName LogServiceImpl
 * @Description TODO【日志服务类接口实现】
 * @Author Brights
 * @Date 2013-11-5 下午3:29:19
 */
@Service("logServiceImpl")
public class LogServiceImpl extends BaseServiceImpl<LogDetail, String> implements
		LogService {
	@Resource(name = "logWsImpl")
	public void setBaseWs(LogWs logWs) {
		super.setBaseWs(logWs);
	}

}
