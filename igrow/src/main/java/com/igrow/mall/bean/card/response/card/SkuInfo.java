/**
* @FileName SkuInfo.java
* @Package com.igrow.mall.bean.card.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:22:07
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName SkuInfo
 * @Description TODO【商品信息】
 * @Author brights
 * @Date 2014年10月22日 上午10:22:07
 */
@XStreamAlias("sku")
public class SkuInfo implements Serializable {
	private static final long serialVersionUID = -5531671940690460065L;
	
	@XStreamAlias("quantity")
	@JsonProperty("quantity")
	private Long quantity; //上架的数量

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
