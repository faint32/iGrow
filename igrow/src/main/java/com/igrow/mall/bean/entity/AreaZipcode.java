/**
* @FileName AreaZipcode.java
* @Package com.igrow.mall.bean.entity
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-13 下午9:01:57
* @Version V1.0.1
*/
package com.igrow.mall.bean.entity;

import java.io.Serializable;

/**
 * @ClassName AreaZipcode
 * @Description TODO【区域邮政编码和区号】
 * @Author Brights
 * @Date 2013-10-13 下午9:01:57
 */
public class AreaZipcode implements Serializable {
	private static final long serialVersionUID = -2231887782763951588L;
	
	private String id;
	private String areaSn;//区域ID
	private String zip;//邮政编码
	private String code;//区号
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the areaId
	 */
	public String getAreaSn() {
		return areaSn;
	}
	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(String areaSn) {
		this.areaSn = areaSn;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	

}
