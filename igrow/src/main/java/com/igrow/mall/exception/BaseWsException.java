/**
* @FileName WsException.java
* @Package com.igrow.mall.exception
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-7 下午8:28:05
* @Version V1.0.1
*/
package com.igrow.mall.exception;

/**
 * @ClassName BaseWsException
 * @Description TODO【Ws层异常】
 * @Author Brights
 * @Date 2013-11-7 下午8:28:05
 */
public class BaseWsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public BaseWsException(String errMessage) {
		super(errMessage);
	}

	public BaseWsException(Throwable throwable) {
		super(throwable);
	}

	public BaseWsException(Throwable throwable, String errMessage) {
		super(errMessage, throwable);
	}

}
