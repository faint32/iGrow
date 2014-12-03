/**
* @FileName DeceiverAddressService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:10:22
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import java.util.List;

import com.igrow.mall.bean.entity.DeceiverAddressDetail;
import com.igrow.mall.bean.vo.AddressVo;

/**
 * @ClassName DeceiverAddressService
 * @Description TODO【收货地址Service接口】
 * @Author Brights
 * @Date 2013-10-29 下午4:10:22
 */
public interface DeceiverAddressService extends BaseService<DeceiverAddressDetail, String> {
	
	/**
	* @Title addAddress
	* @Description TODO【添加收货地址】
	* @param memberSn 会员编号
	* @param name  收货联系人
	* @param areaSn 区域编号
	* @param address 收货地址
	* @param mobile 联系手机号码
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	public DeceiverAddressDetail addAddress(String memberSn,String name,String areaSn,String address,String mobile);
	
 
	/**
	* @Title editAddress
	* @Description TODO【修改地址】
	* @param DeceiverAddress
	* @param name
	* @param areaSn
	* @param address
	* @param mobile
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	public DeceiverAddressDetail editAddress(DeceiverAddressDetail deceiverAddress,String name,String areaSn,String address,String mobile);
	
	/**
	* @Title deleteAddress
	* @Description TODO【删除地址】
	* @param addressSn 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void deleteAddress(String memberSn,String addressSn);
	
	/**
	* @Title findByMemberSnAndaddressId
	* @Description TODO【查询】
	* @param memberSn
	* @param addressSn
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	public DeceiverAddressDetail findByMemberSnAndaddressSn(String memberSn,String addressSn);
	
	/**
	* @Title findDefaultByMemberSn
	* @Description TODO【查询默认收货地址】
	* @param memberSn
	* @param addressSn
	* @return 
	* @Return DeceiverAddressDetail 返回类型
	* @Throws 
	*/ 
	public DeceiverAddressDetail findDefaultByMemberSn(String memberSn);
	
	public List<AddressVo> findAressVoListByMemberSn(String memberSn,int curPage);
}
