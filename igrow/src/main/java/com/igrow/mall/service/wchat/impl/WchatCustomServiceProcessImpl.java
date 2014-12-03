/**
* @FileName WchatCustomServiceProcessImpl.java
* @Package com.igrow.mall.service.wchat.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 下午1:27:57
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.ParamsParser;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCustomService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatCustomServiceProcess;

/**
 * @ClassName WchatCustomServiceProcessImpl
 * @Description TODO【获取多客服】
 * @Author brights
 * @Date 2014年10月18日 下午1:27:57
 */
@Service("wchatCustomServiceProcessImpl")
public class WchatCustomServiceProcessImpl implements WchatCustomServiceProcess {
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;

	/**
	 * @Title getonlinekflist
	 * @Description 
	 * @see com.igrow.mall.service.wchat.intf.WchatCustomServiceProcess#getonlinekflist()
	 */
	@Override
	public List<HashMap<String, Object>> getonlinekflist() {
			List<HashMap<String, Object>> hmList = null;
			StringBuffer sbUrl = new StringBuffer();
			sbUrl.append(WchatConstant.wchat_server_https_url);
			sbUrl.append(WchatConstant.wchat_custom_service_getonlinekflist_uri); //发送客服消息
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestParams = WchatCustomService.getCreateRequestParams(accessToken);
			if(StringUtils.isNotBlank(requestParams)){
				sbUrl.append("?");
				sbUrl.append(requestParams);
			}
		//	String requestPostData = WchatCustom.getCreateRequestPostData();
			String result = HttpsRequestHandler.sendPost(sbUrl.toString(),"");
			System.out.println(result);
			if(StringUtils.isNotBlank(result)){
			//	JSONObject jsonObj = JSONObject.fromObject(result);
				ParamsParser parser = new ParamsParser(result);
				hmList = parser.getArrayList("kf_online_list");
				/*if(hmList != null  && hmList.size() > 0){
					for(HashMap<String, Object> map : hmList){
						System.out.println("*******************************************************************************************");
						System.out.println(map.get("kf_account"));
						System.out.println(map.get("status"));
						System.out.println(map.get("kf_id"));
						System.out.println(map.get("auto_accept"));
						System.out.println(map.get("accepted_case"));
						System.out.println("*******************************************************************************************");
					}
				}*/
			}
			return hmList;
	}

}
