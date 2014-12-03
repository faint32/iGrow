/**
* @FileName LogDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午10:36:07
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.SystemType;

/**
 * @ClassName LogDetail
 * @Description TODO【日志表】
 * @Author Brights
 * @Date 2013-10-18 上午10:36:07
 */
@Alias("TlogDetail")
public class LogDetail extends BaseEntity {
	private static final long serialVersionUID = -7913398862117037715L;
	
	private String operation;//操作名
	private String operator;//操作员
	private String actionClass;//Action名称
	private String actionMethod;//方法名称
	private String ip;//ip
	private String info;//日志内容
	private SystemType systemType;//系统类型
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public String getActionMethod() {
		return actionMethod;
	}
	public void setActionMethod(String actionMethod) {
		this.actionMethod = actionMethod;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public SystemType getSystemType() {
		return systemType;
	}
	public void setSystemType(SystemType systemType) {
		this.systemType = systemType;
	}
	

}
