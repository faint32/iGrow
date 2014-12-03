/**
* @FileName WchatCustomProcess.java
* @Package com.igrow.mall.service.wchat.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 下午12:06:07
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;

/**
 * @ClassName WchatCustomProcess
 * @Description TODO【微信客服接口】
 * @Author brights
 * @Date 2014年10月18日 下午12:06:07
 */
public interface WchatCustomProcess {
	
	/**
	* @Title send
	* @Description TODO【发送客服信息】
	* @param sendInfo
	* @return
	* @throws Exception 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean send(WchatOctCustomSendDetail sendInfo) throws Exception;
}
