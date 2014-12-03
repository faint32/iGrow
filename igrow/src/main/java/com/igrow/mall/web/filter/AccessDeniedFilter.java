package com.igrow.mall.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName AccessDeniedFilter
* @Description TODO【非法资源访问】
* @Author Brights
* @Date 2013-11-6 下午1:16:38
*/ 
public class AccessDeniedFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {}
	public void destroy() {}
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		PrintWriter printWriter = response.getWriter();
		printWriter.write("access denied!");
		printWriter.flush();
		printWriter.close();
	}

}