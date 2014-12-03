/**
* @FileName WchatOctConfInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月17日 下午12:31:07
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WchatOctConfInfo
 * @Description TODO【微信配置信息】
 * @Author brights
 * @Date 2014年10月17日 下午12:31:07
 */
@Alias("TwchatOctConfInfo")
public class WchatOctConfInfo extends BaseEntity {
	private static final long serialVersionUID = -4772918531058344928L;
	
	private String sn;
	private String param;
	private String value;
	private String remark;
	
	/**
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
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
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
