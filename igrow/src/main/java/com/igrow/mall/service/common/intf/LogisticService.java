/**
* @FileName LogisticService.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-1 下午1:51:39
* @Version V1.0.1
*/
package com.igrow.mall.service.common.intf;

import com.igrow.mall.bean.vo.LogisticsListVo;

/**
 * @ClassName LogisticService
 * @Description TODO【快递服务接口】
 * @Author Brights
 * @Date 2013-11-1 下午1:51:39
 */
public interface LogisticService {
	
	/**
	* @Title findByOrderSn
	* @Description TODO【依据订单号查询快递配送记录】
	* @param orderSn
	* @param memberSn
	* @return 
	* @Return LogisticsListVo 返回类型
	* @Throws 
	*/ 
	public LogisticsListVo findByOrderSn(String orderSn,String memberSn) throws Exception;
}
