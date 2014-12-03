/**
* @FileName ProvinceDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:49:21
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.Provinces;

/**
 * @ClassName ProvinceDao
 * @Description TODO【省Dao接口】
 * @Author Brights
 * @Date 2013-10-29 下午4:49:21
 */
public interface ProvinceDao extends BaseDao<Provinces, String> {
	
	/**
	* @Title findBySn
	* @Description TODO【依据省编号查询对象】
	* @param sn
	* @return 
	* @Return Provinces 返回类型
	* @Throws 
	*/ 
	public Provinces findBySn(String sn);
	
	
}
