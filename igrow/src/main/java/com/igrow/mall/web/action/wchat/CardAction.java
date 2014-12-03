/**
* @FileName CardAction.java
* @Package com.igrow.mall.web.action.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午2:13:37
* @Version V1.0.1
*/
package com.igrow.mall.web.action.wchat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.igrow.mall.bean.card.jsapi.WchatJsapiBean;
import com.igrow.mall.bean.card.request.WchatCardCodeConsumeReq;
import com.igrow.mall.bean.card.request.WchatCardCodeEncryptReq;
import com.igrow.mall.bean.card.request.WchatCardGetReq;
import com.igrow.mall.bean.card.response.WchatCardCodeConsumeRes;
import com.igrow.mall.bean.card.response.WchatCardCodeEncryptRes;
import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.entity.WchatCardInfo;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.enums.SystemEnums.OperateStatus;
import com.igrow.mall.common.util.NumberUtils;
import com.igrow.mall.service.admin.intf.WchatCardInfoService;
import com.igrow.mall.service.admin.intf.WchatCardMemberService;
import com.igrow.mall.service.wchat.card.intf.WchatCardCodeProcessService;
import com.igrow.mall.service.wchat.card.intf.WchatCardProcessService;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName CardAction
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月24日 下午2:13:37
 */
@Namespace("/wchat/cd")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0504")
})
public class CardAction extends BaseAction{
	private static final long serialVersionUID = 2892709060001635474L;
	@Resource(name = "wchatCardCodeProcessServiceImpl")
	private WchatCardCodeProcessService wchatCardCodeProcessService;
	@Resource(name = "wchatCardProcessServiceImpl")
	private WchatCardProcessService wchatCardProcessService;
	
	@Resource(name = "wchatCardInfoServiceImpl")
	private WchatCardInfoService 	wchatCardInfoService;
	@Resource(name = "wchatCardMemberServiceImpl")
	private WchatCardMemberService wchatCardMemberService;
	
	private String code;  //code
	
	private String openid;  //用户openid
	private String amt;//金额


	/**
	* @Title list
	* @Description TODO【优惠券列表】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(LIST)
	public String list(){
		
		return JSONPG;
	}
	
	/**
	* @Title detail
	* @Description TODO【优惠券详情】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action(DETAIL)
	public String detail(){
		WchatCardGetReq req = new WchatCardGetReq();
		id = "pVE3-smVFiHgoI2L41VLw9UCrueo";
		req.setCardId(id);
		WchatCardGetRes res = wchatCardProcessService.get(req);
		if(res != null){
			
		}else{
			
		}
		return JSONPG;
	}
	
	/**
	* @Title info
	* @Description TODO【返回优惠券减免信息】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("info")
	public String info(){
		Map<String, String> jsonMap = new HashMap<String, String>();
		WchatCardInfo  cardInfo = wchatCardInfoService.findByCardId(id);
		if(cardInfo != null){
			jsonMap.put("titel",cardInfo.getCardTitle() );  //优惠券标题名称
			jsonMap.put("reduce", NumberUtils.currencyFormat(cardInfo.getReduceCost(), 2, "", ""));   //优惠券减免金额 
			if(cardInfo.getLeastCost() != null){
				jsonMap.put("least", NumberUtils.currencyFormat(cardInfo.getLeastCost(), 2, "", ""));   //起用金额 0元
			}
			jsonMap.put("status", OperateStatus.SUCCESS.getStatus());  //成功
			jsonMap.put("message", OperateStatus.SUCCESS.getMessage());
		}else{
			jsonMap.put("status", OperateStatus.ERROR.getStatus());   //失败
			jsonMap.put("message", OperateStatus.ERROR.getMessage());
		}
		return ajax(jsonMap);
	}
	
	/**
	* @Title isCard
	* @Description TODO【是否存在可用的优惠券】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("iscard")
	public String isCard(){
		Map<String, String> jsonMap = new HashMap<String, String>();
		BigDecimal amount = null;
		if(StringUtils.isNotBlank(amt)){
			 amount = new BigDecimal(amt);
		}else{
			amount = new BigDecimal(0);
		}
		Date now = new Date();
		Long timeStamp =  now.getTime()/1000;
		boolean isCard = wchatCardMemberService.isCardByOpenId(openid, amount);
		if(isCard){
			jsonMap.put("isCard","1" );  //是否存在可用的优惠券1-存在，0-不存在
			jsonMap.put("appId", WchatConstant.wchat_appid);   
			jsonMap.put("cardSign", WchatJsapiBean.getWchatChooseCardSignature(timeStamp));   
			jsonMap.put("timeStamp", timeStamp.toString());   
		}else{
			jsonMap.put("isCard","0");   //是否存在可用的优惠券1-存在，0-不存在
			jsonMap.put("appId", WchatConstant.wchat_appid);   
			jsonMap.put("cardSign", WchatJsapiBean.getWchatChooseCardSignature(timeStamp));   
			jsonMap.put("timeStamp", timeStamp.toString());   
		}
		return ajax(jsonMap);
	}
	
	/**
	* @Title encryptCode
	* @Description TODO【code解码】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("encrypt")
	public String encryptCode(){
		WchatCardCodeEncryptReq req = new WchatCardCodeEncryptReq();
		if(StringUtils.isBlank(code)){
			return ajax(OperateStatus.ERROR,"操作失败:code不能为空");
		}
		req.setEncryptCode(code);
		WchatCardCodeEncryptRes res = wchatCardCodeProcessService.encrypt(req);
		if(res != null ){
			if(res.getErrcode()  == 0){
				return ajax(OperateStatus.SUCCESS,"操作成功!",res.getCode());
			}else{
				return ajax(OperateStatus.ERROR,"操作失败:"+res.getErrmsg());
			}
		}
		return ajax(OperateStatus.ERROR,"操作失败!");
	}
	
	/**
	* @Title encryptCode
	* @Description TODO【code核销】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("consume")
	public String consumeCode(){
		WchatCardCodeConsumeReq req = new  WchatCardCodeConsumeReq();
		if(StringUtils.isBlank(code)){
			return ajax(OperateStatus.ERROR,"操作失败:code不能为空");
		}
		req.setCode(code);
		if(StringUtils.isNotBlank(id)){
			req.setCardId(id);
		}
		WchatCardCodeConsumeRes  res = wchatCardCodeProcessService.consume(req);
		if(res != null ){
			if(res.getErrcode()  == 0){
				return ajax(OperateStatus.SUCCESS,"操作成功!");
			}else{
				return ajax(OperateStatus.ERROR,"操作失败:"+res.getErrmsg());
			}
		}
		return ajax(OperateStatus.ERROR,"操作失败!");
	}
	

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the amt
	 */
	public String getAmt() {
		return amt;
	}

	/**
	 * @param amt the amt to set
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
