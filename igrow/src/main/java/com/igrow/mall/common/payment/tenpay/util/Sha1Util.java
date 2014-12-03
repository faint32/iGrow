/**
* @FileName Sha1Util.java
* @Package com.igrow.mall.common.payment.tenpay.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年5月26日 上午11:16:21
* @Version V1.0.1
*/
package com.igrow.mall.common.payment.tenpay.util;
import java.security.MessageDigest;
/**
 * @ClassName Sha1Util
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2014年5月26日 上午11:16:21
 */
public class Sha1Util {
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes());

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
}
