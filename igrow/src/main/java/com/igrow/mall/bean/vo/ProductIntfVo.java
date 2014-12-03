/**
* @FileName ProductIntfVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 下午8:19:16
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ProductIntfVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-23 下午8:19:16
 */
@XStreamAlias("intf")
public class ProductIntfVo extends CommonIntfVo {
	private static final long serialVersionUID = -544712854418900244L;
	@XStreamAlias("d")
	private ProductVo productVo;
	@XStreamAlias("d")
	private ProductListVo productListVo;
	
	/**
	 * @return the productVo
	 */
	public ProductVo getProductVo() {
		return productVo;
	}

	/**
	 * @param productVo the productVo to set
	 */
	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	/**
	 * @return the productListVo
	 */
	public ProductListVo getProductListVo() {
		return productListVo;
	}

	/**
	 * @param productListVo the productListVo to set
	 */
	public void setProductListVo(ProductListVo productListVo) {
		this.productListVo = productListVo;
	}

}
