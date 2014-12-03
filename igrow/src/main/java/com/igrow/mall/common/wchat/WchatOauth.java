/**
* @FileName WchatOauth.java
* @Package com.igrow.mall.common.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午5:14:36
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.util.TemplateUtils;

/**
 * @ClassName WchatOauth
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月14日 下午5:14:36
 */
public class WchatOauth extends WchatCore {
	
	
	/**
	* @Title getGenerateRequestParams
	* @Description TODO【创建请求参数】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getGenerateRequestParams(String redirectUri,String state,String accessToken){
		String result = "";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("appid", WchatConstant.wchat_appid);
		try {
			redirectUri = URLEncoder.encode(redirectUri, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		data.put("redirectUri",  redirectUri );
		data.put("state",state);
		try {
			result = TemplateUtils.process(WchatConstant.wchat_connect_oauth2_url_request_params__snsapi_base_template, data, WchatConstant.wchat_connect_oauth2_url_request_params__snsapi_base_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public static String getTokenRequestParams(String code,String accessToken){
		String result = "";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("appid", WchatConstant.wchat_appid);
		data.put("secret", WchatConstant.wchat_appsecret);
		data.put("code",code);
		try {
			result = TemplateUtils.process(WchatConstant.wchat_sns_oauth2_token_request_params_template, data, WchatConstant.wchat_sns_oauth2_token_request_params_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

}
