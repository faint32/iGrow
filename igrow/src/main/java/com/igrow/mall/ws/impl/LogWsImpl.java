/**
* @FileName LogWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午4:29:40
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.LogDetail;
import com.igrow.mall.dao.mybatis.intf.LogDao;
import com.igrow.mall.ws.intf.LogWs;

/**
 * @ClassName LogWsImpl
 * @Description TODO【日志Ws接口实现】
 * @Author Brights
 * @Date 2013-10-28 下午4:29:40
 */
@Service("logWsImpl")
public class LogWsImpl extends BaseWsImpl<LogDetail, String> implements LogWs {
	@Resource(name = "logDao")
	public void setBaseDao(LogDao logDao) {
		super.setBaseDao(logDao);
	}
	
	

}
