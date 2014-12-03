/**
* @FileName WchatMenuProcess.java
* @Package com.igrow.mall.service.common.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月13日 下午2:42:01
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.intf;

/**
 * @ClassName WchatMenuProcess
 * @Description TODO【微信菜单处理接口】
 * @Author brights
 * @Date 2014年10月13日 下午2:42:01
 */
public interface WchatMenuProcess {
	
	/**
	* @Title create
	* @Description TODO【创建】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public boolean create() throws Exception;
	
	/**
	* @Title query
	* @Description TODO【查询】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void query();
	
	/**
	* @Title delete
	* @Description TODO【删除】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void delete();
	
	
	/**
	* @Title dataGenerate
	* @Description TODO【生成数据】 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public boolean dataGenerate()  throws Exception;

}
