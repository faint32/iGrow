/**
* @FileName WchatOctCustomSendService.java
* @Package com.igrow.mall.service.admin.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 上午10:44:40
* @Version V1.0.1
*/
package com.igrow.mall.service.admin.intf;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;

/**
 * @ClassName WchatOctCustomSendService
 * @Description TODO【微信客服发送消息记录】
 * @Author brights
 * @Date 2014年10月18日 上午10:44:40
 */
public interface WchatOctCustomSendService extends BaseService<WchatOctCustomSendDetail, String> {
	
	/**
	* @Title findLastBy
	* @Description TODO【获取最后一调记录】
	* @param operId
	* @return 
	* @Return WchatOctCustomSendDetail 返回类型
	* @Throws 
	*/ 
	public WchatOctCustomSendDetail findLastBy(String operId);

}
