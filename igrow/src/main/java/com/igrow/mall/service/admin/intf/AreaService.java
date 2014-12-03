/**
* @FileName AreaService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-29 下午2:19:02
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import java.util.List;

import com.igrow.mall.bean.entity.Areas;
import com.igrow.mall.bean.entity.Cities;
import com.igrow.mall.bean.entity.Provinces;

/**
 * @ClassName AreaService
 * @Description TODO【区域SERVICE接口】
 * @Author Brights
 * @Date 2013-10-29 下午2:19:02
 */
public interface AreaService extends BaseService<Areas, String> {
	
	
	/**
	* @Title findBySn
	* @Description TODO【依据区域编号查询区域对象】
	* @param sn
	* @return 
	* @Return Areas 返回类型
	* @Throws 
	*/ 
	public Areas findBySn(String sn);
	
	/**
	* @Title isExistBySn
	* @Description TODO【是否存在区域编号】
	* @param areaId
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean isExistBySn(String sn);
	
	/**
	* @Title findAreasByCitySn
	* @Description TODO【按城市查询区域】
	* @param citySn
	* @return 
	* @Return List<Areas> 返回类型
	* @Throws 
	*/ 
	public List<Areas> findAreasByCitySn(String citySn);
	
	/**
	* @Title findCitiesByProvinceSn
	* @Description TODO【按省查询城市】
	* @param provinceSn
	* @return 
	* @Return List<Cities> 返回类型
	* @Throws 
	*/ 
	public List<Cities> findCitiesByProvinceSn(String provinceSn);
	 
	/**
	* @Title findProvincesBy
	* @Description TODO【查询省】
	* @return 
	* @Return List<Provinces> 返回类型
	* @Throws 
	*/ 
	public List<Provinces> findProvincesBy();

}
