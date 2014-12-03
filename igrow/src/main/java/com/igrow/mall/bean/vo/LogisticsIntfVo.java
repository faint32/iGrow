/**
* @FileName LogisticsIntfVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:20:19
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LogisticsIntfVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Brights
 * @Date 2013-12-1 上午10:20:19
 */
@XStreamAlias("intf")
public class LogisticsIntfVo extends CommonIntfVo{
	private static final long serialVersionUID = 811817677520414248L;
	@XStreamAlias("d")
	private LogisticsListVo logisticsListVo;
	/**
	 * @return the logisticsListVo
	 */
	public LogisticsListVo getLogisticsListVo() {
		return logisticsListVo;
	}
	/**
	 * @param logisticsListVo the logisticsListVo to set
	 */
	public void setLogisticsListVo(LogisticsListVo logisticsListVo) {
		this.logisticsListVo = logisticsListVo;
	}
	

}
