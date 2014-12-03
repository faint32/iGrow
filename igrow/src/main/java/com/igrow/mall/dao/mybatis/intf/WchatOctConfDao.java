/**
* @FileName WchatOctConfDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月17日 下午6:59:14
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.WchatOctConfInfo;

/**
 * @ClassName WchatOctConfDao
 * @Description TODO【微信配置信息】
 * @Author brights
 * @Date 2014年10月17日 下午6:59:14
 */
public interface WchatOctConfDao extends BaseDao<WchatOctConfInfo, String> {
		
	/**
	* @Title findBySn
	* @Description TODO【依据sn查询对象】
	* @param sn
	* @return 
	* @Return WchatOctConfInfo 返回类型
	* @Throws 
	*/ 
	public  WchatOctConfInfo findBySn(String sn);

}
