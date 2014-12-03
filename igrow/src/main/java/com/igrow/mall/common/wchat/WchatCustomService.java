/**
* @FileName WchatCustomService.java
* @Package com.igrow.mall.common.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 下午1:43:29
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.util.HashMap;
import java.util.Map;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.util.TemplateUtils;

/**
 * @ClassName WchatCustomService
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月18日 下午1:43:29
 */
public class WchatCustomService extends WchatCore {
	
	/**
	* @Title getCreateRequestParams
	* @Description TODO【创建请求参数】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getCreateRequestParams(String accessToken){
		String result = "";
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("accesstoken", accessToken);
		try {
			result = TemplateUtils.process(WchatConstant.wchat_custom_service_getonlinekflist_params_template, data, WchatConstant.wchat_custom_service_getonlinekflist_request_params_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	* @Title getCreateRequestPostData
	* @Description TODO【创建请求参数Post数据】
	* @param menus
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getCreateRequestPostData(WchatOctCustomSendDetail sendInfo ){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"touser\":\""+ sendInfo.getToUser() +"\",");
		sb.append("\"msgtype\":\""+ sendInfo.getMsgType() +"\",");
		sb.append("\"text\":{");
		sb.append("\"content\":\""+ sendInfo.getContent() +"\"");
		sb.append("}");
		sb.append("}");
		return sb.toString();
	}
}
