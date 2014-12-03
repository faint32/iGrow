/**
* @FileName RedirectUrlDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014-5-4 下午5:26:58
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.RedirectUrlInfo;

/**
 * @ClassName RedirectUrlDao
 * @Description TODO【重定向地址DAO接口】
 * @Author Brights
 * @Date 2014-5-4 下午5:26:58
 */
public interface RedirectUrlDao extends BaseDao<RedirectUrlInfo, String> {
	/**
	* @Title findBySn
	* @Description TODO【依据编号查询对象】
	* @param sn
	* @return 
	* @Return RedirectUrlInfo 返回类型
	* @Throws 
	*/ 
	public RedirectUrlInfo findBySn(String sn);
	

}
