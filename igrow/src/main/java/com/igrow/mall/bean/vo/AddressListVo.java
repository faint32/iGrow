/**
* @FileName AddressVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 上午11:05:54
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName AddressVo
 * @Description TODO【地址】
 * @Author Brights
 * @Date 2013-10-25 上午11:05:54
 */
public class AddressListVo implements Serializable{
	private static final long serialVersionUID = -920810911675693803L;
	
	@XStreamAlias("pg")
	private Integer curPage;
	@XStreamAlias("alist")
	private List<AddressVo> addressVos = new ArrayList<AddressVo>();
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public List<AddressVo> getAddressVos() {
		return addressVos;
	}
	public void setAddressVos(List<AddressVo> addressVos) {
		this.addressVos = addressVos;
	}
	
	
}
