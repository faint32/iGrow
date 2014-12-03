/**
* @FileName WchatCustomServiceProcess.java
* @Package com.igrow.mall.service.wchat.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月18日 下午1:24:08
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName WchatCustomServiceProcess
 * @Description TODO【微信多客服】
 * @Author brights
 * @Date 2014年10月18日 下午1:24:08
 */
public interface WchatCustomServiceProcess {
	
	/**
	* @return 
	 * @Title getonlinekflist
	* @Description TODO【获取在线客服列表】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public List<HashMap<String, Object>> getonlinekflist(); 
	
	
}
