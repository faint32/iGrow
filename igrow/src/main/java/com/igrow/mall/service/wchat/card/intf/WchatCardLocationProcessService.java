/**
* @FileName WchatCardLocationProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:12:00
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardLocationBatchaddReq;
import com.igrow.mall.bean.card.request.WchatCardLocationBatchgetReq;
import com.igrow.mall.bean.card.response.WchatCardLocationBatchaddRes;
import com.igrow.mall.bean.card.response.WchatCardLocationBatchgetRes;

/**
 * @ClassName WchatCardLocationProcessService
 * @Description TODO【微信卡券门店处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:12:00
 */
public interface WchatCardLocationProcessService {
	
	/**
	* @Title batchadd
	* @Description TODO【批量添加门店】 
	* @param req
	* @return 
	* @Return WchatCardLocationBatchaddRes 返回类型
	* @Throws 
	*/ 
	public WchatCardLocationBatchaddRes batchadd(WchatCardLocationBatchaddReq req);
	
	/**
	* @Title batchget
	* @Description TODO【批量获取门店】 
	* @param req
	* @return 
	* @Return WchatCardLocationBatchgetRes 返回类型
	* @Throws 
	*/ 
	public WchatCardLocationBatchgetRes batchget(WchatCardLocationBatchgetReq req);
}
