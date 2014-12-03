package com.igrow.mall.common.enums.wchat;


/**
 * @ClassName WmediaType
 * @Description TODO【多媒体类型】
 * @Author brights
 * @Date 2014年8月13日 下午5:02:05
 */
public enum WmediaType {
	
	IMAGE(0,"image","图片"),
	VOICE(1,"voice","语音"),
	VIDEO(3,"video","视频"),
	THUMB(4,"thumb","缩略图"),;
	
	private int value;
	private String desc;
	private String name;
	
	private WmediaType(int value,String name,String desc){
		this.value=value;
		this.name=name;
		this.desc=desc;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
