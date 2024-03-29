/**
* @FileName BasePayment.java
* @Package com.igrow.mall.common.payment.core
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-26 上午11:37:29
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.core;

import java.math.BigDecimal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 * @ClassName BasePayment
 * @Description TODO【支付基类】
 * @Author Brights
 * @Date 2013-11-26 上午11:37:29
 */
public abstract class BasePayment {
	
	protected static final String RESULT_URL = "";// 支付结果显示URL
	protected String id;// 支付产品标识
	protected String name;// 支付产品名称
	protected String description;// 支付产品描述
	protected String bargainorIdName;// 商户ID参数名称
	protected String bargainorKeyName;// 商户密钥参数名称
	protected String bargainorPrivateKeyName;// 商户密钥私钥参数名称
	protected String bargainorPublicKeyName;// 支付密钥公钥参数名称
	//protected CurrencyType[] currencyTypes;// 支持货币类型
	protected String logoPath;// 支付产品LOGO路径
	
	/**
	* @Title getPaymentSn
	* @Description TODO【获取支付编号】
	* @param httpServletRequest
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public abstract String getPaymentSn(HttpServletRequest httpServletRequest);
	
	/**
	* @Title getPaymentSn
	* @Description TODO【获取订单编号】
	* @param httpServletRequest
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public abstract String getOrderSn(HttpServletRequest httpServletRequest);
	

	/**
	* @Title getPaymentAmount
	* @Description TODO【获取支付金额（单位：元）】
	* @param httpServletRequest
	* @return 
	* @Return BigDecimal 返回类型
	* @Throws 
	*/ 
	public abstract BigDecimal getPaymentAmount(HttpServletRequest httpServletRequest);
	

	/**
	* @Title isPaySuccess
	* @Description TODO【判断是否支付成功】
	* @param httpServletRequest
	* @return 
	* @Return boolean 返回类型
	* @Throws 
	*/ 
	public abstract boolean isPaySuccess(HttpServletRequest httpServletRequest);
	

	/**
	 * 验证签名
	 * 
	 * @param httpServletRequest
	 *            httpServletRequest
	 * 
	 * @return 是否验证通过
	 */
	public abstract boolean verifySign(HttpServletRequest httpServletRequest);
	
	
	/**
	* @Title getParameterString
	* @Description TODO【根据参数集合组合参数字符串（忽略空值参数）】
	* @param parameterMap
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	protected String getParameterString(Map<String, String> parameterMap) {
		StringBuffer stringBuffer = new StringBuffer();
		for (String key : parameterMap.keySet()) {
			String value = parameterMap.get(key);
			if (StringUtils.isNotEmpty(value)) {
				stringBuffer.append("&" + key + "=" + value);
			}
		}
		if (stringBuffer.length() > 0) {
			stringBuffer.deleteCharAt(0);
		}
		return stringBuffer.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBargainorIdName() {
		return bargainorIdName;
	}

	public void setBargainorIdName(String bargainorIdName) {
		this.bargainorIdName = bargainorIdName;
	}

	public String getBargainorKeyName() {
		return bargainorKeyName;
	}

	public void setBargainorKeyName(String bargainorKeyName) {
		this.bargainorKeyName = bargainorKeyName;
	}
	
	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
}
