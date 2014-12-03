/**
* @FileName SequenceResetJob.java
* @Package com.igrow.mall.bean.sequence
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-27 下午8:05:28
* @Version V1.0.1
*/
package com.igrow.mall.bean.sequence;

/**
 * @ClassName SequenceResetJob
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-11-27 下午8:05:28
 */
public class SequenceResetJob {
	 public void execute() {
	        SequenceFactoryBean.reset();
	    }
}
