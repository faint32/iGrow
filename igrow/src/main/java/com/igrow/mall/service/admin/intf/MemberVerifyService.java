/**
* @FileName MemberVerifyService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 上午10:05:32
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import com.igrow.mall.bean.entity.MemberVerifyInfo;

/**
 * @ClassName MemberVerifyService
 * @Description TODO【会员验证服务类】
 * @Author Brights
 * @Date 2013-10-29 上午10:05:32
 */
public interface MemberVerifyService extends BaseService<MemberVerifyInfo, String> {
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
