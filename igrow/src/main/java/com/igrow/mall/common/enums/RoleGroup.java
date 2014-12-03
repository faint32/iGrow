/**
* @FileName RoleGroup.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-17 下午3:19:49
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

/**
 * @ClassName RoleGroup
 * @Description TODO【角色组枚举】
 * @Author Brights
 * @Date 2013-12-17 下午3:19:49
 */
public enum RoleGroup {
	
	ADMIN_USER(0, "管理员用户",1), 
	HOTEL_USER(1, "酒店用户",2),
	SUPPLIER_USER(2,"供应商用户",3);
	
	private int value;
	private String desc;
	private int idx;

	private RoleGroup(int value, String desc,int idx) {
		this.value = value;
		this.desc = desc;
		this.idx = idx;
	}

	/**
	 * @return the idx
	 */
	public int getIdx() {
		return idx;
	}

	/**
	 * @param idx the idx to set
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public static RoleGroup valueOf(int value){
		for(RoleGroup rg:RoleGroup.values()){
			if(rg.getValue()==value){
			return rg;
		}
	   }
	    return null;
	}
	
	public static RoleGroup idxOf(int idx){
		for(RoleGroup rg:RoleGroup.values()){
			if(rg.getIdx() == idx){
			return rg;
		}
	   }
	    return null;
	}
}
