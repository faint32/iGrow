/**
* @FileName WchatCardMovieticketProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:22:16
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardMovieticketUpdateuserReq;
import com.igrow.mall.bean.card.response.WchatCardMovieticketUpdateuserRes;

/**
 * @ClassName WchatCardMovieticketProcessService
 * @Description TODO【微信卡券-电影票处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:22:16
 */
public interface WchatCardMovieticketProcessService {
	
	/**
	* @Title updateuser
	* @Description TODO【更新电影票】
	* @param req
	* @return 
	* @Return WchatCardMovieticketUpdateuserRes 返回类型
	* @Throws 
	*/ 
	public WchatCardMovieticketUpdateuserRes updateuser(WchatCardMovieticketUpdateuserReq req);
}
