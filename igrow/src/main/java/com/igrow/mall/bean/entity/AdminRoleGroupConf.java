/**
* @FileName AdminRoleGroupConf.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-17 上午11:12:08
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName AdminRoleGroupConf
 * @Description TODO【管理员角色组配置】
 * @Author Brights
 * @Date 2013-12-17 上午11:12:08
 */
@Alias("TadminRoleGroupConf")
public class AdminRoleGroupConf extends BaseEntity {
	private static final long serialVersionUID = 1292235093857052581L;
	
	private AdminUserInfo adminUser;//管理员用户
	private RoleGroupInfo RoleGroup; //角色组
	private int adminUserId; //管理员ID
	private int roleGroupId; //角色组ID
	private String paramName; //参数名
	private int paramValue; //参数值
	
	/**
	 * @return the adminUser
	 */
	public AdminUserInfo getAdminUser() {
		return adminUser;
	}
	/**
	 * @param adminUser the adminUser to set
	 */
	public void setAdminUser(AdminUserInfo adminUser) {
		this.adminUser = adminUser;
	}
	/**
	 * @return the roleGroup
	 */
	public RoleGroupInfo getRoleGroup() {
		return RoleGroup;
	}
	/**
	 * @param roleGroup the roleGroup to set
	 */
	public void setRoleGroup(RoleGroupInfo roleGroup) {
		RoleGroup = roleGroup;
	}
	/**
	 * @return the adminUserId
	 */
	public int getAdminUserId() {
		return adminUserId;
	}
	/**
	 * @param adminUserId the adminUserId to set
	 */
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	/**
	 * @return the roleGroupId
	 */
	public int getRoleGroupId() {
		return roleGroupId;
	}
	/**
	 * @param roleGroupId the roleGroupId to set
	 */
	public void setRoleGroupId(int roleGroupId) {
		this.roleGroupId = roleGroupId;
	}
	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * @param paramName the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * @return the paramValue
	 */
	public int getParamValue() {
		return paramValue;
	}
	/**
	 * @param paramValue the paramValue to set
	 */
	public void setParamValue(int paramValue) {
		this.paramValue = paramValue;
	}
	

}
