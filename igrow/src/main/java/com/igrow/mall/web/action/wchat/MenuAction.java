/**
* @FileName MenuAction.java
* @Package com.igrow.mall.web.action.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月30日 上午10:12:51
* @Version V1.0.1
*/
package com.igrow.mall.web.action.wchat;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.SystemEnums.OperateStatus;
import com.igrow.mall.common.enums.wchat.Wevent;
import com.igrow.mall.service.admin.intf.WchatOctMenuService;
import com.igrow.mall.service.wchat.intf.WchatMenuProcess;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName MenuAction
 * @Description TODO【微信菜单管理】
 * @Author brights
 * @Date 2014年10月30日 上午10:12:51
 */
@Namespace("/wchat/mn")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0504")
})
public class MenuAction extends BaseAction {
	private static final long serialVersionUID = -4587210688252413304L;
	
	@Resource(name = "wchatOctMenuServiceImpl")
	private WchatOctMenuService wchatOctMenuService;
	@Resource(name = "wchatMenuProcessImpl")
	private WchatMenuProcess wchatMenuProcess;
	
	private  List<WchatOctMenuInfo> menus; //菜单列表
	private  WchatOctMenuInfo form; //菜单form对象
	private  WchatOctMenuInfo result; //菜单result对象
	
	
	/**
	* @Title list
	* @Description TODO【菜单列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		menus = wchatOctMenuService.findMainMenus();
		return LIST;
	}
	
	/**
	* @Title save
	* @Description TODO【添加或修改菜单名称】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(SAVE)
	public String save(){
		if(StringUtils.isBlank(id)){ //添加保存菜单名称
			if(form != null && StringUtils.isNotBlank(form.getName())){  
				if(StringUtils.isBlank(form.getParentId())){
					form.setParentId(null);
				}
				form.setIsDelete(Bool.FALSE);
				form.setSort(0);
				wchatOctMenuService.insert(form);
				return ajax(OperateStatus.SUCCESS,"添加菜单成功!",form.getId());
			}
			return ajax(OperateStatus.ERROR,"添加菜单失败!");
		}else{ //修改保存菜单名称
			WchatOctMenuInfo entity = wchatOctMenuService.find(id);
			if(entity != null && StringUtils.isNotBlank(form.getName())){
				entity.setName(form.getName());
				wchatOctMenuService.update(entity);
				return ajax(OperateStatus.SUCCESS,"修改菜单成功!");
			}
			return ajax(OperateStatus.ERROR,"修改菜单失败!");
		}
	}
	
	/**
	* @Title action
	* @Description TODO【设置菜单事件】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(INPUT)
	public String action(){
		//System.out.println(id);
		result = wchatOctMenuService.find(id);
		//System.out.println(result.getSrcUrl());
		return INPUT;
	}
	
	@Action(UPDATE)
	public String update(){
		WchatOctMenuInfo entity = wchatOctMenuService.find(id);
		if(entity != null && form != null){
			if(value.equals("4")){ //触发click
				entity.setEvent(Wevent.CLICK);
				entity.setKey(entity.getId());
				entity.setSrcUrl(getWchatSrcUrl(form.getSrcUrl())); //资源地址
				wchatOctMenuService.update(entity);
			}else if(value.equals("5")){ //触发view
				entity.setEvent(Wevent.VIEW);
				entity.setKey(form.getKey());
				wchatOctMenuService.update(entity);
			}else{
				return ajax(OperateStatus.ERROR,"设置菜单动作失败!");
			}
			return ajax(OperateStatus.SUCCESS,"设置菜单动作成功!");
		}
		return ajax(OperateStatus.ERROR,"设置菜单动作失败!");
	}
	
	/**
	* @Title delete
	* @Description TODO【删除】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DELETE)
	public String delete(){
		WchatOctMenuInfo entity = wchatOctMenuService.find(id);
		if(entity != null){
			entity.setIsDelete(Bool.TRUE);
			wchatOctMenuService.delete(entity);
			return ajax(OperateStatus.SUCCESS,"菜单数删成功!");
		}
		return ajax(OperateStatus.ERROR,"菜单数删除失败!");
	}
	
	/**
	* @Title generate
	* @Description TODO【菜单数据生成】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("generate")
	public String generate(){
		try {
			boolean isSucc = wchatMenuProcess.dataGenerate();
			if(isSucc){
				return ajax(OperateStatus.SUCCESS,"菜单数据生成成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax(OperateStatus.ERROR,"菜单数据生成失败!");
	}
	
	/**
	* @Title publish
	* @Description TODO【菜单发布 】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(PUBLISH)
	public String publish(){
		try {
			boolean isSucc = wchatMenuProcess.create();
			if(isSucc){
				return ajax(OperateStatus.SUCCESS,"菜单发布成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax(OperateStatus.ERROR,"菜单发布成功!");
	}
	
	public String getWchatSrcUrl(String url){
		if(StringUtils.isNotBlank(url) &&url.contains("&token=") ){
			 Pattern pat = Pattern.compile("&token=(\\w){10}&");
		     Matcher mat = pat.matcher(url);
		     while (mat.find()) {
		    	 url = url.replace(mat.group(), "&token=TOKEN&");
		      }
		}
		 System.out.println(url);
		return url;
	}
	/*public String getWchatSrcUrl(String url){
		if(StringUtils.isBlank(url)){
			return url;
		}
		if(url.contains("token=")){
			String[] urlparams = url.split("\\?");
			if(urlparams != null && urlparams.length >=2){
				String tempUrl = urlparams[0];
				String tempPram = urlparams[1];
				String[] tempPrams = tempPram.split("\\&");
				if(tempPrams != null && tempPrams.length >=2){
					for(int i=0;i<tempPrams.length;i++){
						if(tempPrams[i].contains("token=")){
							tempPrams[i] = "token=TOKEN";
							break;
						}
					}
					tempPram = "";
					for(String str:tempPrams){
						tempPram = tempPram + "&" + str;
					}
					tempPram = tempPram.substring(1, tempPram.length());
					url = tempUrl + "?" +tempPram;
					return url;
				}
			}
		}else{
			url = url + "&token=TOKEN";
		}
		return url;
	}*/
	
	/**
	 * @return the menus
	 */
	public List<WchatOctMenuInfo> getMenus() {
		return menus;
	}

	/**
	 * @return the form
	 */
	public WchatOctMenuInfo getForm() {
		return form;
	}

	/**
	 * @return the result
	 */
	public WchatOctMenuInfo getResult() {
		return result;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<WchatOctMenuInfo> menus) {
		this.menus = menus;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(WchatOctMenuInfo form) {
		this.form = form;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(WchatOctMenuInfo result) {
		this.result = result;
	}

}
