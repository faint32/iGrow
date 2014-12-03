/**
* @FileName WXUtil.java
* @Package com.igrow.mall.common.payment.tenpay.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 上午11:17:40
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.tenpay.util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.igrow.mall.common.util.DateUtils;

/**
 * @ClassName WXUtil
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年5月26日 上午11:17:40
 */
public class WXUtil {
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "GBK");
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	
	/**
	* @Title buildProductConfigSn
	* @Description TODO【生成货品编号】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String buildPaySn() {
		String sn = "wxpay";
		String  uuid = UUID.randomUUID().toString();
		sn =  (uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23)).toLowerCase();
		return sn;
	}
	
	   public static String getLogResultTxt(Map<String, String> params,HttpServletRequest request,String sn){
	    	StringBuffer responseTxtBuffer = new StringBuffer();
	    	responseTxtBuffer.append("[");
	    	responseTxtBuffer.append(DateUtils.formatString(new Date(), "yyyy-MM-dd HH:mm:ss"));
	    	responseTxtBuffer.append("]");
	    	responseTxtBuffer.append("【");
	    	responseTxtBuffer.append(request.getParameter("out_trade_no"));
	    	responseTxtBuffer.append("】");
	    	responseTxtBuffer.append("(");
	    	responseTxtBuffer.append(request.getParameter("trade_state"));
	    	responseTxtBuffer.append(",");
	    	responseTxtBuffer.append(request.getParameter("total_fee"));
	    	responseTxtBuffer.append(")");
	    	responseTxtBuffer.append(":");
	    	responseTxtBuffer.append(request.getRequestURL());
	    	responseTxtBuffer.append("?");
	    	responseTxtBuffer.append(createLinkString(params));
	    	return responseTxtBuffer.toString();
	    }
	   
	   /**
		* @Title createLinkString
		* @Description TODO【创建链接字符】
		* @param params
		* @return 
		* @Return String 返回类型
		* @Throws 
		*/ 
		public static String createLinkString(Map<String, String> params) {
		        List<String> keys = new ArrayList<String>(params.keySet());
		        Collections.sort(keys);
		        String prestr = "";
		        for (int i = 0; i < keys.size(); i++) {
		            String key = keys.get(i);
		            String value = params.get(key);
		            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
		                prestr = prestr + key + "=" + value;
		            } else {
		                prestr = prestr + key + "=" + value + "&";
		            }
		        }
		        return prestr;
		    }
}
