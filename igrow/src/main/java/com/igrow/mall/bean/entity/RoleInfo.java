/**
* @FileName RoleInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午10:19:34
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;
import com.igrow.mall.common.enums.Status;

/**
 * @ClassName RoleInfo
 * @Description TODO【用户角色表】
 * @Author Brights
 * @Date 2013-10-18 上午10:19:34
 */
@Alias("TroleInfo")
public class RoleInfo extends BaseEntity {
	private static final long serialVersionUID = 1002023294716915045L;
	
	private String code;//角色编码
	private String name;//名称
	private Bool isSystem;//是否内置角色
	private Status status;//状态
	private Bool isDelete;//是否删除
	private String description;//描述
	private List<PurviewInfo> purviewInfos; //权限列表
	
	private int roleGroupId; //角色组ID
	private RoleGroupInfo roleGroup; //角色组信息
	
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
	public Bool getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(Bool isSystem) {
		this.isSystem = isSystem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PurviewInfo> getPurviewInfos() {
		return purviewInfos;
	}
	public void setPurviewInfos(List<PurviewInfo> purviewInfos) {
		this.purviewInfos = purviewInfos;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Bool getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Bool isDelete) {
		this.isDelete = isDelete;
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
	 * @return the roleGroup
	 */
	public RoleGroupInfo getRoleGroup() {
		return roleGroup;
	}
	/**
	 * @param roleGroup the roleGroup to set
	 */
	public void setRoleGroup(RoleGroupInfo roleGroup) {
		this.roleGroup = roleGroup;
	}

}
