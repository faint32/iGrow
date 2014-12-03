/**
* @FileName WchatCardMembercardProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:19:58
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardMembercardActivateReq;
import com.igrow.mall.bean.card.request.WchatCardMembercardUpdateuserReq;
import com.igrow.mall.bean.card.response.WchatCardMembercardActivateRes;
import com.igrow.mall.bean.card.response.WchatCardMembercardUpdateuserRes;

/**
 * @ClassName WchatCardMembercardProcessService
 * @Description TODO【微信卡券-会员卡处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:19:58
 */
public interface WchatCardMembercardProcessService {
	
	/**
	* @Title activate
	* @Description TODO【会员卡激活】
	* @param req
	* @return 
	* @Return WchatCardMembercardActivateRes 返回类型
	* @Throws 
	*/ 
	public WchatCardMembercardActivateRes activate(WchatCardMembercardActivateReq req);
	
	/**
	* @Title updateuser
	* @Description TODO【会员卡-会员卡交易】
	* @param req
	* @return 
	* @Return WchatCardMembercardUpdateuserRes 返回类型
	* @Throws 
	*/ 
	public WchatCardMembercardUpdateuserRes updateuser(WchatCardMembercardUpdateuserReq req);
}
