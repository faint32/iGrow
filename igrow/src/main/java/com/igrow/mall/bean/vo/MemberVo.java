/**
* @FileName MemberVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 下午8:59:49
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName MemberVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-23 下午8:59:49
 */
public class MemberVo implements Serializable{
	private static final long serialVersionUID = 5165040975771560612L;
	
	@XStreamAlias("s")
	private String memberSn;
	@XStreamAlias("vcode")
	private String verifyCode;
	@XStreamAlias("iswin")
	private String iswin;
	@XStreamAlias("number")
	private int number;
	/**
	 * @return the memberSn
	 */
	public String getMemberSn() {
		return memberSn;
	}
	/**
	 * @param memberSn the memberSn to set
	 */
	public void setMemberSn(String memberSn) {
		this.memberSn = memberSn;
	}
	/**
	 * @return the verifyCode
	 */
	public String getVerifyCode() {
		return verifyCode;
	}
	/**
	 * @param verifyCode the verifyCode to set
	 */
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getIswin() {
		return iswin;
	}
	public void setIswin(String iswin) {
		this.iswin = iswin;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
 
}
