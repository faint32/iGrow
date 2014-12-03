/**
* @FileName Status.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 上午11:03:44
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName ProductType
 * @Description TODO【商品类型（自售、代售）】
 * @Author Shiyz
 * @Date 2013-10-24 上午11:13:45
 */
@Alias("ProductType")
public enum ProductType {
	SelfSell(0, "自售"), OtherSell(1, "代售");
	private int value;
	private String desc;

	private ProductType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	public static ProductType getProductType(int value){
		for(ProductType productType:ProductType.values()){
			if(productType.getValue()==value){
			return productType;
		}
	   }
	    return null;
	}
}
