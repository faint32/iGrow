/**
* @FileName AreaWsImpl.java
* @Package com.igrow.mall.ws.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午2:13:31
* @Version V1.0.1
*/
package com.igrow.mall.ws.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.Areas;
import com.igrow.mall.bean.entity.Cities;
import com.igrow.mall.bean.entity.Provinces;
import com.igrow.mall.dao.mybatis.intf.AreaDao;
import com.igrow.mall.dao.mybatis.intf.CityDao;
import com.igrow.mall.dao.mybatis.intf.ProvinceDao;
import com.igrow.mall.ws.intf.AreaWs;

/**
 * @ClassName AreaWsImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-29 下午2:13:31
 */
@Service("areaWsImpl")
public class AreaWsImpl extends BaseWsImpl<Areas, String> implements AreaWs {
	@Resource(name = "areaDao")
	private AreaDao areaDao;
	@Resource(name = "areaDao")
	public void setBaseDao(AreaDao areaDao) {
		super.setBaseDao(areaDao);
	}
	@Resource(name = "provinceDao")
	private ProvinceDao provinceDao;
	@Resource(name = "cityDao")
	private CityDao cityDao;
	
	@Override
	public Areas findBySn(String sn) {
		return areaDao.findBySn(sn);
	}

	@Override
	public boolean isExistBySn(String sn) {
		Areas area = areaDao.findBySn(sn);
		System.out.println();
		if(area != null){
			return true;
		}
		return false;
	}

	@Override
	public List<Areas> findAreasByCitySn(String citySn) {
		Cities city = cityDao.findBySn(citySn);
		if(city != null){
			return city.getAreas();
		}
		return null;
	}

	@Override
	public List<Cities> findCitiesByProvinceSn(String provinceSn) {
		Provinces province = provinceDao.findBySn(provinceSn);
		if(province != null){
			return province.getCities();
		}
		return null;
	}

	@Override
	public List<Provinces> findProvincesBy() {
		return provinceDao.findAllList();
	}
	
}
