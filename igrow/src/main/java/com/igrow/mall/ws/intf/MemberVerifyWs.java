/**
* @FileName MemberVerifyDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午12:58:38
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.entity.MemberVerifyInfo;

/**
* @ClassName MemberVerifyWs
* @Description TODO【会员验证】
* @Author Brights
* @Date 2013-10-28 下午9:15:19
*/ 
public interface MemberVerifyWs extends BaseWs<MemberVerifyInfo, String> {
	
	/**
	* @Title findLastByMobile
	* @Description TODO【依据手机号码查询最后的验证码】
	* @param mobile
	* @return 
	* @Return MemberVerifyInfo 返回类型
	* @Throws 
	*/ 
	public MemberVerifyInfo findLastByMobile(String mobile);

}
