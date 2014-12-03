/**
* @FileName PurviewInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午10:30:35
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;

/**
 * @ClassName PurviewInfo
 * @Description TODO【权限资源表】
 * @Author Brights
 * @Date 2013-10-18 上午10:30:35
 */
@Alias("TpurviewInfo")
public class PurviewInfo extends BaseEntity {
	private static final long serialVersionUID = 9041754780918216604L;
	
	private String code;//角色编码
	private String name;//名称
	private Bool isMenu;//是否为菜单
	private String linkurl;//请求地址
	private PurviewInfo parent; //父权限
	private Integer sortNo; //排序
	private Integer level; //级别
	private String style;//样式
	private List<PurviewInfo> subPurviews = new ArrayList<PurviewInfo>();
	private String roleGroups;//角色组信息
	
	
	public List<PurviewInfo> getSubPurviews() {
		return subPurviews;
	}
	public void setSubPurviews(List<PurviewInfo> subPurviews) {
		this.subPurviews = subPurviews;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bool getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Bool isMenu) {
		this.isMenu = isMenu;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public PurviewInfo getParent() {
		return parent;
	}
	public void setParent(PurviewInfo parent) {
		this.parent = parent;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * @return the roleGroups
	 */
	public String getRoleGroups() {
		return roleGroups;
	}
	/**
	 * @param roleGroups the roleGroups to set
	 */
	public void setRoleGroups(String roleGroups) {
		this.roleGroups = roleGroups;
	}

}
