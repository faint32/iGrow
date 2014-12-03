/**
* @FileName WchatOauthProcess.java
* @Package com.igrow.mall.service.wchat.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午4:36:29
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

/**
 * @ClassName WchatOauthProcess
 * @Description TODO【微信授权】
 * @Author brights
 * @Date 2014年10月14日 下午4:36:29
 */
public interface WchatOauthProcess {
	
	/**
	* @Title generateOauthUrl
	* @Description TODO【生成授权地址】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public String generateOauthUrl(String redirectUri,String state);
	
	/**
	* @Title getOauthToken
	* @Description TODO【获取授权】
	* @param code 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public String getOauthAccessTokenOpenId(String code);
	

}
