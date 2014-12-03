/**
* @FileName WchatCardCodeProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:14:18
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardCodeConsumeReq;
import com.igrow.mall.bean.card.request.WchatCardCodeEncryptReq;
import com.igrow.mall.bean.card.request.WchatCardCodeGetReq;
import com.igrow.mall.bean.card.request.WchatCardCodeUnavailableReq;
import com.igrow.mall.bean.card.request.WchatCardCodeUpdateReq;
import com.igrow.mall.bean.card.response.WchatCardCodeConsumeRes;
import com.igrow.mall.bean.card.response.WchatCardCodeEncryptRes;
import com.igrow.mall.bean.card.response.WchatCardCodeGetRes;
import com.igrow.mall.bean.card.response.WchatCardCodeUnavailableRes;
import com.igrow.mall.bean.card.response.WchatCardCodeUpdateRes;

/**
 * @ClassName WchatCardCodeProcessService
 * @Description TODO【微信卡券code处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:14:18
 */
public interface WchatCardCodeProcessService {
	
	/**
	* @Title consume
	* @Description TODO【卡券核销-消耗code】
	* @param req
	* @return 
	* @Return WchatCardCodeConsumeRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCodeConsumeRes consume(WchatCardCodeConsumeReq req);
	
	/**
	* @Title encrypt
	* @Description TODO【code解码】
	* @param req
	* @return 
	* @Return WchatCardCodeEncryptRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCodeEncryptRes encrypt(WchatCardCodeEncryptReq req);
	
	/**
	* @Title get
	* @Description TODO【code查询接口】
	* @param req
	* @return 
	* @Return WchatCardCodeGetRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCodeGetRes get(WchatCardCodeGetReq req);
	
	
	/**
	* @Title unavailable
	* @Description TODO【设置卡券失效】
	* @param req
	* @return 
	* @Return WchatCardCodeUnavailableRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCodeUnavailableRes unavailable(WchatCardCodeUnavailableReq req);
	
	/**
	* @Title update
	* @Description TODO【更改code】
	* @param req
	* @return 
	* @Return WchatCardCodeUpdateRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCodeUpdateRes update(WchatCardCodeUpdateReq req);
	
	

}
