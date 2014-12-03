/**
* @FileName CitieDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:47:07
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.Cities;

/**
 * @ClassName CitieDao
 * @Description TODO【城市Dao接口】
 * @Author Brights
 * @Date 2013-10-29 下午4:47:07
 */
public interface CityDao extends BaseDao<Cities, String> {
	
	/**
	* @Title findBySn
	* @Description TODO【依据城市编号查询城市】
	* @param sn
	* @return 
	* @Return Cities 返回类型
	* @Throws 
	*/ 
	public Cities findBySn(String sn);

}
