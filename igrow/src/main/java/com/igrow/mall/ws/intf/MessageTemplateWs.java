/**
* @FileName MessageTemplateWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午4:08:53
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.entity.MessageTemplate;

/**
 * @ClassName MessageTemplateWs
 * @Description TODO【消息模板WS类】
 * @Author Brights
 * @Date 2013-10-28 下午4:08:53
 */
public interface MessageTemplateWs extends BaseWs<MessageTemplate, String> {
	
	/**
	* @Title findByCode
	* @Description TODO【依据编码获取模板】
	* @param code
	* @return 
	* @Return MessageTemplate 返回类型
	* @Throws 
	*/ 
	public MessageTemplate findByCode(String code);

}
