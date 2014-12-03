/**
* @FileName SequenceFactoryBean.java
* @Package com.igrow.mall.bean.sequence
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-27 下午8:03:11
* @Version V1.0.1
*/
package com.igrow.mall.bean.sequence;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName SequenceFactoryBean
 * @Description TODO【序列号生产器】
 * @Author Brights
 * @Date 2013-11-27 下午8:03:11
 */
public class SequenceFactoryBean implements FactoryBean<String> {
	private static long counter = 0;

	@Override
	  public synchronized String getObject() throws Exception {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " + ";
        String sequ = new DecimalFormat("00000000").format(counter ++);
        return date + sequ;
    }

	@Override
	public Class<String> getObjectType() {
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
	 public static void reset() {
	        SequenceFactoryBean.counter = 0;
	    }

}
