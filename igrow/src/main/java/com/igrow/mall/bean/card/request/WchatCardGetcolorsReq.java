/**
* @FileName WchatCardGetcolorsReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:26:37
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

/**
 * @ClassName WchatCardGetcolorsReq
 * @Description TODO【获取卡券颜色列表-请求】
 * @Author brights
 * @Date 2014年10月22日 上午11:26:37
 */
public class WchatCardGetcolorsReq implements Serializable {
	
	private static final long serialVersionUID = 3868456495515274887L;
	public final String  req_url = "https://api.weixin.qq.com/card/getcolors?access_token=TOKEN"; //请求地址
	

}
