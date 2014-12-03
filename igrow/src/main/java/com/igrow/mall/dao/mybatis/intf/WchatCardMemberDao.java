/**
* @FileName WchatCardMemberDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月27日 下午2:58:23
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import java.util.HashMap;

import com.igrow.mall.bean.entity.WchatCardMemberDetail;

/**
 * @ClassName WchatCardMemberDao
 * @Description TODO【会员微信卡券】
 * @Author brights
 * @Date 2014年10月27日 下午2:58:23
 */
public interface WchatCardMemberDao extends BaseDao<WchatCardMemberDetail, String> {
	
	/**
	* @Title findByCardAndCode
	* @Description TODO【依据CardId和code查询记录】
	* @param values
	* @return 
	* @Return WchatCardMemberDetail 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public WchatCardMemberDetail findByCardAndCode(HashMap values);
}
