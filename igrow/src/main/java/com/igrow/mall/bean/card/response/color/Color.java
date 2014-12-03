/**
* @FileName Color.java
* @Package com.igrow.mall.bean.card.response.color
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:30:41
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.color;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName Color
 * @Description TODO【颜色】
 * @Author brights
 * @Date 2014年10月22日 上午11:30:41
 */
public class Color implements Serializable {
	private static final long serialVersionUID = -1986154624626483419L;
	
	@XStreamAlias("name")
	@JsonProperty("name")
	private String name;  //可以填入的color 名称
	@XStreamAlias("value")
	@JsonProperty("value")
	private String value;  //对应的颜色数值
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
