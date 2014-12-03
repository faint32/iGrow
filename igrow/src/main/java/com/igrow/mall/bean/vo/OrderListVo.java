/**
* @FileName OrderListVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:36:22
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName OrderListVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:36:22
 */
public class OrderListVo implements Serializable {
	private static final long serialVersionUID = -2918174475139682871L;
	
	@XStreamAlias("pg")
	private Integer curPage;
	@XStreamAlias("olist")
	private List<OrderVo> orderVos = new ArrayList<OrderVo>();
	/**
	 * @return the curPage
	 */
	public Integer getCurPage() {
		return curPage;
	}
	/**
	 * @param curPage the curPage to set
	 */
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	/**
	 * @return the orderVos
	 */
	public List<OrderVo> getOrderVos() {
		return orderVos;
	}
	/**
	 * @param orderVos the orderVos to set
	 */
	public void setOrderVos(List<OrderVo> orderVos) {
		this.orderVos = orderVos;
	}

}
