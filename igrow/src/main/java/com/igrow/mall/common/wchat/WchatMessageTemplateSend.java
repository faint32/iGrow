/**
* @FileName WchatMessageTemplateSend.java
* @Package com.igrow.mall.common.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月26日 下午3:37:18
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.util.HashMap;
import java.util.Map;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.util.TemplateUtils;

/**
 * @ClassName WchatMessageTemplateSend
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月26日 下午3:37:18
 */
public class WchatMessageTemplateSend extends WchatCore {
	
	/**
	* @Title getCreateRequestParams
	* @Description TODO【创建菜单请求参数】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getCreateRequestParams(String accessToken){
		String result = "";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("accesstoken", getAccessToken());
		try {
			result = TemplateUtils.process(WchatConstant.wchat_message_template_send_request_params_template, data, WchatConstant.wchat_message_template_send_request_params_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
