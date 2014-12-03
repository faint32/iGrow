/**
* @FileName WchatQrcode.java
* @Package com.igrow.mall.common.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午2:32:27
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.util.HashMap;
import java.util.Map;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.util.TemplateUtils;

/**
 * @ClassName WchatQrcode
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月14日 下午2:32:27
 */
public class WchatQrcode extends WchatCore {
	
	public final static  String action_name_qr_scene  = "QR_SCENE";
	public final static  String action_name_qr_limit_scene  = "QR_LIMIT_SCENE";
	
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
			result = TemplateUtils.process(WchatConstant.wchat_qrcode_create_request_params_template, data, WchatConstant.wchat_qrcode_create_request_params_key);
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
	public static String getCreateRequestPostData(Integer scene,Integer expireSeconds ){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		if(expireSeconds >0 && expireSeconds <=1800){  //有效期范围
			sb.append("\"expire_seconds\":"+ expireSeconds +",");
			sb.append("\"action_name\":\""+ action_name_qr_scene +"\",");
		}else{
			sb.append("\"action_name\":\""+ action_name_qr_limit_scene +"\",");
		}
		sb.append("\"action_info\":{");
		sb.append("\"scene\":{");
		sb.append("\"scene_id\":"+ scene +",");
		sb.append("}");
		sb.append("}");
		sb.append("}");
		return sb.toString();
	}
	
}
