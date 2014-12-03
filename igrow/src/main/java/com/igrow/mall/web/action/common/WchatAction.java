/**
* @FileName WchatAction.java
* @Package com.igrow.mall.web.action.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 上午10:25:16
* @Version V1.0.1
*/
package com.igrow.mall.web.action.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.igrow.mall.bean.entity.WchatOctConfInfo;
import com.igrow.mall.common.enums.SystemEnums.OperateStatus;
import com.igrow.mall.common.enums.wchat.Wevent;
import com.igrow.mall.common.enums.wchat.WmsgType;
import com.igrow.mall.common.wchat.WchatRequestBean;
import com.igrow.mall.common.wchat.XmlUtil;
import com.igrow.mall.service.admin.intf.WchatOctConfService;
import com.igrow.mall.service.wchat.intf.WchatContentService;
import com.igrow.mall.service.wchat.intf.WchatOauthProcess;
import com.igrow.mall.web.action.core.BaseAction;

/**
 * @ClassName WchatAction
 * @Description TODO【微信数据处理】
 * @Author brights
 * @Date 2014年10月14日 上午10:25:16
 */
@Namespace("/common")
@Results({
	@Result(name = "reload", type = "redirect",  location = "list.do?idx=0504")
})
public class WchatAction extends BaseAction  {
	private static final long serialVersionUID = 2695007891829396971L;
	private static final String wchat_oauthdeal_url_sn = "9900" ; //请勿修改
	
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	
	private String code;
	private String state;
	private String osn; //跳转获取地址
	private String isoa; //是否鉴权
	
	
	@Resource(name ="wchatContentServiceImpl")
	private WchatContentService wchatContentService;
	@Resource(name ="wchatOauthProcessImpl")
	private WchatOauthProcess wchatOauthProcess;
	@Resource(name = "wchatOctConfServiceImpl")
	private WchatOctConfService wchatOctConfService;
	
