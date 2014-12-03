package com.igrow.mall.common.wchat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.enums.wchat.Wevent;
import com.igrow.mall.common.util.TemplateUtils;


public class WchatMenu extends WchatCore {
	
		
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
				result = TemplateUtils.process(WchatConstant.wchat_menu_create_request_params_template, data, WchatConstant.wchat_menu_create_request_params_key);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		* @Title getCreateRequestPostData
		* @Description TODO【创建菜单请求参数Post数据】
		* @param menus
		* @return 
		* @Return String 返回类型
		* @Throws 
		*/ 
		public static String getCreateRequestPostData(List<WchatOctMenuInfo> menus){
			StringBuffer sb = new StringBuffer();
			if(menus != null &&menus.size() > 0){
				sb.append("{");
				sb.append("\"button\":[");
				for(WchatOctMenuInfo menu : menus){
					sb.append("{");
					//首先判断
					sb.append("\"name\":\""+menu.getName()+"\",");
					List<WchatOctMenuInfo> subMenus = menu.getSubMenus();
					if(subMenus != null && subMenus.size() > 0){//确定是否存在子菜单
						sb.append("\"sub_button\":[");
						for(WchatOctMenuInfo subMenu : subMenus){
							//首先判断
							sb.append("{");
							sb.append("\"name\":\""+subMenu.getName()+"\",");
							if(subMenu.getEvent() == Wevent.CLICK){//为click事件
								sb.append("\"type\":\""+ Wevent.CLICK.getDesc() +"\",");
								sb.append("\"key\":\""+subMenu.getKey()+"\"");
							}else if(subMenu.getEvent() == Wevent.VIEW){
								sb.append("\"type\":\""+ Wevent.VIEW.getDesc() +"\",");
								sb.append("\"url\":\""+subMenu.getKey()+"\"");
							}else{
								sb.append("\"type\":\""+subMenu.getEvent().getDesc()  +"\",");
								sb.append("\"key\":\""+subMenu.getKey()+"\"");
							}
							sb.append("},");
						}
						//删除最好一个","
						sb.deleteCharAt(sb.length()-1);
						sb.append("]");
						//sb.append("}");
					}else{
						if(menu.getEvent() == Wevent.CLICK){//为click事件
							sb.append("\"type\":\""+ Wevent.CLICK.getDesc() +"\",");
							sb.append("\"key\":\""+menu.getKey()+"\"");
						}else if(menu.getEvent() == Wevent.VIEW){
							sb.append("\"type\":\""+ Wevent.VIEW.getDesc() +"\",");
							sb.append("\"url\":\""+menu.getKey()+"\"");
						}else{
							sb.append("\"type\":\""+menu.getEvent().getDesc()  +"\",");
							sb.append("\"key\":\""+menu.getKey()+"\"");
						}
					}
					sb.append("},");
				}
				//删除最好一个","
				if(sb.length() > 1){
					sb.deleteCharAt(sb.length()-1);
				}
				sb.append("]");
				sb.append("}");
			}
			return sb.toString();
		}
		
		
		/**
		* @Title getQueryRequestParams
		* @Description TODO【查询请求参数】
		* @return 
		* @Return String 返回类型
		* @Throws 
		*/ 
		public static String getQueryRequestParams(String accessToken){
			String result = "";
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("accesstoken", accessToken);
			try {
				result = TemplateUtils.process(WchatConstant.wchat_menu_query_request_params_template, data, WchatConstant.wchat_menu_query_request_params_key);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
		/**
		* @Title getDeleteRequestParams
		* @Description TODO【删除请求参数】
		* @return 
		* @Return String 返回类型
		* @Throws 
		*/ 
		public static String getDeleteRequestParams(){
			String result = "";
			Map<String,Object> data = new HashMap<String,Object>();
			//data.put("accesstoken", getAccessToken());
			try {
				result = TemplateUtils.process(WchatConstant.wchat_menu_delete_request_params_template, data, WchatConstant.wchat_menu_delete_request_params_key);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		
}
