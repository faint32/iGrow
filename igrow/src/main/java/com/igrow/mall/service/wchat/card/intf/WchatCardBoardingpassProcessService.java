/**
* @FileName WchatCardBoardingpassProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:23:23
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardBoardingpassCheckinReq;
import com.igrow.mall.bean.card.response.WchatCardBoardingpassCheckinRes;

/**
 * @ClassName WchatCardBoardingpassProcessService
 * @Description TODO【微信卡券-飞机票】
 * @Author brights
 * @Date 2014年10月22日 下午3:23:23
 */
public interface WchatCardBoardingpassProcessService {
	
	/**
	* @Title checkin
	* @Description TODO【在线下选座】
	* @param req
	* @return 
	* @Return WchatCardBoardingpassCheckinRes 返回类型
	* @Throws 
	*/ 
	public WchatCardBoardingpassCheckinRes checkin(WchatCardBoardingpassCheckinReq req);

}
