/**
* @FileName OrderLogType.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-8 下午3:05:40
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName OrderLogType
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-11-8 下午3:05:40
 */
@Alias("EorderLogType")
public enum OrderLogType {
	// 订单日志类型（订单创建、订单修改、订单支付、订单退款、订单发货、订单退货、订单完成、订单作废,订单收货,酒店订单结算,供应商订单结算）
	create, modify, payment, refund, shipping, reship, completed, invalid, receipted,h_settlement,s_settlement
}
