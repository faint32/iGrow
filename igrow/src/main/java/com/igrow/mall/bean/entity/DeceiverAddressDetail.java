/**
* @FileName DeceiverAddressDetail.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 上午11:14:14
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;

/**
 * @ClassName DeceiverAddressDetail
 * @Description TODO【收货地址记录】
 * @Author Brights
 * @Date 2013-10-18 上午11:14:14
 */
@Alias("TdeceiverAddress")
public class DeceiverAddressDetail extends BaseEntity {
	private static final long serialVersionUID = -6486387921692131992L;
	
	private String name;//联系人姓名
	private String addressSn; //地址编号
	private String areaSn;//区域编号
	private String areaName; //区域名称
	private String address;//地址
	private String zipCode;//邮政编码
	private String phone;//联系电话
	private String mobile;//手机号码
	private Bool isDefault;//是否默认
	private Bool isDelete; //是否删除
	//private MemberInfo member; //所属会员
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Bool getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Bool isDefault) {
		this.isDefault = isDefault;
	}
	public Bool getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Bool isDelete) {
		this.isDelete = isDelete;
	}
	public String getAddressSn() {
		return addressSn;
	}
	public void setAddressSn(String addressSn) {
		this.addressSn = addressSn;
	}
	
	@Override
	public void onInsert() {
		if(isDelete == null){
			isDelete = Bool.FALSE;
		}
		if(isDefault == null){
			isDefault = Bool.FALSE;
		}
		if(StringUtils.isBlank(addressSn)){
			//addressSn = SerialNumberUtil.buildAddressSn();
		}
		super.onInsert();
	}
	public String getAreaSn() {
		return areaSn;
	}
	public void setAreaSn(String areaSn) {
		this.areaSn = areaSn;
	}
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	@Override
	public void onDelete() {
		isDelete = Bool.TRUE;
		super.onDelete();
	}
	

}
