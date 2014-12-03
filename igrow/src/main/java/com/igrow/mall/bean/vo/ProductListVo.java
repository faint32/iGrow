/**
* @FileName ProductListVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:38:29
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ProductListVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:38:29
 */
public class ProductListVo implements Serializable {
	private static final long serialVersionUID = -2451293241015790294L;
	
	@XStreamAlias("pg")
	private Integer curPage;
	@XStreamAlias("plist")
	private List<ProductVo> productVos = new ArrayList<ProductVo>();
	@XStreamAlias("hname")
	private String hotelName;
	@XStreamAlias("productNum")
	private Long productNum;
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
	 * @return the productVos
	 */
	public List<ProductVo> getProductVos() {
		return productVos;
	}
	/**
	 * @param productVos the productVos to set
	 */
	public void setProductVos(List<ProductVo> productVos) {
		this.productVos = productVos;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}

}
