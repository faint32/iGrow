/**
* @FileName AreaDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午2:05:02
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.Areas;

/**
 * @ClassName AreaDao
 * @Description TODO【区域Dao接口】
 * @Author Brights
 * @Date 2013-10-29 下午2:05:02
 */
public interface AreaDao extends BaseDao<Areas, String> {
	
	/**
	* @Title findBySn
	* @Description TODO【依据区域编号查询区域对象】
	* @param sn
	* @return 
	* @Return Areas 返回类型
	* @Throws 
	*/ 
	public Areas findBySn(String sn);

}
