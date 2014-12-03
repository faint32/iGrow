/**
* @FileName RoleAction.java
* @Package com.igrow.mall.web.action.admin
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午6:09:57
* @Version V1.0.1
*/
package com.igrow.mall.web.action.admin;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName RoleAction
 * @Description TODO【角色Action】
 * @Author Brights
 * @Date 2013-10-18 下午6:09:57
 */
@Namespace("/role")
public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 6265014023884155453L;
	
	/**
	* @Title index
	* @Description TODO【主页面面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(INDEX)
	public String index(){
		return INDEX;
	}
	
	/**
	* @Title list
	* @Description TODO【列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		return LIST;
	}
	
	/**
	* @Title add
	* @Description TODO【添加】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(ADD)
	public String add(){
		return INPUT;
	}
	
	/**
	* @Title save
	* @Description TODO【保存】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	@Action(SAVE)
	public String save(){
		return SUCCESS;
	}
	
	/**
	* @Title edit
	* @Description TODO【编辑】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(EDIT)
	public String edit(){
		return INPUT;
	}
	
	/**
	* @Title update
	* @Description TODO【修改】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(UPDATE)
	public String update(){
		return SUCCESS;
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
		return SUCCESS;
	}
	
	/**
	* @Title detail
	* @Description TODO【详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DETAIL)
	public String detail(){
		return SUCCESS;
	}


}
