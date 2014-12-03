/**
* @FileName WchatCardLuckymoneyProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:19:04
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardLuckymoneyUpdateuserbalanceReq;
import com.igrow.mall.bean.card.response.WchatCardLuckymoneyUpdateuserbalanceRes;

/**
 * @ClassName WchatCardLuckymoneyProcessService
 * @Description TODO【微信卡券红包处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:19:04
 */
public interface WchatCardLuckymoneyProcessService {
	
	/**
	* @Title updateuserbalance
	* @Description TODO【更新红包金额】
	* @param req
	* @return 
	* @Return WchatCardLuckymoneyUpdateuserbalanceReq 返回类型
	* @Throws 
	*/ 
	public WchatCardLuckymoneyUpdateuserbalanceRes updateuserbalance(WchatCardLuckymoneyUpdateuserbalanceReq req);

}
