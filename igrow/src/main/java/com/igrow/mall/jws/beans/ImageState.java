/*
 * @(#)ImageState.java 2010-11-24下午04:34:03
 * Copyright 2010 Palm Control, Inc. All rights reserved.
 */
package com.igrow.mall.jws.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 图像规格
 * @modificationHistory.  
 * <ul>
 * <li>joe.qiu 2010-11-24下午04:34:03 TODO</li>
 * </ul> 
 */
@XmlRootElement(name = "ImageState", namespace = "http://beans.jws.bora.com")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ImageState")
public class ImageState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String preName;			//图片前辍
	private int hight;				//高
	private int width;				//宽
	private String defualt_picute;	//默认图片
	public String getPreName() {
		return this.preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public int getHight() {
		return this.hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public int getWidth() {
		return this.width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getDefualt_picute() {
		return this.defualt_picute;
	}
	public void setDefualt_picute(String defualt_picute) {
		this.defualt_picute = defualt_picute;
	}
}
