/**
* @FileName WchatCustomProcessImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 下午12:10:33
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCustom;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatCustomProcess;

/**
 * @ClassName WchatCustomProcessImpl
 * @Description TODO【发送客服信息】
 * @Author brights
 * @Date 2014年10月18日 下午12:10:33
 */
@Service("wchatCustomProcessImpl")
public class WchatCustomProcessImpl implements WchatCustomProcess {
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	 * @Title send
	 * @Description 
	 * @param sendInfo
	 * @return
	 * @throws Exception
	 * @see com.igrow.mall.service.wchat.intf.WchatCustomProcess#send(com.igrow.mall.bean.entity.WchatOctCustomSendDetail)
	 */
	@Override
	public boolean send(WchatOctCustomSendDetail sendInfo) throws Exception {
		if(sendInfo != null){
			String errcode = "";
			StringBuffer sbUrl = new StringBuffer();
			sbUrl.append(WchatConstant.wchat_server_https_url);
			sbUrl.append(WchatConstant.wchat_custom_message_send_uri); //发送客服消息
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestParams = WchatCustom.getCreateRequestParams(accessToken);
			if(StringUtils.isNotBlank(requestParams)){
				sbUrl.append("?");
				sbUrl.append(requestParams);
			}
			String requestPostData = WchatCustom.getCreateRequestPostData(sendInfo);
			String result = HttpsRequestHandler.sendPost(sbUrl.toString(),requestPostData);
			System.out.println(result);
			if(StringUtils.isNotBlank(result)){
				JSONObject jsonObj = JSONObject.fromObject(result);
				errcode = jsonObj.getString("errcode");
				if(errcode.equals("0")){
					return true;
				}
			}
			System.out.println("返回="+errcode);
		}
		return false;
	}

}
