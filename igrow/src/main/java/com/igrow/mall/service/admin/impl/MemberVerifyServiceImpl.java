/**
* @FileName MemberVerifyServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午10:06:55
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.MemberVerifyInfo;
import com.igrow.mall.service.admin.intf.MemberVerifyService;
import com.igrow.mall.ws.intf.MemberVerifyWs;

/**
 * @ClassName MemberVerifyServiceImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-29 上午10:06:55
 */
@Service("memberVerifyServiceImpl")
public class MemberVerifyServiceImpl extends BaseServiceImpl<MemberVerifyInfo, String> implements
		MemberVerifyService {
	
	@Resource(name = "memberVerifyWsImpl")
	private MemberVerifyWs memberVerifyWs;
	@Resource(name = "memberVerifyWsImpl")
	public void setBaseWs(MemberVerifyWs memberVerifyWs) {
		super.setBaseWs(memberVerifyWs);
	}


	@Override
	public MemberVerifyInfo findLastByMobile(String mobile) {
		return memberVerifyWs.findLastByMobile(mobile);
	}
	
	

	

}
