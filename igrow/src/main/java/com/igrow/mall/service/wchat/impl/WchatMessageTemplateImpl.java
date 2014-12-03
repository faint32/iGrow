/**
* @FileName WchatMessageTemplateImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月26日 下午3:33:04
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;


import javax.annotation.Resource;


import org.apache.commons.lang.StringUtils;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.wchat.WchatMessageTemplateSend;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatMessageTemplate;

/**
 * @ClassName WchatMessageTemplateImpl
 * @Description TODO【微信模版消息发送】
 * @Author brights
 * @Date 2014年10月26日 下午3:33:04
 */
public class WchatMessageTemplateImpl implements WchatMessageTemplate {
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	 * @Title send
	 * @Description 
	 * @see com.igrow.mall.service.wchat.intf.WchatMessageTemplate#send()
	 */
	@Override
	public void send() {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append(WchatConstant.wchat_server_https_url);
		sbUrl.append(WchatConstant.wchat_message_template_send_uri);
		String accessToken = wchatAccessTokenProcess.getAccessToken();
		String requestParams = WchatMessageTemplateSend.getCreateRequestParams(accessToken);
		if(StringUtils.isNotBlank(requestParams)){
			sbUrl.append("?");
			sbUrl.append(requestParams);
		}
		
		/*List<WchatOctMenuInfo> menus =wchatOctMenuService.findMainMenus();
		if(menus != null && menus.size() > 0){
			String requestPostData = WchatMenu.getCreateRequestPostData(menus);
			String result = HttpsRequestHandler.sendPost(sbUrl.toString(),requestPostData);
			System.out.println(result);
			if(StringUtils.isNotBlank(result)){
				JSONObject jsonObj = JSONObject.fromObject(result);
				errorCode = jsonObj.getString("errcode");
			}
			System.out.println("返回码="+errorCode);
		}else{
			System.out.println("创建菜单失败");
		}*/

	}

}
