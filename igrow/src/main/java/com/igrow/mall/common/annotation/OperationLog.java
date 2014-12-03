/**
* @FileName OperationLog.java
* @Package com.igrow.mall.common.annotation
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-5 下午2:38:24
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
 * @ClassName OperationLog
 * @Description TODO【操作日志】
 * @Author Brights
 * @Date 2013-11-5 下午2:38:24
 */
@Target(ElementType.METHOD)       
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited     
public @interface OperationLog {  
	
    /**
    * @Title type
    * @Description TODO【日志操作类型】
    * @return 
    * @Return String 返回类型
    * @Throws 
    */ 
    public String type() default "";  
     
    /**
    * @Title name
    * @Description TODO【日志操作名称】
    * @return 
    * @Return String 返回类型
    * @Throws 
    */ 
    public String name() default "";  


}
