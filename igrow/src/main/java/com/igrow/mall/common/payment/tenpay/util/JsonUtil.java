/**
* @FileName JsonUtil.java
* @Package com.igrow.mall.common.payment.tenpay.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 上午11:12:05
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.tenpay.util;
import org.json.JSONObject;

/**
 * @ClassName JsonUtil
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年5月26日 上午11:12:05
 */
public class JsonUtil {
	public static String getJsonValue(String rescontent, String key) {
		JSONObject jsonObject;
		String v = null;
		try {
			jsonObject = new JSONObject(rescontent);
			v = jsonObject.getString(key);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return v;
	}
}
