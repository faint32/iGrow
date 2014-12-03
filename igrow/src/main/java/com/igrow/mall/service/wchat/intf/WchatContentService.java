/**
* @FileName WchatContentService.java
* @Package com.fwchat.service.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月14日 下午2:27:37
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

import com.igrow.mall.common.wchat.WchatRequestBean;


/**
 * @ClassName WchatContentService
 * @Description TODO【内容服务类接口】
 * @Author brights
 * @Date 2014年8月14日 下午2:27:37
 */
public interface WchatContentService {
	
	/**
	* @Title text
	* @Description TODO【文本】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String text(WchatRequestBean wchat);
	
	/**
	* @Title image
	* @Description TODO【图片】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String image(WchatRequestBean wchat);
	
	/**
	* @Title voice
	* @Description TODO【声音】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String voice(WchatRequestBean wchat);
	
	/**
	* @Title video
	* @Description TODO【视频】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String video(WchatRequestBean wchat);
	
	/**
	* @Title link
	* @Description TODO【链接】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String link(WchatRequestBean wchat);
	
	/**
	* @Title locationMt
	* @Description TODO【地理位置消息】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String locationMt(WchatRequestBean wchat);
	
	/**
	* @Title subscribe
	* @Description TODO【关注】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String subscribe(WchatRequestBean wchat);
	
	/**
	* @Title unsubscribe
	* @Description TODO【取消关注】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String unsubscribe(WchatRequestBean wchat);
	
	/**
	* @Title scan
	* @Description TODO【扫码】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String scan(WchatRequestBean wchat);
	
	/**
	* @Title locationEn
	* @Description TODO【上报地理位置】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String locationEn(WchatRequestBean wchat);
	
	/**
	* @Title click
	* @Description TODO【菜单】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String click(WchatRequestBean wchat);
	
	/**
	* @Title view
	* @Description TODO【菜单】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String view(WchatRequestBean wchat);
	
	/**
	* @Title cardPassCheck
	* @Description TODO【卡券审核通过】
	* @param wchat
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String cardPassCheck(WchatRequestBean wchat);
	
	/**
	* @Title cardNotPassCheck
	* @Description TODO【卡券审核未通过】
	* @param wchat
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String cardNotPassCheck(WchatRequestBean wchat);
	
	/**
	* @Title userGetCard
	* @Description TODO【用户领取卡券】
	* @param wchat
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String userGetCard(WchatRequestBean wchat);
	
	/**
	* @Title userDelCard
	* @Description TODO【用户删除卡券】
	* @param wchat
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String userDelCard(WchatRequestBean wchat);
	
	/**
	* @Title templateSendJobFinish
	* @Description TODO【模版消息推送完成】
	* @param wchat
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String templateSendJobFinish(WchatRequestBean wchat);
	
	
}
