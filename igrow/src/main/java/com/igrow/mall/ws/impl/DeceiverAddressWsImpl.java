/**
* @FileName DeceiverAddressWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午4:05:57
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.entity.DeceiverAddressDetail;
import com.igrow.mall.dao.mybatis.intf.DeceiverAddressDao;
import com.igrow.mall.ws.intf.DeceiverAddressWs;

/**
 * @ClassName DeceiverAddressWsImpl
 * @Description TODO【收货地址WS接口实现】
 * @Author Brights
 * @Date 2013-10-29 下午4:05:57
 */
@Service("deceiverAddressWsImpl")
public class DeceiverAddressWsImpl extends BaseWsImpl<DeceiverAddressDetail, String> implements
		DeceiverAddressWs {
	@Resource(name = "deceiverAddressDao")
	private DeceiverAddressDao deceiverAddressDao;

	@Resource(name = "deceiverAddressDao")
	public void setBaseDao(DeceiverAddressDao deceiverAddressDao) {
		super.setBaseDao(deceiverAddressDao);
	}

	/**
	* @Title save
	* @Description 
	* @param entity
	* @return
	* @see com.igrow.mall.ws.impl.BaseWsImpl#save(java.lang.Object)
	*/ 
	@Override
	public DeceiverAddressDetail save(DeceiverAddressDetail entity) {
		if(entity != null ) {
			DeceiverAddressDetail deceiverAddress = deceiverAddressDao.find(entity.getId());
			if(deceiverAddress == null){
				super.insert(entity);
			}else{
				super.update(entity);
			}
		}
		return entity;
	}

	@Override
	public DeceiverAddressDetail findBySn(String sn) {
		return deceiverAddressDao.findBySn(sn);
	}
	
	@Override
	public boolean isExistBySn(String sn) {
		DeceiverAddressDetail entity = deceiverAddressDao.findBySn(sn);
		if(entity != null){
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public DeceiverAddressDetail findByMemberAndSn(HashMap values) {
		return deceiverAddressDao.findByMemberAndSn(values);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public DeceiverAddressDetail findDefaultByMember(HashMap values) {
		return deceiverAddressDao.findDefaultByMember(values);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DeceiverAddressDetail> findListByPager(Pager pager,
			HashMap values) {
		Long count = deceiverAddressDao.getCountBy(values);
		pager.setTotalCount(count);
		if(count > 0){
			if(pager.getPageNumber() > pager.getPageCount()){
				return null;
			}
			if(pager.getPageNumber() < 1){
				return null;
			}
			values.put("firstIndex",pager.getFirstIndex());
			values.put("pageSize",pager.getPageSize());
			values.put("orderBy", pager.getOrderBy());
			values.put("order", pager.getOrder());
			//查询记录
			return deceiverAddressDao.findListBy(values);
		}
		return null;
	}



	
	
}
