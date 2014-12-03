/**
* @FileName MemberVerifyInfo.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午8:15:16
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.igrow.mall.common.enums.Bool;

/**
 * @ClassName MemberVerifyInfo
 * @Description TODO【会员验证码信息表】
 * @Author Brights
 * @Date 2013-10-13 下午8:15:16
 */
@Alias("TmemberVerify")
public class MemberVerifyInfo extends BaseEntity {
	private static final long serialVersionUID = 3142390441938509551L;
	
	private String vcode;//验证码 MD5加密
	private String mobile;//手机号码
	private Date allotedTime;//有效期时间
	private Bool isVerify;//是否验证
	
	/**
	* @Title onInsert
	* @Description 
	* @see com.igrow.mall.bean.entity.BaseEntity#onInsert()
	*/ 
	@Override
	public void onInsert() {
		if(isVerify == null){
			isVerify = Bool.FALSE;
		}
		super.onInsert();
	}
	/**
	* @Title onUpdate
	* @Description 
	* @see com.igrow.mall.bean.entity.BaseEntity#onUpdate()
	*/ 
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	/**
	* @Title onDelete
	* @Description 
	* @see com.igrow.mall.bean.entity.BaseEntity#onDelete()
	*/ 
	@Override
	public void onDelete() {
		super.onDelete();
	}
	
	/**
	 * @return the vcode
	 */
	public String getVcode() {
		return vcode;
	}
	/**
	 * @param vcode the vcode to set
	 */
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the allotedTime
	 */
	public Date getAllotedTime() {
		return allotedTime;
	}
	/**
	 * @param allotedTime the allotedTime to set
	 */
	public void setAllotedTime(Date allotedTime) {
		this.allotedTime = allotedTime;
	}
	/**
	 * @return the isVerify
	 */
	public Bool getIsVerify() {
		return isVerify;
	}
	/**
	 * @param isVerify the isVerify to set
	 */
	public void setIsVerify(Bool isVerify) {
		this.isVerify = isVerify;
	}
	

}
