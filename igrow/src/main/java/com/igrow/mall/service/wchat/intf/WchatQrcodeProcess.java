/**
* @FileName WchatQrcodeProcess.java
* @Package com.igrow.mall.service.wchat.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月14日 下午2:20:57
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

/**
 * @ClassName WchatQrcodeProcess
 * @Description TODO【微信二微码处理接口】
 * @Author brights
 * @Date 2014年10月14日 下午2:20:57
 */
public interface WchatQrcodeProcess {
	
	/**
	* @Title create
	* @Description TODO【创建】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void create(Integer scene,Integer expireSeconds);
	
	/**
	* @Title show
	* @Description TODO【二维码显示】
	* @param ticket 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public  void show(String ticket);

}
