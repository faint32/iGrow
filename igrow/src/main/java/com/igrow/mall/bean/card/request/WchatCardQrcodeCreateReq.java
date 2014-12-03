/**
* @FileName WchatCardQrcodeCreateReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:41:05
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.request.qrcode.ActionInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardQrcodeCreateReq
 * @Description TODO【生成卡券二维码请求】
 * @Author brights
 * @Date 2014年10月22日 上午11:41:05
 */
@JsonIgnoreProperties(ignoreUnknown=true) 
public class WchatCardQrcodeCreateReq implements Serializable {
	private static final long serialVersionUID = 3335144942323038439L;
	
	public final String  req_url = "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("action_name")
	@JsonProperty("action_name")
	private String actionName = "QR_CARD";
	
	@XStreamAlias("action_info")
	@JsonProperty("action_info")
	private ActionInfo actionInfo ;

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the actionInfo
	 */
	public ActionInfo getActionInfo() {
		return actionInfo;
	}

	/**
	 * @param actionInfo the actionInfo to set
	 */
	public void setActionInfo(ActionInfo actionInfo) {
		this.actionInfo = actionInfo;
	}

}
