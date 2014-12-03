/**
* @FileName RequestHandlerInterceptor.java
* @Package com.igrow.mall.web.interceptor
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-21 下午3:13:54
* @Version V1.0.1
*/
package com.igrow.mall.web.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.igrow.mall.bean.common.ParamsParser;
import com.igrow.mall.bean.common.ParamsValidator;
import com.igrow.mall.bean.vo.CommonIntfVo;
import com.igrow.mall.common.constant.SystemConstants;
import com.igrow.mall.common.enums.IntfsReturn;
import com.igrow.mall.common.util.IntfsUtils;
import com.igrow.mall.common.util.OutUtils;
import com.igrow.mall.common.util.XmlUtils;

/**
 * @ClassName RequestHandlerInterceptor
 * @Description TODO【Spring请求处理拦截器】
 * @Author Brights
 * @Date 2013-10-21 下午3:13:54
 */
public class IntfsAccessHandlerInterceptor extends HandlerInterceptorAdapter {

	/**
	* @Title postHandle
	* @Description 
	* @param request
	* @param response
	* @param handler
	* @param modelAndView
	* @throws Exception
	* @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	*/ 
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String resultContent = "";
		String callBackType = request.getParameter("dtype");
		if(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY) != null){
			if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
				resultContent = XmlUtils.toXml(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY));
			}else{ //默认返回Json格式数据
				resultContent = XmlUtils.toJson(modelAndView.getModelMap().get(SystemConstants.RESULT_PARAMS_KEY));	
			}
		}else{
			CommonIntfVo intfVo = new CommonIntfVo();
			intfVo.setActionMethod((String)request.getAttribute(SystemConstants.ACTION_METHOD));
			intfVo.setMessage(IntfsReturn.UNKNOWN_WRONG.getMessage());//未知错误
			intfVo.setCode(IntfsReturn.UNKNOWN_WRONG.getCode());
			if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
				resultContent = XmlUtils.toXml(intfVo);
			}else{ //默认返回Json格式数据
				resultContent = XmlUtils.toJson(intfVo);
			}
		}
		//OutUtils.out(response, CommonUtils.replaceBlank(resultContent));
		OutUtils.out(response, resultContent);
	}

	/**
	* @Title preHandle
	* @Description 
	* @param request
	* @param response
	* @param handler
	* @return
	* @throws Exception
	* @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	*/ 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			//MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
			//String requestParams = IOUtils.toString(request.getInputStream(),SystemConstants.UTF_8_ENCODING);
			String requestParams = request.getParameter(SystemConstants.PARAMS);
			String actionMethod = IntfsUtils.getActionMethod(request);
			String callBackType = request.getParameter("dtype");
			//参数验证
			IntfsReturn rc = ParamsValidator.verify(requestParams,actionMethod);
			if(rc.getValue() != IntfsReturn.SUCCESS.getValue()){
				CommonIntfVo intfVo = new CommonIntfVo();
				intfVo.setActionMethod(actionMethod);
				intfVo.setCode(rc.getCode());
				intfVo.setMessage(rc.getMessage());
				//OutUtils.out(response, CommonUtils.replaceBlank(XmlUtils.toJson(intfVo)));
				if(StringUtils.isNotBlank(callBackType)&&callBackType.equalsIgnoreCase("xml")){
					OutUtils.out(response, XmlUtils.toXml(intfVo));
				}else{ //默认返回Json格式数据
					OutUtils.out(response, XmlUtils.toJson(intfVo));
				}
				return false;
			}
			//解析参数
			ParamsParser paramsParser = new ParamsParser(requestParams);
			request.setAttribute(SystemConstants.REQUEST_PARAMS_KEY, paramsParser);
			request.setAttribute(SystemConstants.ACTION_METHOD, actionMethod);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		super.afterCompletion(httpservletrequest, httpservletresponse, obj, exception);
	}
	
}
