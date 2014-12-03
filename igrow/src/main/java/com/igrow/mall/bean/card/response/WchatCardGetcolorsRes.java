/**
* @FileName WchatCardGetcolorsRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午11:29:12
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.color.Color;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardGetcolorsRes
 * @Description TODO【获取颜色列表请求返回】
 * @Author brights
 * @Date 2014年10月22日 上午11:29:12
 */
public class WchatCardGetcolorsRes  extends BaseRes implements Serializable  {
	private static final long serialVersionUID = 6225765952990222140L;
	
	
	@XStreamAlias("colors")
	@JsonProperty("colors")
	private List<Color> colorList;   //颜色列表。 


	/**
	 * @return the colorList
	 */
	public List<Color> getColorList() {
		return colorList;
	}


	/**
	 * @param colorList the colorList to set
	 */
	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}



}
