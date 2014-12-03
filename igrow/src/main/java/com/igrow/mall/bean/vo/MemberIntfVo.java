/**
* @FileName memberIntfVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-23 下午8:10:05
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName memberIntfVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-23 下午8:10:05
 */
@XStreamAlias("intf")
public class MemberIntfVo extends CommonIntfVo {
	private static final long serialVersionUID = 8096535973051364557L;
	
	@XStreamAlias("d")
	private MemberVo memberVo;
	
	/**
	 * @return the memberVo
	 */
	public MemberVo getMemberVo() {
		return memberVo;
	}

	/**
	 * @param memberVo the memberVo to set
	 */
	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}


}
