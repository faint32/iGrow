package com.igrow.mall.exception;

/**
* @ClassName BaseServiceException
* @Description TODO【Service层异常】
* @Author Brights
* @Date 2013-11-7 下午8:29:15
*/ 
public class BaseServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BaseServiceException(String errMessage) {
		super(errMessage);
	}

	public BaseServiceException(Throwable throwable) {
		super(throwable);
	}

	public BaseServiceException(Throwable throwable, String errMessage) {
		super(errMessage, throwable);
	}

}
