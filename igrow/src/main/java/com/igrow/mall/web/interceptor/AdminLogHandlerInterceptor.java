/**
* @FileName AdminLogHandlerInterceptor.java
* @Package com.igrow.mall.web.interceptor
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-2 下午5:50:45
* @Version V1.0.1
*/
package com.igrow.mall.web.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.igrow.mall.bean.entity.AdminUserInfo;
import com.igrow.mall.bean.entity.LogDetail;
import com.igrow.mall.common.annotation.OperationLog;
import com.igrow.mall.common.enums.SystemType;
import com.igrow.mall.service.admin.intf.LogService;
import com.igrow.mall.web.action.core.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @ClassName AdminLogHandlerInterceptor
 * @Description TODO【日志拦截器】
 * @Author Brights
 * @Date 2013-12-2 下午5:50:45
 */
public class AdminLogHandlerInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
    private Log logger = LogFactory.getLog(AdminLogHandlerInterceptor.class);  
    
    @Resource(name = "logServiceImpl")
    private LogService logService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = invocation.getAction();
		if(object instanceof BaseAction){
			if (!StringUtils.equals(invocation.invoke(), BaseAction.ERROR)) {
				BaseAction action = (BaseAction) object;
				String actionClass = invocation.getAction().getClass().getName();
				Method method =  invocation.getAction().getClass().getMethod(invocation.getProxy().getMethod());
				if(method != null){  
					//判断是否为进行日志操作注解
					if(method.isAnnotationPresent(OperationLog.class)){
						OperationLog operationLog = method.getAnnotation(OperationLog.class);
						String operation = operationLog.type();
						String operationName = operationLog.name();
						BaseAction baseAction = (BaseAction) action;
						HttpServletRequest request= ServletActionContext.getRequest();
						String logInfo = baseAction.getLogInfo();
						if (logger.isDebugEnabled()) {
							logger.debug("Action class:" + actionClass + 
									"Action method:" + method.getName() +
									"operation:" + operation + "info:" + null);
						}
						String ip = request.getRemoteAddr();
						AdminUserInfo adminUser = (AdminUserInfo) baseAction.getLoginUser();
						String operator = ""; 
						if(adminUser == null){
							operator = "未知";
						}else{
							operator = adminUser.getUserName();
						}
						LogDetail log = new LogDetail();
						log.setActionClass(actionClass);
						log.setActionMethod(method.getName());
						log.setInfo(operationName + ":" + logInfo);
						log.setIp(ip);
						log.setOperation(operation + ":" + operationName);
						log.setOperator(operator);
						log.setSystemType(SystemType.ADMIN);
						log.setCreateOperator(operator);
						log.setModifyOperator(operator);
						logService.insert(log);
					}
				}
				
			}
		}
		return null;
	}

}
