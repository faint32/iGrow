/**
* @FileName WchatCardSign.java
* @Package com.igrow.mall.bean.card.jsapi.sign
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午1:48:58
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi.sign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName WchatCardJsAPISign
 * @Description TODO【js-api签名方法】
 * @Author brights
 * @Date 2014年10月24日 下午1:48:58
 */
public class WchatCardJsAPISign {
	
	 /**
	* @Title getSignatureStr
	* @Description TODO【获取签名字符串】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getSignatureStr( ArrayList<String> signParams ){
		if(signParams != null && signParams.size() > 0){
			 Collections.sort(signParams);
			    StringBuilder wsbStr = new StringBuilder();
			    for (String str : signParams){
			    	 wsbStr.append(str);
			    	  System.out.println("str:" + str);
			    }
			    System.out.println("string_to_sign:" + wsbStr.toString());
			    String inputStr = wsbStr.toString();
			    try {
			        MessageDigest hasher = MessageDigest.getInstance("SHA-1");
			       // byte[] digest = hasher.digest(wsbStr.toString().getBytes());
			        //return byteToHexStr(digest);
					hasher.update(inputStr.getBytes("UTF8"));
			        byte s[] = hasher.digest();  
			            // m.digest(inputText.getBytes("UTF8"));  
			        return byteToHexStr(s); 
			    } catch (NoSuchAlgorithmException e) {
			        e.printStackTrace();
			        return "";
				} catch (UnsupportedEncodingException e) {
					
			    }
		}
		 return "";
	 }
	
	 /**
	* @Title byteToHexStr
	* @Description TODO【字符转换】
	* @param data
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String byteToHexStr(byte[] data){
	     /*   StringBuilder str = new StringBuilder();
	        for (byte b : data)
	        {
	            str.append(Integer.toHexString(b & 0xFF));
	        }
	        return str.toString();*/
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < data.length; ++i) {  
	            sb.append(Integer.toHexString((data[i] & 0xFF) | 0x100).substring(1,3));  
	        }  
	        return sb.toString();  
	 }


}
