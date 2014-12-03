/**
* @FileName OrderIntfVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:35:42
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName OrderIntfVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:35:42
 */
@XStreamAlias("intf")
public class OrderIntfVo extends CommonIntfVo {
	private static final long serialVersionUID = -8927598260482085243L;
	@XStreamAlias("d")
	private OrderVo orderVo;
	@XStreamAlias("d")
	private OrderListVo orderListVo;
	/**
	 * @return the orderVo
	 */
	public OrderVo getOrderVo() {
		return orderVo;
	}
	/**
	 * @param orderVo the orderVo to set
	 */
	public void setOrderVo(OrderVo orderVo) {
		this.orderVo = orderVo;
	}
	/**
	 * @return the orderListVo
	 */
	public OrderListVo getOrderListVo() {
		return orderListVo;
	}
	/**
	 * @param orderListVo the orderListVo to set
	 */
	public void setOrderListVo(OrderListVo orderListVo) {
		this.orderListVo = orderListVo;
	}

}
