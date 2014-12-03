/**
 * @FileName AdminAuthInterceptor.java
 * @Package com.igrow.mall.web.interceptor
 * @Description TODO【用一句话描述该文件做什么】
 * @Author 
 * @Date 2013-11-13 下午2:56:06
 * @Version V1.0.1
 */
package com.igrow.mall.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.igrow.mall.common.annotation.OperationAuth;
import com.igrow.mall.web.action.core.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

/**
 * @ClassName AdminAccessAuthorityInterceptor
 * @Description TODO【后台访问权限拦截器】
 * @Author Brights
 * @Date 2013-11-13 下午2:56:06
 */
public class AdminAccessAuthorityInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = -3544852040585875665L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminAccessAuthorityInterceptor.class);
	private static final String[] LOGIN_IGNORED_URLS = {
			"/admin/welcome/index.do","/admin/welcome/test.do", "/admin/welcome/logout.do",
			"/admin/welcome/main.do", "/admin/welcome/login.do","/common/pdetail.do","/common/pdetailh.do","/common/edetailh.do","/common/ahdetail.do",
			"/common/imageupload.do", "/common/imageuploads.do" ,"/common/adetail.do","/application/save.do","/common/productShare.do",
			"/common/wchat.do","/common/oauth.do","/common/woauth.do","/common/woauthdeal.do"};
	private static final String[] LOGIN_IGNORED_URIS = {"/wchat/","/common/" };

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestUri = request.getRequestURI();
		if (!isLogin(requestUri)) { // 不需要登录
			return invocation.invoke();
		}
		Object object = invocation.getAction();
		if (object instanceof BaseAction) {
			BaseAction baseAction = (BaseAction) object;
			if (baseAction.getLoginUser() == null) {
				return redirectTimeout(request);
			}
			String actionName = invocation.getProxy().getActionName();
			String actionClass = invocation.getAction().getClass().getName();
			Method method = invocation.getAction().getClass()
					.getMethod(invocation.getProxy().getMethod());
			if (method == null) {
				LOGGER.error("no this method[name=" + actionName + "] on "
						+ actionClass);
				return BaseAction.ERROR;
			}
			OperationAuth auth = method.getAnnotation(OperationAuth.class);
			// 未注解权限码不过滤用户权限
			if (auth == null) {
				return invocation.invoke();
			}
			if (!baseAction.hasPermission(auth.code())) {
				HttpServletRequest httpServletRequest = baseAction.getRequest();
				String remoteHost = httpServletRequest.getRemoteHost();
				LOGGER.warn("need Auth! code[" + auth + "], remoteHost["
						+ remoteHost + "]");
				ServletActionContext.getRequest().setAttribute("msg",
						"您没有访问此功能的权限！请联系管理员给你赋予相应权限。");
				return "unauth";
			}
		}
		return invocation.invoke();
	}

	/**
	 * @Title isLogin
	 * @Description TODO【确定地址是否要登录】
	 * @param url
	 * @return
	 * @Return boolean 返回类型
	 * @Throws
	 */
	public boolean isLogin(String url) {
		for (String ignoredUrl : LOGIN_IGNORED_URIS) {
			if (StringUtils.isNotBlank(ignoredUrl)) {
				if (url.contains(ignoredUrl)) {
					return false;
				}
			}
		}
		for (String ignoredUrl : LOGIN_IGNORED_URLS) {
			if (StringUtils.isNotBlank(ignoredUrl)) {
				if (url.contains(ignoredUrl)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @Title redirectTimeout
	 * @Description TODO【重定向到超时页面】
	 * @return
	 * @Return String 返回类型
	 * @Throws
	 */
	public String redirectTimeout(HttpServletRequest request) {
		String redirectUrl = request.getServletPath();
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			redirectUrl += "?" + queryString;
		}
		OgnlValueStack ognlValueStack = (OgnlValueStack) request
				.getAttribute("struts.valueStack");
		ognlValueStack.set("redirectUrl", redirectUrl);
		return "timeout";
	}

}
