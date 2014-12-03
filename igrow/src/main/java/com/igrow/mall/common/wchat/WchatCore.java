package com.igrow.mall.common.wchat;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.httpClient.HttpRequestHandler;
import com.igrow.mall.common.util.TemplateUtils;

import net.sf.json.JSONObject;



/**
 * @ClassName WchatConstant
 * @Description TODO【微信】
 * @Author brights
 * @Date 2014年8月14日 下午3:05:47
 */
public class WchatCore {
	
	 /**
	* @Title getAccessToken
	* @Description TODO【获取访问令牌】
	* @param modelMap
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getAccessToken (){
		String token = "";
		String result = HttpRequestHandler.sendGet(WchatConstant.wchat_server_https_url + WchatConstant.wchat_token_uri, getAccessTokenRequestParams());
		if(StringUtils.isNotBlank(result)){
			JSONObject jsonObj = JSONObject.fromObject(result);
			if(jsonObj.get("errcode") != null){
				token = "";
			}else{
				token = jsonObj.getString("access_token");
			}
		}
		return token;
	}
	
	public static String getAccessTokenRequestParams(){
		String result = "";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("appid", WchatConstant.wchat_appid);
		data.put("secret", WchatConstant.wchat_appsecret);
		try {
			result = TemplateUtils.process(WchatConstant.wchat_token_request_params_template, data, WchatConstant.wchat_token_request_params_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getTokenReqUrl(String reqUrl,String accessToken){
		if(StringUtils.isNotBlank(reqUrl)){
			reqUrl = reqUrl.replaceAll("TOKEN", accessToken);
		}
		//System.out.println("reqUrl="+reqUrl);
		return reqUrl;
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
