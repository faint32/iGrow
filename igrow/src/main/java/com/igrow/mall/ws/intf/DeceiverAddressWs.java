/**
* @FileName DeceiverAddressWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:04:34
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import java.util.HashMap;
import java.util.List;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.entity.DeceiverAddressDetail;

/**
 * @ClassName DeceiverAddressWs
 * @Description TODO【收货地址WS接口】
 * @Author Brights
 * @Date 2013-10-29 下午4:04:34
 */
public interface DeceiverAddressWs extends BaseWs<DeceiverAddressDetail, String> {
	
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
	* @Title isExistBySn
	* @Description TODO【是否存在编号对象】
	* @param sn
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean isExistBySn(String sn);
	
	/**
	* @Title findByMemberAndSn
	* @Description TODO【依据会员和地址ID查询对象】
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
	
	/**
	* @Title findListByPager
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param pager
	* @param values
	* @return 
	* @Return List<DeceiverAddressDetail> 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public List<DeceiverAddressDetail> findListByPager(Pager pager,HashMap values);
	
}
