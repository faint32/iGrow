/**
* @FileName RedirectUrlInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014-5-4 下午5:08:25
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName RedirectUrlInfo
 * @Description TODO【重定向地址信息】
 * @Author Brights
 * @Date 2014-5-4 下午5:08:25
 */
@Alias("TredirectUrlInfo")
public class RedirectUrlInfo extends BaseEntity {
	private static final long serialVersionUID = -3246477376640577830L;
	
	private String sn;
	private String name;
	private String url;
	private String redirectUrl;
	private String remark;
	
	public String getSn() {
		return sn;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}



}
