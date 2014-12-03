/**
* @FileName ProductPropVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-30 下午5:30:58
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName ProductPropVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-30 下午5:30:58
 */
@SuppressWarnings("rawtypes")
public class ProductPropVo implements Serializable {
	private static final long serialVersionUID = 8057547759140877160L;
	
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("details")
	private List details = new ArrayList();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the details
	 */
	public List getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List details) {
		this.details = details;
	}

}
