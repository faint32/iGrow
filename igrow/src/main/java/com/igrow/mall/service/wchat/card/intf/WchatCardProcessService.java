/**
* @FileName WchatCardProcessService.java
* @Package com.igrow.mall.service.wchat.card.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午3:10:58
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.intf;

import com.igrow.mall.bean.card.request.WchatCardBatchgetReq;
import com.igrow.mall.bean.card.request.WchatCardCreateReq;
import com.igrow.mall.bean.card.request.WchatCardDeleteReq;
import com.igrow.mall.bean.card.request.WchatCardGetReq;
import com.igrow.mall.bean.card.request.WchatCardGetcolorsReq;
import com.igrow.mall.bean.card.request.WchatCardUpdateReq;
import com.igrow.mall.bean.card.response.WchatCardBatchgetRes;
import com.igrow.mall.bean.card.response.WchatCardCreateRes;
import com.igrow.mall.bean.card.response.WchatCardDeleteRes;
import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.card.response.WchatCardGetcolorsRes;
import com.igrow.mall.bean.card.response.WchatCardUpdateRes;

/**
 * @ClassName WchatCardProcessService
 * @Description TODO【微信卡券处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午3:10:58
 */
public interface WchatCardProcessService {
	 
	/**
	* @Title create
	* @Description TODO【创建卡券】
	* @param req
	* @return 
	* @Return WchatCardCreateRes 返回类型
	* @Throws 
	*/ 
	public WchatCardCreateRes create(WchatCardCreateReq req);
	
	/**
	* @Title delete
	* @Description TODO【删除卡券】
	* @param req
	* @return 
	* @Return WchatCardDeleteRes 返回类型
	* @Throws 
	*/ 
	public WchatCardDeleteRes delete(WchatCardDeleteReq req);
	
	/**
	* @Title update
	* @Description TODO【更改卡券信息】
	* @param req
	* @return 
	* @Return WchatCardUpdateRes 返回类型
	* @Throws 
	*/ 
	public WchatCardUpdateRes update(WchatCardUpdateReq req);
	
	/**
	* @Title getcolors
	* @Description TODO【获取颜色列表】
	* @param req
	* @return 
	* @Return WchatCardGetcolorsRes 返回类型
	* @Throws 
	*/ 
	public WchatCardGetcolorsRes getcolors(WchatCardGetcolorsReq req);
	
	/**
	* @Title get
	* @Description TODO【查询卡券详情】
	* @param req
	* @return 
	* @Return WchatCardGetRes 返回类型
	* @Throws 
	*/ 
	public WchatCardGetRes get(WchatCardGetReq req);
	
	/**
	* @Title batchget
	* @Description TODO【批量查询卡列表】
	* @param req
	* @return 
	* @Return WchatCardBatchgetRes 返回类型
	* @Throws 
	*/ 
	public WchatCardBatchgetRes batchget(WchatCardBatchgetReq req);
	
	
	
	
}
