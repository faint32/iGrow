/**
 * @FileName RequestHandlerInterceptor.java
 * @Package com.igrow.mall.web.interceptor
 * @Description TODO【用一句话描述该文件做什么】
 * @Author 
 * @Date 2013-10-21 下午3:13:54
 * @Version V1.0.1
 */
package com.igrow.mall.web.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.igrow.mall.bean.entity.LogDetail;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.util.IntfsUtils;
import com.igrow.mall.service.admin.intf.LogService;

/**
 * @ClassName IntfsLogHandlerInterceptor
 * @Description TODO【Spring请求日志处理拦截器】
 * @Author Brights
 * @Date 2013-10-21 下午3:13:54
 */
public class IntfsLogHandlerInterceptor extends HandlerInterceptorAdapter {

	@Resource(name = "logServiceImpl")
	private LogService logService;
/*	@Resource(name = "memberServiceImpl")
	private MemberService memberService;*/

	/**
	 * @Title postHandle
	 * @Description
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * @Title preHandle
	 * @Description
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取请求的类名称
		String actionClass = handler.getClass().getName();
		//System.out.println("actionClass=="+actionClass);
		String actionMethod = IntfsUtils.getActionMethod(request);
		String ip = request.getRemoteAddr();
		String operator = "未知";
		String requestParams = request.getParameter(SystemConstants.PARAMS);
		if (StringUtils.isNotBlank(requestParams)) {
			/*ParamsParser paramsParser = new ParamsParser(
					request.getParameter(SystemConstants.PARAMS));*/
			/*MemberInfo member = memberService.findBySn(paramsParser.getString("s"));//会员
			String mobile = paramsParser.getString("phone"); //手机号码
			int sysType = paramsParser.getInt("sys", 0);//系统类型，默认为APP
			if (member != null) {
				operator = member.getMemberSn() + ":" + member.getMobile();
			} else {
				if (StringUtils.isNotBlank(mobile)) {
					operator = mobile;
				}
			}*/
			LogDetail log = new LogDetail();
			log.setActionClass(actionClass);
			log.setActionMethod(actionMethod);
			log.setInfo(IntfsUtils.getActionDesc(request) + ":" + requestParams);
			log.setIp(ip);
			log.setOperation(actionMethod + ":"
					+ IntfsUtils.getActionDesc(request));
			log.setOperator(operator);
			//log.setSystemType(SystemType.valueOf(sysType));
			log.setCreateOperator(operator);
			log.setModifyOperator(operator);
			logService.insert(log);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

}
