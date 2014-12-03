package com.igrow.mall.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.swetake.util.Qrcode;
  
/** 
 * Date: 2013/10/15 16:07
 */  
public class HotelRCodeEncoder {  
  
  
    private static int DEFAULT_WIDTH;
    private static int DEFAULT_HEIGHT;
    private static int UNIT_WIDTH = 10;  
  
  
    public String createImg(String ip, String hotelSn){  
        Qrcode qrcode=new Qrcode();  
        qrcode.setQrcodeErrorCorrect('M');/* L','M','Q','H' */  
        qrcode.setQrcodeEncodeMode('B');/* "N","A" or other */  
        qrcode.setQrcodeVersion(7);/* 0-20 */  
        String testString = ip+"boraMallH5T/views/front/product/plist.html?hid=" + hotelSn;
        	
        byte[] buff = null;  
        try {  
            buff = testString.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        boolean[][] bRect = qrcode.calQrcode(buff);  
        DEFAULT_WIDTH = (bRect[0].length + 2) * UNIT_WIDTH;
        DEFAULT_HEIGHT = (bRect.length + 2) * UNIT_WIDTH;
  
        BufferedImage bi = null;
        bi = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
        //int unitWidth = DEFAULT_WIDTH / bRect.length;  
  
        // createGraphics  
        Graphics2D g = bi.createGraphics();  
  
        // set background  
        g.setBackground(Color.WHITE);  
        g.clearRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);  
        g.setColor(Color.BLACK);  
  
        if (buff.length>0 && buff.length <123){  
            for (int i=0;i<bRect.length;i++){  
                for (int j=0;j<bRect.length;j++){  
                    if (bRect[j][i]) {  
                    	 g.fillRect((j + 1) * UNIT_WIDTH, (i + 1) * UNIT_WIDTH, UNIT_WIDTH, UNIT_WIDTH);  
                    }  
                }  
            }  
        }  
       
        
        g.dispose();  
        bi.flush();  
       
        Date date = new Date();
        SimpleDateFormat sf =new SimpleDateFormat("yyyyMMddhhmmssSSSS");
        String FilePath = ServletActionContext.getServletContext().getRealPath("/upload");  
    	String fullName = sf.format(date)+".png";
		String dstPath = FilePath+"/"+fullName;	//全路径
		File dirFile = new File(dstPath);
		boolean isDir = dirFile.isDirectory();
		if(!isDir){//目录不存在则先建目录
			try{
				dirFile.mkdirs();
			}catch (Exception e) {
			}
		}
        try {  
            ImageIO.write(bi, "png", dirFile);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println("Create QRCode finished!");  
        return sf.format(date)+".png";
    }
    
	public String getHotelUrl(String ip,String hid) {
		return createImg(ip,hid);
	}  
}  