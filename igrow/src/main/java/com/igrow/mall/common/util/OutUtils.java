/**
* @FileName OutUtils.java
* @Package com.igrow.mall.common.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-24 上午10:04:17
* @Version V1.0.1
*/
package com.igrow.mall.common.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.igrow.mall.common.constant.SystemConstants;

/**
 * @ClassName OutUtils
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-10-24 上午10:04:17
 */
public class OutUtils {
	
	/**
	* @Title out
	* @Description TODO【输出文本】
	* @param response
	* @param content 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public static void out(HttpServletResponse response,String content){
		PrintWriter out = null;
		try {
			response = OutUtils.intiResponse(response);
			out = response.getWriter();
			out.write(content);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	* @Title intiResponse
	* @Description TODO【初始化Response】
	* @param response
	* @return 
	* @Return HttpServletResponse 返回类型
	* @Throws 
	*/ 
	public static HttpServletResponse intiResponse(HttpServletResponse response){
		response.setContentType(SystemConstants.HEADER_JSON_CONTENT_TYPE + ";charset=" + SystemConstants.HEADER_ENCODING);
		response.setCharacterEncoding(SystemConstants.HEADER_ENCODING);
		if (SystemConstants.HEADER_NO_CACHE) {
			response.setDateHeader("Expires", 1L);
			response.addHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
		}
		return response;
	}

}
