/**
* @FileName AreaAction.java
* @Package com.igrow.mall.web.action.admin
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-23 下午1:51:27
* @Version V1.0.1
*/
package com.igrow.mall.web.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.igrow.mall.bean.entity.Areas;
import com.igrow.mall.bean.entity.Cities;
import com.igrow.mall.service.admin.intf.AreaService;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName AreaAction
 * @Description TODO【area 控制器】
 * @Author Brights
 * @Date 2013-12-23 下午1:51:27
 */
@Namespace("/admin/area")
public class AreaAction extends BaseAction{
	private static final long serialVersionUID = 6720192373300695791L;
	
	@Resource(name = "areaServiceImpl")
	private AreaService areaService;
	
	/**
	* @Title findCitys
	* @Description TODO【依据省编号获取城市】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Action("findCitys")
	public String findCitys(){
		List array = new ArrayList();
		List<Cities> citys = areaService.findCitiesByProvinceSn(id);
		if(citys != null && citys.size() > 0){
			for(Cities city : citys){
				if(city != null){
					HashMap object = new HashMap();
					object.put("sn", city.getCitySn());
					object.put("name", city.getName());
					array.add(object);
				}
			}
		}
		return ajax(array);
	}
	
	/**
	* @Title findAreas
	* @Description TODO【依据城市编号获取区县】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Action("findAreas")
	public String findAreas(){
		List array = new ArrayList();
		List<Areas> areas = areaService.findAreasByCitySn(id);
		if(areas != null && areas.size() > 0){
			for(Areas area : areas){
				if(area != null){
					HashMap object = new HashMap();
					object.put("sn", area.getAreaSn());
					object.put("name", area.getName());
					array.add(object);
				}
			}
		}
		return ajax(array);
	}
	


}
