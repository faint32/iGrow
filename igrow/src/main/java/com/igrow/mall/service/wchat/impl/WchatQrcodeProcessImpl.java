/**
* @FileName WchatQrcodeProcessImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午2:27:17
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatQrcode;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatQrcodeProcess;

/**
 * @ClassName WchatQrcodeProcessImpl
 * @Description TODO【微信二微码处理接口】
 * @Author brights
 * @Date 2014年10月14日 下午2:27:17
 */
@Service("wchatQrcodeProcessImpl")
public class WchatQrcodeProcessImpl implements WchatQrcodeProcess {
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	 * @Title create
	 * @Description 
	 * @see com.igrow.mall.service.wchat.intf.WchatQrcodeProcess#create()
	 */
	@Override
	public void create(Integer scene,Integer expireSeconds) {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append(WchatConstant.wchat_server_https_url);
		sbUrl.append(WchatConstant.wchat_qrcode_create_uri);
		String accessToken = wchatAccessTokenProcess.getAccessToken();
		String requestParams = WchatQrcode.getCreateRequestParams(accessToken);
		if(StringUtils.isNotBlank(requestParams)){
			sbUrl.append("?");
			sbUrl.append(requestParams);
		}
		String requestPostData = WchatQrcode.getCreateRequestPostData(scene,expireSeconds);
		String result = HttpsRequestHandler.sendPost(sbUrl.toString(),requestPostData);
		System.out.println(result);
		if(StringUtils.isNotBlank(result)){
			JSONObject jsonObj = JSONObject.fromObject(result);
			String ticket = jsonObj.getString("ticket");
			//System.out.println("ticket="+ticket);
			//String url = jsonObj.getString("url");
			//System.out.println("url="+url);
			//String expSeconds = jsonObj.getString("expire_seconds");
			//System.out.println("expSeconds="+expSeconds);
			System.out.println("二维码 scene=" + scene + "的地址:" + WchatConstant.wchat_get_qrcode_url +ticket );
		}
		//System.out.println("返回="+errcode);

	}

	/**
	 * @Title show
	 * @Description 
	 * @param ticket
	 * @see com.igrow.mall.service.wchat.intf.WchatQrcodeProcess#show(java.lang.String)
	 */
	@Override
	public void show(String ticket) {

	}

}
