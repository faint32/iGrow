/**
* @FileName RedirectUrlWs.java
* @Package com.igrow.mall.ws.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014-5-4 下午5:28:13
* @Version V1.0.1
*/
package com.igrow.mall.ws.intf;

import com.igrow.mall.bean.common.Pager;
import com.igrow.mall.bean.entity.RedirectUrlInfo;

/**
 * @ClassName RedirectUrlWs
 * @Description TODO【重定向地址Ws接口】
 * @Author Brights
 * @Date 2014-5-4 下午5:28:13
 */
public interface RedirectUrlWs extends BaseWs<RedirectUrlInfo, String> {
	
	/**
	* @Title findPagerBy
	* @Description TODO【】
	* @return 
	* @Return Pager 返回类型
	* @Throws 
	*/ 
	public Pager findPagerBy(RedirectUrlInfo search, Pager pager);
	
	/**
	* @Title isExistBySn
	* @Description TODO【是否存在编号的对象】
	* @param sn
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public boolean isExistBySn(String sn);
	
	/**
	* @Title findBySn
	* @Description TODO【依据编号查询对象】
	* @param sn
	* @return 
	* @Return RedirectUrlInfo 返回类型
	* @Throws 
	*/ 
	public RedirectUrlInfo findBySn(String sn);

}
