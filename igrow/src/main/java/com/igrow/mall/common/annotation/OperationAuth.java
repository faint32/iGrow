/**
* @FileName OperationAuth.java
* @Package com.igrow.mall.common.annotation
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-5 下午2:39:20
* @Version V1.0.1
*/
package com.igrow.mall.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName OperationAuth
 * @Description TODO【操作权限】
 * @Author Brights
 * @Date 2013-11-5 下午2:39:20
 */
@Target(ElementType.METHOD)       
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited   
public @interface OperationAuth {

	 /**
	* @Title code
	* @Description TODO【权限码】
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public String code() default "";  	
}
