/**
* @FileName AddressIntVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-25 上午11:04:36
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName AddressIntVo
 * @Description TODO【地址接口返回】
 * @Author Brights
 * @Date 2013-10-25 上午11:04:36
 */
@XStreamAlias("intf")
public class AddressIntfVo extends CommonIntfVo {
	private static final long serialVersionUID = -6324018113423110130L;
	
	@XStreamAlias("d")
	private AddressVo addressVo;
	
	@XStreamAlias("d")
	private AddressListVo addressListVo;

	public AddressListVo getAddressListVo() {
		return addressListVo;
	}

	public void setAddressListVo(AddressListVo addressListVo) {
		this.addressListVo = addressListVo;
	}

	public AddressVo getAddressVo() {
		return addressVo;
	}

	public void setAddressVo(AddressVo addressVo) {
		this.addressVo = addressVo;
	}



}
