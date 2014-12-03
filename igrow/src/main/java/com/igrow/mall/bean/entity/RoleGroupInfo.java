/**
* @FileName RoleGroupInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-17 上午11:01:38
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName RoleGroupInfo
 * @Description TODO【角色组信息】
 * @Author Brights
 * @Date 2013-12-17 上午11:01:38
 */
@Alias("TroleGroupInfo")
public class RoleGroupInfo extends BaseEntity {
	private static final long serialVersionUID = -3191239967256903142L;
	
	private String name; //组名称
	private String paramName;//组参数名
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
}
