/**
* @FileName AreaServiceImpl.java
* @Package com.igrow.mall.service.admin.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午2:19:53
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.igrow.mall.bean.entity.Areas;
import com.igrow.mall.bean.entity.Cities;
import com.igrow.mall.bean.entity.Provinces;
import com.igrow.mall.service.admin.intf.AreaService;
import com.igrow.mall.ws.intf.AreaWs;

/**
 * @ClassName AreaServiceImpl
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-29 下午2:19:53
 */
@Service("areaServiceImpl")
public class AreaServiceImpl extends BaseServiceImpl<Areas, String> implements
		AreaService {
	
	@Resource(name = "areaWsImpl")
	private AreaWs areaWs;

	@Resource(name = "areaWsImpl")
	public void setBaseWs(AreaWs areaWs) {
		super.setBaseWs(areaWs);
	}

	@Override
	public Areas findBySn(String sn) {
		return areaWs.findBySn(sn);
	}

	@Override
	public boolean isExistBySn(String sn) {
		return areaWs.isExistBySn(sn);
	}

	@Override
	public List<Areas> findAreasByCitySn(String citySn) {
		return areaWs.findAreasByCitySn(citySn);
	}

	@Override
	public List<Cities> findCitiesByProvinceSn(String provinceSn) {
		return areaWs.findCitiesByProvinceSn(provinceSn);
	}

	@Override
	public List<Provinces> findProvincesBy() {
		return areaWs.findProvincesBy();
	}
	
	
}
