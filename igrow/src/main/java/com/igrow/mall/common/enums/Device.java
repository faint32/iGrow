/**
* @FileName Device.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午3:47:06
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Device
 * @Description TODO【设备】
 * @Author Brights
 * @Date 2013-10-18 下午3:47:06
 */
@Alias("Edevice")
public enum Device {
	IPHONE(0, "iphone","app"), IPAD(1, "ipad","pad"), ANDROID(2, "android","apk"),H5(3, "h5","wap");

	private int value;
	private String desc;
	private String code;

	private Device(int value, String desc, String code) {
		this.value = value;
		this.desc = desc;
		this.code = code;
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

	public static Device valueOf(int value){
		for(Device device: Device.values()){
			if(device.getValue() == value){
				return device;
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
}
