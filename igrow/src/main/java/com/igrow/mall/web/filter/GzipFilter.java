package com.igrow.mall.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import com.igrow.mall.bean.common.GzipResponseWrapper;


/**
* @ClassName GzipFilter
* @Description TODO【Gzip压缩传输】
* @Author Brights
* @Date 2013-11-25 下午10:55:48
*/ 
@Component("gzipFilter")
public class GzipFilter implements Filter {
	
	private static final int EMPTY_GZIPPED_CONTENT_SIZE = 20;
	
	public void init(FilterConfig filterConfig) throws ServletException {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		boolean isGzipEnabled = true;
		if (isGzipEnabled && isAcceptsGzipEncoding(request) && !response.isCommitted()) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            GzipResponseWrapper gzipResponseWrapper = new GzipResponseWrapper(response, gZIPOutputStream);
            chain.doFilter(request, gzipResponseWrapper);
            gzipResponseWrapper.flush();
            gZIPOutputStream.close();
            
            if (gzipResponseWrapper.getStatus() != HttpServletResponse.SC_OK) {
                return;
            }
            
            byte[] byteArrayOutputStreamBytes = byteArrayOutputStream.toByteArray();
            if (byteArrayOutputStreamBytes.length == EMPTY_GZIPPED_CONTENT_SIZE) {
            	byteArrayOutputStreamBytes = new byte[0];
            }
            
            response.setHeader("Content-Encoding", "gzip");
            response.setContentLength(byteArrayOutputStreamBytes.length);
            response.getOutputStream().write(byteArrayOutputStreamBytes);
        } else {
            chain.doFilter(request, response);
        }
	}
	
	// 判断浏览器是否支持GZIP
	@SuppressWarnings("unchecked")
	private boolean isAcceptsGzipEncoding(HttpServletRequest httpServletRequest) {
        Enumeration<String> headers = httpServletRequest.getHeaders("Accept-Encoding");
        while (headers.hasMoreElements()) {
            String headerValue = (String) headers.nextElement();
            if (headerValue.indexOf("gzip") != -1) {
                return true;
            }
        }
        return false;
    }
	
	public void destroy() {}

}