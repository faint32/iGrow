package com.igrow.mall.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.swetake.util.Qrcode;
  
/** 
 * Date: 2013/10/15 16:07
 */  
public class QRCodeEncoder {  
  
  
    private static int DEFAULT_WIDTH;
    private static int DEFAULT_HEIGHT;
    private static int UNIT_WIDTH = 10;  
  
  
    public String createImg(String ip,Integer type,String pid,String name,String content){  
        Qrcode qrcode=new Qrcode();  
        qrcode.setQrcodeErrorCorrect('M');/* L','M','Q','H' */  
        qrcode.setQrcodeEncodeMode('B');/* "N","A" or other */  
        qrcode.setQrcodeVersion(7);/* 0-20 */  
        String testString = content;
        if(type == 2){
        	//testString = testString + "?from=1&pid=" + pid;  
        	//testString = "http://115.29.232.103:8080/boraMallH5T/views/front/product/product.html?from=1&pid=" + pid;
        	  testString = ip+"boraMallH5T/views/front/product/product.html?from=1&pid=" + pid;
        }else{
        	//testString = testString + "?from=0&pid=" + pid;
        	//testString = "http://115.29.232.103:8080/boraMallH5T/views/front/product/product.html?from=0&pid=" + pid;
        	  testString = ip+"boraMallH5T/views/front/product/product.html?from=0&pid=" + pid;
        }
  
        	
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
        if(type == 2){
             //bi = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT + 150, BufferedImage.TYPE_INT_RGB);  
             bi = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
        }else{
        	 bi = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
        }
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
       // if(type == 2){
       //    paint(g,name);//生成文字说明的
       // }
        
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
    
    public  void paint(Graphics2D g2d,String name) {  
    	g2d.setBackground(Color.WHITE);  
    	g2d.clearRect(0, DEFAULT_HEIGHT, DEFAULT_WIDTH, 150);  
    	g2d.setFont(new Font("宋体", Font.PLAIN, 20));//部署到linux上要把宋体字体传到服务器
    	g2d.setColor(Color.BLACK);
    	FontMetrics fm = g2d.getFontMetrics();
    	List<String> str3 = new ArrayList<String>();
    	if(name != null){
    		for(int i=1;i<name.length();i++){
    			if(name.length()>21*i){
    				str3.add(name.substring((i-1)*21,i*21-1));
    			}else{
    				str3.add(name);
    				break;
    			}
    		}
    	}
    	g2d.setBackground(Color.WHITE);  
    	int stringAscent = fm.getAscent();
    	int stringDescent = fm.getDescent ();
    	if(str3 != null && str3.size() > 0){
    		for(String names : str3){
    			int stringWidth = fm.stringWidth(names);
    	    	int x = DEFAULT_WIDTH / 2 - stringWidth / 2;
    	    	int y = 950 / 2 + (stringAscent - stringDescent) / 2;
    	    	g2d.drawString(names, x, y);
    		}
    	}
   } 
    
    
	public String getScanUrl(String ip,String pid,String content) {
		return createImg(ip,1,pid,null,content);
	}  
	
	public String getShareUrl(String ip,String pid,String name,String content) {
		return createImg(ip,2,pid,name,content);
	} 
}  