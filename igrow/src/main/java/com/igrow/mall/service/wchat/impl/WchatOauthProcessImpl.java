/**
* @FileName WchatOauthProcessImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午4:36:43
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatOauth;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatOauthProcess;

/**
 * @ClassName WchatOauthProcessImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月14日 下午4:36:43
 */
@Service("wchatOauthProcessImpl")
public class WchatOauthProcessImpl implements WchatOauthProcess {
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	* @Title generateOauthUrl
	* @Description 
	* @param redirectUri
	* @see com.igrow.mall.service.wchat.intf.WchatOauthProcess#generateOauthUrl(java.lang.String)
	*/ 
	@Override
	public String generateOauthUrl(String redirectUri,String state) {
		if(StringUtils.isNotBlank(redirectUri)){
			StringBuffer sbUrl = new StringBuffer();
			sbUrl.append(WchatConstant.wchat_connect_oauth2_url);
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestParams = WchatOauth.getGenerateRequestParams(redirectUri,state,accessToken);
			if(StringUtils.isNotBlank(requestParams)){
				sbUrl.append("?");
				sbUrl.append(requestParams);
			}
			System.out.println(sbUrl.toString());
			return sbUrl.toString();
		}
		return redirectUri;
	}

	/**
	* @Title getOauthOpenId
	* @Description 
	* @param code
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatOauthProcess#getOauthOpenId(java.lang.String)
	*/ 
	@Override
	public String getOauthAccessTokenOpenId(String code) {
		String openid = "";
		if(StringUtils.isNotBlank(code)){
			StringBuffer sbUrl = new StringBuffer();
			sbUrl.append(WchatConstant.wchat_sns_oauth2_token_url);
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestParams = WchatOauth.getTokenRequestParams(code,accessToken);
			if(StringUtils.isNotBlank(requestParams)){
				sbUrl.append("?");
				sbUrl.append(requestParams);
			}
			System.out.println(sbUrl.toString());
			String result = HttpsRequestHandler.sendPost(sbUrl.toString(),"");
			System.out.println(result);
			if(StringUtils.isNotBlank(result)){
				try {
					JSONObject jsonObj = JSONObject.fromObject(result);
					openid =   jsonObj.getString("openid");
				} catch (Exception e) {
					openid = "";
				}
			}
		}
		return openid;
	}


}
