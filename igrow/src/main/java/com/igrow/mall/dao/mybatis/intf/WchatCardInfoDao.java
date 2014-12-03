/**
* @FileName WchatCardInfoDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午2:52:08
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.WchatCardInfo;

/**
 * @ClassName WchatCardInfoDao
 * @Description TODO【微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午2:52:08
 */
public interface WchatCardInfoDao extends BaseDao<WchatCardInfo, String> {
	
	/**
	* @Title findByCardId
	* @Description TODO【按cardId获取优惠券详情】
	* @param cardId
	* @return 
	* @Return WchatCardInfo 返回类型
	* @Throws 
	*/ 
	public  WchatCardInfo findByCardId(String cardId);

}
