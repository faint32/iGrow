/**
* @FileName WchatCardQrcodeProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:15:02
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardQrcodeCreateReq;
import com.igrow.mall.bean.card.response.WchatCardQrcodeCreateRes;

/**
 * @ClassName WchatCardQrcodeProcessService
 * @Description TODO【微信卡券二微码处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:15:02
 */
public interface WchatCardQrcodeProcessService {
	
	
	/**
	* @Title create
	* @Description TODO【创建二微码】
	* @return 
	* @Return WchatCardQrcodeCreateRes 返回类型
	* @Throws 
	*/ 
	public WchatCardQrcodeCreateRes create(WchatCardQrcodeCreateReq req);
}
