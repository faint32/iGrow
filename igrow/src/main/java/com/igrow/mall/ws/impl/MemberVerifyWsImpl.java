/**
* @FileName MemberVerifyWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午9:15:48
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.MemberVerifyInfo;
import com.igrow.mall.dao.mybatis.intf.MemberVerifyDao;
import com.igrow.mall.ws.intf.MemberVerifyWs;

/**
 * @ClassName MemberVerifyWsImpl
 * @Description TODO【会员验证接口实现】
 * @Author Brights
 * @Date 2013-10-28 下午9:15:48
 */
@Service("memberVerifyWsImpl")
public class MemberVerifyWsImpl extends BaseWsImpl<MemberVerifyInfo, String> implements
		MemberVerifyWs {
	@Resource(name = "memberVerifyDao")
	private MemberVerifyDao memberVerifyDao;
	@Resource(name = "memberVerifyDao")
	public void setBaseDao(MemberVerifyDao memberVerifyDao) {
		super.setBaseDao(memberVerifyDao);
	}
	@Override
	public MemberVerifyInfo findLastByMobile(String mobile) {
		return memberVerifyDao.findLastByMobile(mobile);
	}
	
	

}
