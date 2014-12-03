/**
* @FileName MobileService.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-23 下午7:34:43
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

/**
 * @ClassName MobileService
 * @Description TODO【手机号码服务类】
 * @Author Brights
 * @Date 2013-11-23 下午7:34:43
 */
public interface MobileService {
	
	/**
	* @Title getRemoteMobileInfo
	* @Description TODO【获取远程服务器手机号码信息】
	* @param mobile 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void processRemoteMobileTask(String mobile);
}
