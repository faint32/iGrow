/**
* @FileName ClientRequestHandler.java
* @Package com.igrow.mall.common.payment.tenpay
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 上午11:26:39
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.tenpay;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @ClassName ClientRequestHandler
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年5月26日 上午11:26:39
 */
public class ClientRequestHandler extends PrepayIdRequestHandler {
	public ClientRequestHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public String getXmlBody() {
		StringBuffer sb = new StringBuffer();
		Set es = super.getAllParameters().entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (!"appkey".equals(k)) {
				sb.append("<" + k + ">" + v + "<" + k + ">" + "\r\n");
			}
		}
		return sb.toString();
	}
}
