/**
* @FileName OperationLogAspect.java
* @Package com.igrow.mall.web.action.core
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-5 下午2:46:02
* @Version V1.0.1
*/
package com.igrow.mall.web.action.core;

import java.lang.reflect.Method;

import javax.annotation.Resource;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import com.igrow.mall.bean.entity.LogDetail;
import com.igrow.mall.common.annotation.OperationLog;
import com.igrow.mall.common.enums.SystemType;
import com.igrow.mall.service.admin.intf.LogService;

/**
 * @ClassName OperationLogAspect
 * @Description TODO【操作日志切面】
 * @Author Brights
 * @Date 2013-11-5 下午2:46:02
 */
public class OperationLogAspect {
    private Log logger = LogFactory.getLog(OperationLogAspect.class);  
    
    @Resource(name = "logServiceImpl")
    private LogService logService;
    
    
    @SuppressWarnings({"unchecked", "rawtypes" })
	public Object doAdminSystemLog(ProceedingJoinPoint point) throws Throwable {
    	String methodName = point.getSignature().getName();
    	// 目标方法不为空
    	if(StringUtils.isNotBlank(methodName)){
    		// set与get方法除外
    		if(!(methodName.startsWith("set") || methodName.startsWith("get"))){
    			Class targetClass = point.getTarget().getClass();
				Method method = targetClass.getMethod(methodName);
				if(method != null){  
					boolean hasAnnotation = method.isAnnotationPresent(OperationLog.class);
					//判断是否为进行日志操作注解
					if(hasAnnotation){
						OperationLog operationLog = method.getAnnotation(OperationLog.class);
						String operation = operationLog.type();
						//String operationName = operationLog.name();
						//String logInfo = this.getLogInfo();
						if (logger.isDebugEnabled()) {
							logger.debug("Action class:" + targetClass.getName() + 
									"Action method:" + method.getName() +
									"operation:" + operation + "info:" + null);
						}
						//String ip = request.getRemoteAddr();
						//AdminUserInfo adminUser = (AdminUserInfo) this.getLoginUser();
						//String operator = ""; 
						//if(adminUser == null){
							//operator = "未知";
						//}else{
							//operator = adminUser.getUserName();
						//}
						LogDetail log = new LogDetail();
						log.setActionClass(targetClass.getName());
						log.setActionMethod(method.getName());
						//log.setInfo(operationName + ":" + logInfo);
						//log.setIp(ip);
						log.setOperation(operation);
						//log.setOperator(operator);
						log.setSystemType(SystemType.ADMIN);
						logService.insert(log);
					}
				}
    		}
    	}

    	return point.proceed();
    }

}
