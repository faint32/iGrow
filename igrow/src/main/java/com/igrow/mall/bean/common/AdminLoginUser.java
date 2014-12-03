/**
* @FileName AdminLoginUser.java
* @Package com.igrow.mall.bean.common
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-20 下午4:59:55
* @Version V1.0.1
*/
package com.igrow.mall.bean.common;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.bean.entity.PurviewInfo;
import com.igrow.mall.bean.entity.RoleInfo;
import com.igrow.mall.common.enums.RoleGroup;

/**
 * @ClassName AdminLoginUser
 * @Description TODO【管理员登陆用户】
 * @Author Brights
 * @Date 2013-11-20 下午4:59:55
 */
public class AdminLoginUser implements Serializable{
	private static final long serialVersionUID = 3576566708133085480L;
	
	private String id;//id
	private String name;//姓名
	private String userSn;//管理员编号
	private String userName;//登陆用户名
	private String password;//登陆密码
	private String email;//电子邮箱
	private String mobile;//电话号码
	private Set<String> authCodes; //验证码
	protected Set<PurviewInfo> userPurviews;//管理员用户权限 
	private int roleGroupId; //角色组ID
	private int hotelId;//酒店ID
	private int supplierId;//供应商ID
	
	public AdminLoginUser(){
		
	}
	
	public AdminLoginUser(AdminUserInfo adminUser){
		if(adminUser != null){
			this.id = adminUser.getId();
			this.name = adminUser.getName();
			this.userSn = adminUser.getUserSn();
			this.userName = adminUser.getUserName();
			this.password = adminUser.getPassword();
			this.email = adminUser.getMobile();
			this.authCodes = new HashSet<String>();
			this.userPurviews = new HashSet<PurviewInfo>();
			if(adminUser.getRoleInfos() != null && adminUser.getRoleInfos().size() > 0){
				for(RoleInfo role : adminUser.getRoleInfos()){
					if(role.getPurviewInfos() != null && role.getPurviewInfos().size() > 0){
						for(PurviewInfo entity : role.getPurviewInfos()){
							userPurviews.add(entity);
							authCodes.add(entity.getCode());
						}
					}
				}
			}
			if(adminUser.getAdminRoleGroupConf() != null){
				this.roleGroupId = adminUser.getAdminRoleGroupConf().getRoleGroupId();
				if(adminUser.getAdminRoleGroupConf().getRoleGroupId() == RoleGroup.HOTEL_USER.getIdx()){
					this.hotelId = adminUser.getAdminRoleGroupConf().getParamValue();
				}
				if(adminUser.getAdminRoleGroupConf().getRoleGroupId() == RoleGroup.SUPPLIER_USER.getIdx()){
					this.supplierId = adminUser.getAdminRoleGroupConf().getParamValue();
				}
			}
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserSn() {
		return userSn;
	}

	public void setUserSn(String userSn) {
		this.userSn = userSn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<String> getAuthCodes() {
		return authCodes;
	}

	public void setAuthCodes(Set<String> authCodes) {
		this.authCodes = authCodes;
	}


	public Set<PurviewInfo> getUserPurviews() {
		return userPurviews;
	}


	public void setUserPurviews(Set<PurviewInfo> userPurviews) {
		this.userPurviews = userPurviews;
	}


	/**
	 * @return the roleGroupId
	 */
	public int getRoleGroupId() {
		return roleGroupId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param roleGroupId the roleGroupId to set
	 */
	public void setRoleGroupId(int roleGroupId) {
		this.roleGroupId = roleGroupId;
	}


	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}


	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}


	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	
}
