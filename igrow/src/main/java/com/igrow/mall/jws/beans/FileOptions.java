/*
 * @(#)FileOptions.java 2010-11-26上午10:11:08
 * Copyright 2010 Palm Control, Inc. All rights reserved.
 */
package com.igrow.mall.jws.beans;

import java.io.File;
import java.io.Serializable;

/**
 * 文件属性
 * 
 * @modificationHistory.  
 * <ul>
 * <li>lyb Mar 14, 20124:51:40 PM TODO</li>
 * </ul>
 */

public class FileOptions implements Serializable {
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since v 1.1
	 */
	
	private static final long serialVersionUID = 1L;
	private File file;				//文件
	private String fileFileName;	//文件名称
	private String fileContentType; //文件类型
	private int orderField;			//排序位
	private boolean withWater;		//加水印选项
	private String waterType;		//水印类型
	private int waterLocation;		//水印位置
	public File getFile() {
		return this.file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return this.fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return this.fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public int getOrderField() {
		return this.orderField;
	}
	public void setOrderField(int orderField) {
		this.orderField = orderField;
	}
	public boolean isWithWater() {
		return this.withWater;
	}
	public void setWithWater(boolean withWater) {
		this.withWater = withWater;
	}
	public String getWaterType() {
		return this.waterType;
	}
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	public int getWaterLocation() {
		return this.waterLocation;
	}
	public void setWaterLocation(int waterLocation) {
		this.waterLocation = waterLocation;
	}
}
