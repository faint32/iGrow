/**
* @FileName RepairService.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-13 下午1:03:35
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

/**
* @ClassName SystemRepairService
* @Description TODO【这里用一句话描述这个类的作用】
* @Author Brights
* @Date 2013-11-13 下午1:06:27
*/ 
public interface SystemRepairService {
	
	/**
	* @Title repair
	* @Description TODO【修复数据库】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void repair();

	/**
	* @Title deleteAndRepair
	* @Description TODO【删除后在修复】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void deleteAndRepair();

}
