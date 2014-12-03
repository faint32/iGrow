/**
* @FileName DeceiverAddressDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:03:33
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import java.util.HashMap;

import com.igrow.mall.bean.entity.DeceiverAddressDetail;

/**
 * @ClassName DeceiverAddressDao
 * @Description TODO【收货地址Dao接口】
 * @Author Brights
 * @Date 2013-10-29 下午4:03:33
 */
public interface DeceiverAddressDao extends BaseDao<DeceiverAddressDetail, String> {
	
	/**
	* @Title findBySn
	* @Description TODO【依据编号查询对象】
	* @param memberSn
	* @return 
	* @Return MemberInfo 返回类型
	* @Throws 
	*/ 
	public DeceiverAddressDetail findBySn(String sn);
	
	/**
	* @Title findByMemberAndSn
	* @Description TODO【依据会员和地址sn查询对象】
	* @param values
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public DeceiverAddressDetail findByMemberAndSn(HashMap values);
	
	/**
	* @Title findDefaultByMember
	* @Description TODO【获取默认地址】
	* @param values
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public DeceiverAddressDetail findDefaultByMember(HashMap values);

}
