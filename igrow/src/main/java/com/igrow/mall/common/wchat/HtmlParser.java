package com.igrow.mall.common.wchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class HtmlParser implements Serializable {
	private static final long serialVersionUID = 8458863692234878100L;
	private static final String url = "https://mp.weixin.qq.com/cgi-bin/appmsg?t=media/appmsg_edit&action=edit&lang=zh_CN&token=496893810&type=11&appmsgid=200709091&isMul=1";
	
	public HtmlParser(String url,String encode){
		content = getHtmlContent(url, encode);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	private String content;
	private String data;
	
	public String getContent() {
		return content;
	}

	public String getData() {
		 if(StringUtils.isNotBlank(content)){
			 String temp = content.split("var infos")[1];
			 if(StringUtils.isNotBlank(temp)){
				 data = temp.split("\"")[1]; 
			 }
			
		 }
         return data;
	}



	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	public static String getHtmlContent(URL url, String encode) {
	      StringBuffer contentBuffer = new StringBuffer();
	      int responseCode = -1;
	      HttpURLConnection con = null;
	      try {
	        con = (HttpURLConnection) url.openConnection();
	        con.setRequestProperty("User-Agent",
	              "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// IE代理进行下载
	        con.setConnectTimeout(60000);
	        con.setReadTimeout(60000);
	        // 获得网页返回信息码
	        responseCode = con.getResponseCode();
	        if (responseCode == -1) {
	            System.out.println(url.toString()
	                + " : connection is failure...");
	            con.disconnect();
	            return null;
	        }
	        if (responseCode >= 400) // 请求失败
	        {
	            System.out.println("请求失败:get response code: " + responseCode);
	            con.disconnect();
	            return null;
	        }
	        InputStream inStr = con.getInputStream();
	        InputStreamReader istreamReader = new InputStreamReader(inStr,
	              encode);
	        BufferedReader buffStr = new BufferedReader(istreamReader);
	        String str = null;
	        while ((str = buffStr.readLine()) != null)
	            contentBuffer.append(str);
	        inStr.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	        contentBuffer = null;
	        System.out.println("error: " + url.toString());
	      } finally {
	        con.disconnect();
	      }
	      return contentBuffer.toString();
	    }
	    public static String getHtmlContent(String url, String encode) {
	    /*  if (!url.toLowerCase().startsWith("http://")) {
	        url = "http://" + url;
	      }*/
	      try {
	        URL rUrl = new URL(url);
	        return getHtmlContent(rUrl, encode);
	      } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	      }
	    }
	    
        public static void main(String[] args) {
        	HtmlParser htmlParser = new HtmlParser(url,"utf-8");
        	System.out.println(htmlParser.getContent());
         	System.out.println("**********************************************************************************************************");
        	System.out.println(htmlParser.getData());
		}
}
