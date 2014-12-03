/**
* @FileName MessageTemplateDao.java
* @Package com.igrow.mall.dao.mybatis.intf
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-28 下午12:56:19
* @Version V1.0.1
*/
package com.igrow.mall.dao.mybatis.intf;

import com.igrow.mall.bean.entity.MessageTemplate;

/**
 * @ClassName MessageTemplateDao
 * @Description TODO【消息模板】
 * @Author Brights
 * @Date 2013-10-28 下午12:56:19
 */
public interface MessageTemplateDao extends BaseDao<MessageTemplate, String> {
	
	/**
	* @Title findByCode
	* @Description TODO【依据编码获取模板】
	* @param code
	* @return 
	* @Return MessageTemplate 返回类型
	* @Throws 
	*/ 
	public MessageTemplate findByCode(String code);
}
