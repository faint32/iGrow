/**
* @FileName DeceiverAddressServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:11:19
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.Areas;
import com.igrow.mall.bean.entity.DeceiverAddressDetail;
import com.igrow.mall.bean.vo.AddressVo;
import com.igrow.mall.service.admin.intf.DeceiverAddressService;
import com.igrow.mall.ws.intf.AreaWs;
import com.igrow.mall.ws.intf.DeceiverAddressWs;

/**
 * @ClassName DeceiverAddressServiceImpl
 * @Description TODO【收货地址Service接口实现】
 * @Author Brights
 * @Date 2013-10-29 下午4:11:19
 */
@Service("deceiverAddressServiceImpl")
public class DeceiverAddressServiceImpl extends BaseServiceImpl<DeceiverAddressDetail, String>
		implements DeceiverAddressService {
	@Resource(name = "deceiverAddressWsImpl")
	private DeceiverAddressWs deceiverAddressWs;
	@Resource(name = "deceiverAddressWsImpl")
	public void setBaseWs(DeceiverAddressWs deceiverAddressWs) {
		super.setBaseWs(deceiverAddressWs);
	}
/*	@Resource(name = "memberWsImpl")
	private MemberWs memberWs;*/
	@Resource
	private AreaWs areaWs;
	
	
	@Override
	public DeceiverAddressDetail addAddress(String memberSn, String name,
			String areaSn, String address, String mobile) {
		//MemberInfo member = memberWs.findBySn(memberSn);
		//Areas area = areaWs.findBySn(areaSn);
		/*if(member != null && area != null){
			if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(address) && StringUtils.isNotBlank(mobile) ){
				StringBuffer areaName = new StringBuffer();
				areaName.append(area.getCity().getProvince().getName());
				areaName.append(area.getCity().getName());
				areaName.append(area.getName());
				DeceiverAddressDetail entity = new DeceiverAddressDetail();
				entity.setAddress(address);
				entity.setMember(member);
				entity.setAreaSn(area.getAreaSn());
				entity.setAreaName(areaName.toString());
				entity.setMobile(mobile);
				entity.setPhone(mobile);
				entity.setName(name);
				deceiverAddressWs.insert(entity);
				return entity;
			}
		}*/
		return null;
	}


	@Override
	public  DeceiverAddressDetail editAddress(DeceiverAddressDetail deceiverAddress,String name,String areaSn,String address,String mobile) {
		if(deceiverAddress != null){
			DeceiverAddressDetail entity = deceiverAddressWs.find(deceiverAddress.getId());
			if(entity != null){
				Areas area = areaWs.findBySn(areaSn);
				if(area != null){
					if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(address)&&StringUtils.isNotBlank(mobile) ){
						StringBuffer areaName = new StringBuffer();
						areaName.append(area.getCity().getProvince().getName());
						areaName.append(area.getCity().getName());
						areaName.append(area.getName());
						entity.setAddress(address);
						entity.setAreaSn(area.getAreaSn());
						entity.setAreaName(areaName.toString());
						entity.setMobile(mobile);
						entity.setPhone(mobile);
						entity.setName(name);
						deceiverAddressWs.update(entity);
						return entity;
					}
				}
			}
		}
		return null;
	}


	@Override
	public void deleteAddress(String memberSn,String addressSn) {
		if(StringUtils.isNotBlank(memberSn) && StringUtils.isNotBlank(addressSn)){
			/*MemberInfo member = memberWs.findBySn(memberSn);
			if(member != null){
				HashMap values = new HashMap();
				values.put("member", member);
				values.put("addressSn", addressSn);
				DeceiverAddressDetail entity = deceiverAddressWs.findByMemberAndSn(values);
				if(entity != null){
					deceiverAddressWs.delete(entity);
				}
			}*/
		}
	}


	@Override
	public DeceiverAddressDetail findByMemberSnAndaddressSn(String memberSn,
			String addressSn) {
		if(StringUtils.isNotBlank(memberSn) && StringUtils.isNotBlank(addressSn)){
			/*MemberInfo member = memberWs.findBySn(memberSn);
			if(member != null){
				HashMap values = new HashMap();
				values.put("member", member);
				values.put("addressSn", addressSn);
				DeceiverAddressDetail entity = deceiverAddressWs.findByMemberAndSn(values);
				if(entity != null){
					return entity;
				}
			}*/
		}
		return null;
	}


	@Override
	public DeceiverAddressDetail findDefaultByMemberSn(String memberSn) {
		if(StringUtils.isNotBlank(memberSn)){
			/*MemberInfo member = memberWs.findBySn(memberSn);
			if(member != null ){
				HashMap values = new HashMap();
				values.put("member", member);
				DeceiverAddressDetail entity = deceiverAddressWs.findDefaultByMember(values);
				if(entity != null){
					return entity;
				}else{
					return deceiverAddressWs.findByMemberAndSn(values);
				}
			}*/
		}
		return null;
	}


	@Override
	public List<AddressVo> findAressVoListByMemberSn(String memberSn,
			int curPage) {
		List<AddressVo> addressVos = new ArrayList<AddressVo>();
		/*MemberInfo member = memberWs.findBySn(memberSn);
		if(member != null ){
			HashMap values = new HashMap();
			values.put("member", member);
			Pager pager = new Pager();
			pager.setOrder(Order.desc);
			pager.setOrderBy(SystemConstants.MODIFY_DATE_FIELD);
			pager.setPageNumber(curPage + 1);
			List<DeceiverAddressDetail> deceiverAddresss = deceiverAddressWs.findListByPager(pager,values);
			if(deceiverAddresss != null && deceiverAddresss.size() > 0){
				for(DeceiverAddressDetail deceiverAddress : deceiverAddresss){
					if(deceiverAddress != null){
						AddressVo addressVo = new AddressVo();
						addressVo.setAddress(deceiverAddress.getAddress());
						addressVo.setAreaId(deceiverAddress.getAreaSn());
						addressVo.setId(deceiverAddress.getAddressSn());
						addressVo.setMobile(deceiverAddress.getMobile());
						addressVo.setName(deceiverAddress.getName());
						addressVos.add(addressVo);
					}
				}
			}
		}*/
		return addressVos;
	}

}