	@Action("wchat")
	public String index(){
		if(!StringUtils.isNotBlank(echostr)){
			String xml = "";
	    	try {
				//String userAgent = request.getHeader("user-agent");
				xml = IOUtils.toString(request.getInputStream(),"utf-8");
				System.out.println(xml);
				WchatRequestBean wchatRequest = XmlUtil.toBean(xml,WchatRequestBean.class);
				System.out.println(wchatRequest.getMsgType());
				System.out.println(wchatRequest.getEvent());
				if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.TEXT.getDesc())){ //接收文本消息
					xml = wchatContentService.text(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.IMAGE.getDesc())){ //图片消息
					xml = wchatContentService.image(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.VOICE.getDesc())){ //语音消息
					xml = wchatContentService.voice(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.VIDEO.getDesc())){ //视频消息
					xml = wchatContentService.video(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.LOCATION.getDesc())){ //地理位置消息
					xml = wchatContentService.locationMt(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.LINK.getDesc())){ //链接消息
					xml = wchatContentService.link(wchatRequest);
				}else if(wchatRequest.getMsgType().equalsIgnoreCase(WmsgType.EVENT.getDesc())){ //事件
					if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.SUBSCRIBE.getDesc())){ //订阅事件；扫描带参数二维码事件 1. 用户未关注时，进行关注后的事件推送
						xml = wchatContentService.subscribe(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.UNSUBSCRIBE.getDesc())){ //取消订阅
						xml = wchatContentService.unsubscribe(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.SCAN.getDesc())){ //扫描带参数二维码事件，2用户已关注时的事件推送
						xml = wchatContentService.scan(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.LOCATION.getDesc())){ //上报地理位置事件
						//xml = wchatContentService.locationEn(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.CLICK.getDesc())){ //点击菜单拉取消息时的事件推送 
						xml = wchatContentService.click(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.VIEW.getDesc())){ //点击菜单跳转链接时的事件推送 
						xml = wchatContentService.view(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.SCANCODE_PUSH.getDesc())){ ////菜单扫码推事件
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.SCANCODE_WAITMSG.getDesc())){  //菜单扫码推事件且弹出“消息接收中”提示框
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.PIC_SYSPHOTO.getDesc())){  //菜单-弹出系统拍照发图
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.PIC_PHOTO_OR_ALBUM.getDesc())){  //菜单-//弹出拍照或者相册发图
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.PIC_WEIXIN.getDesc())){  //菜单-//弹出微信相册发图器
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.LOCATION_SELECT.getDesc())){  //菜单-//弹出地理位置选择器
						xml = "";
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.CARD_PASS_CHECK.getDesc())){  // //卡券通过审核时，审核通过事件推送
						xml = wchatContentService.cardPassCheck(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.CARD_NOT_PASS_CHECK.getDesc())){  // //卡券通过审核时，审核通未过事件推送
						xml = wchatContentService.cardNotPassCheck(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.USER_GET_CARD.getDesc())){  // //卡券通过审核时，领取卡券事件推送
						xml = wchatContentService.userGetCard(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.USER_DEL_CARD.getDesc())){  // //卡券通过审核时，删除卡券事件推送
						xml = wchatContentService.userDelCard(wchatRequest);
					}else if(wchatRequest.getEvent().equalsIgnoreCase(Wevent.TEMPLATE_SEND_JOB_FINISH.getDesc())){  // //模版消息发送任务完成，事件推送
						xml = wchatContentService.templateSendJobFinish(wchatRequest);
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			super.setJsonText(xml);
			return JSONPG;
		}else{
			super.setJsonText(echostr);
			return JSONPG;
		}
	}
	
	/**
	* @Title oauth
	* @Description TODO【授权回调页面】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("oauth")
	public String oauth(){
		if(StringUtils.isNotBlank(code) ){
			String opernId = wchatOauthProcess.getOauthAccessTokenOpenId(code);
			if(StringUtils.isNotBlank(opernId) ){
				return ajax(OperateStatus.SUCCESS,"操作成功!",opernId);
			}
		}
		return ajax(OperateStatus.ERROR,"操作失败");
	}
	
	/**
	* @Title waitOauth
	* @Description TODO【生成鉴权地址】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("woauth")
	public String waitOauth(){
		if(StringUtils.isNotBlank(osn)){ //进行鉴权地址配置编号，不能为空
			if(StringUtils.isNotBlank(isoa) && isoa.equals("1") ){ //isoa=1,进行微信客户端鉴权
				WchatOctConfInfo  woc = wchatOctConfService.findBySn(wchat_oauthdeal_url_sn);
				redirectUrl = woc.getValue();
				 String queryStr = getRequest().getQueryString();
				 if(StringUtils.isNotBlank(queryStr)){
					 redirectUrl = redirectUrl + "?" + queryStr;
				 }
				 redirectUrl = wchatOauthProcess.generateOauthUrl(redirectUrl, String.valueOf(System.currentTimeMillis()));  //生成鉴权请求地址
			}else{ //不进行鉴权处理，直接调用默认地址
				WchatOctConfInfo  woc = wchatOctConfService.findBySn(osn);
				if(woc != null){
					redirectUrl = woc.getValue();
					if(StringUtils.isNotBlank(redirectUrl) && redirectUrl.contains("?")){
						redirectUrl = redirectUrl +"&opernid=&" + getRequest().getQueryString();
					}else{
						redirectUrl = redirectUrl +"?opernid=&" + getRequest().getQueryString();
					}
				}
			}
		}
		return "woauth";
	}
	
	/**
	* @Title dealOauth
	* @Description TODO【处理鉴权，地址跳转】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	@Action("woauthdeal")
	public String dealOauth(){
		if(StringUtils.isNotBlank(osn) ){
					String opernid = wchatOauthProcess.getOauthAccessTokenOpenId(code);
					//获取请求地址
					WchatOctConfInfo  kfAccount = wchatOctConfService.findBySn(osn);
					if(kfAccount != null){
						redirectUrl = kfAccount.getValue();
						if(redirectUrl.contains("?")){
							redirectUrl = redirectUrl +"&opernid="+ opernid +"&" + getRequest().getQueryString();
						}else{
							redirectUrl = redirectUrl +"?opernid="+ opernid +"&" + getRequest().getQueryString();
						}
					}
		}
		return "woauth";
	}
	
	@SuppressWarnings("rawtypes")
	public String getQueryString(HttpServletRequest request){
        String querystr = "";
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
            	querystr = querystr + key + "=" + value;
            } else {
            	querystr = querystr + key + "=" + value + "&";
            }
        }
		return querystr; 
	}
	
	
	
	
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the nonce
	 */
	public String getNonce() {
		return nonce;
	}
	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	/**
	 * @return the echostr
	 */
	public String getEchostr() {
		return echostr;
	}
	/**
	 * @param echostr the echostr to set
	 */
	public void setEchostr(String echostr) {
		this.echostr = echostr;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the osn
	 */
	public String getOsn() {
		return osn;
	}

	/**
	 * @param osn the osn to set
	 */
	public void setOsn(String osn) {
		this.osn = osn;
	}

	/**
	 * @return the isoa
	 */
	public String getIsoa() {
		return isoa;
	}

	/**
	 * @param isoa the isoa to set
	 */
	public void setIsoa(String isoa) {
		this.isoa = isoa;
	}
}
