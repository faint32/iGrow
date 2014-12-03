/**
* @FileName WchatMenuProcessImpl.java
* @Package com.igrow.mall.service.common.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午2:42:52
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.bean.weixin.Weixin;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.enums.wchat.Wevent;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatMenu;
import com.igrow.mall.service.admin.intf.WchatOctMenuService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;
import com.igrow.mall.service.wchat.intf.WchatMenuProcess;


/**
 * @ClassName WchatMenuProcessImpl
 * @Description TODO【微信菜单处理接口实现】
 * @Author brights
 * @Date 2014年10月13日 下午2:42:52
 */
@Service("wchatMenuProcessImpl")
public class WchatMenuProcessImpl implements WchatMenuProcess {
	@Resource(name = "wchatOctMenuServiceImpl")
	private WchatOctMenuService wchatOctMenuService;
	@Resource(name = "wchatAccessTokenProcessImpl")
	private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	* @Title create
	* @Description 
	* @see com.igrow.mall.service.common.intf.WchatMenuProcess#create()
	*/ 
	@Override
	public boolean create() throws Exception {
		try {
			String errorCode = "";
			StringBuffer sbUrl = new StringBuffer();
			sbUrl.append(WchatConstant.wchat_server_https_url);
			sbUrl.append(WchatConstant.wchat_menu_create_uri);
			String accessToken = wchatAccessTokenProcess.getAccessToken();
			String requestParams = WchatMenu.getCreateRequestParams(accessToken);
			if(StringUtils.isNotBlank(requestParams)){
				sbUrl.append("?");
				sbUrl.append(requestParams);
			}
			List<WchatOctMenuInfo> menus =wchatOctMenuService.findMainMenus();
			if(menus != null && menus.size() > 0){
				String requestPostData = WchatMenu.getCreateRequestPostData(menus);
				String result = HttpsRequestHandler.sendPost(sbUrl.toString(),requestPostData);
				System.out.println(result);
				if(StringUtils.isNotBlank(result)){
					JSONObject jsonObj = JSONObject.fromObject(result);
					errorCode = jsonObj.getString("errcode");
					if(errorCode.equals("0")){
						return true; //菜单创建发布成功，24小时生效
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	* @Title query
	* @Description 
	* @see com.igrow.mall.service.common.intf.WchatMenuProcess#query()
	*/ 
	@Override
	public void query() {
		//System.out.println(WchatConstant.wchat_server_https_url + WchatConstant.wchat_menu_query_uri);
		String accessToken = wchatAccessTokenProcess.getAccessToken();
		String requestParams = WchatMenu.getQueryRequestParams(accessToken);
		//System.out.println(requestParams);
		String result = HttpsRequestHandler.sendGet(WchatConstant.wchat_server_https_url + WchatConstant.wchat_menu_query_uri, requestParams);
		System.out.println(result);
		if(StringUtils.isNotBlank(result)){
			//JSONObject jsonObj = JSONObject.fromObject(result);
		}
		
	}

	/**
	* @Title delete
	* @Description 
	* @see com.igrow.mall.service.common.intf.WchatMenuProcess#delete()
	*/ 
	@Override
	public void delete() {
		String result = HttpsRequestHandler.sendGet(WchatConstant.wchat_server_https_url + WchatConstant.wchat_menu_delete_uri, WchatMenu.getDeleteRequestParams());
		System.out.println(result);
		if(StringUtils.isNotBlank(result)){
			//JSONObject jsonObj = JSONObject.fromObject(result);
		}
		
	}

	/**
	* @Title dataGenerate
	* @Description 
	* @see com.igrow.mall.service.common.intf.WchatMenuProcess#dataGenerate()
	*/ 
	@Override
	public boolean dataGenerate() throws Exception {
		try {
			List<WchatOctMenuInfo> menus =wchatOctMenuService.findAllList();
			System.out.println("size="+menus.size());
			if(menus != null && menus.size() > 0){
				System.out.println("******************菜单获取数据开始******************");
				Weixin wx = new Weixin(WchatConstant.wchat_login_user, WchatConstant.wchat_login_password);
				wx.login();
				wx.getCookiestr();
				for(WchatOctMenuInfo menu : menus){
					if(menu != null && StringUtils.isNotBlank(menu.getSrcUrl())){
						//System.out.println("name="+menu.getName());
						if(menu.getEvent() == Wevent.CLICK){ //点击事件，直接获取
							String srcUrl = menu.getSrcUrl();
							srcUrl =  srcUrl.replaceAll("TOKEN", wx.getToken());
							System.out.println("srcData="+srcUrl);
							try {
								String srcData = wx.dataGenerate(srcUrl);
								System.out.println("srcData="+srcData);
								if(StringUtils.isNotBlank(srcData)){
									menu.setSrcData(srcData);
								}
							} catch (IOException e) {
								System.out.println("菜单["+menu.getName()+"]获取数据失败");
								menu.setSrcData("");
							}
							wchatOctMenuService.update(menu);
						}
					}
				}
				wx.logout();
				System.out.println("******************菜单获取数据完成******************");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
