/**
* @FileName WchatCardTestwhitelistProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:17:08
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardTestwhitelistSetReq;
import com.igrow.mall.bean.card.response.WchatCardTestwhitelistSetRes;

/**
 * @ClassName WchatCardTestwhitelistProcessService
 * @Description TODO【微信测试开发者权限-设置白名单服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:17:08
 */
public interface WchatCardTestProcessService {

	/**
	* @Title whitelistSet
	* @Description TODO【设置测试白名单列表】
	* @param req
	* @return 
	* @Return WchatCardTestwhitelistSetRes 返回类型
	* @Throws 
	*/ 
	public WchatCardTestwhitelistSetRes whitelistSet(WchatCardTestwhitelistSetReq req);
}
