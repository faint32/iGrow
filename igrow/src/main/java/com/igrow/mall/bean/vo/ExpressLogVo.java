/**
* @FileName ExpressLogInfo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-11-1 下午2:13:36
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;
import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @ClassName ExpressLogVo
 * @Description TODO【快递日志】
 * @Author Brights
 * @Date 2013-11-1 下午2:13:36
 */
public class ExpressLogVo implements Serializable{
	private static final long serialVersionUID = -874051149491211443L;
	
	private String nu;
	private String message;
	private String ischeck;
	private String com;
	private String updatetime;
	private String status;
	private String condition;
	@XStreamImplicit(itemFieldName = "logInfo")
	private List<LogInfo> data;
	private String state;
	
	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIscheck() {
		return ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<LogInfo> getData() {
		return data;
	}

	public void setData(List<LogInfo> data) {
		this.data = data;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	* @ClassName LogInfo
	* @Description TODO【日志记录】
	* @Author Brights
	* @Date 2013-11-1 下午2:18:19
	*/ 
	public class LogInfo  implements Serializable{
		private static final long serialVersionUID = 7089394054034316869L;
		
		private String time;
		private String context;
		private String ftime;
		
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getFtime() {
			return ftime;
		}
		public void setFtime(String ftime) {
			this.ftime = ftime;
		}
		
	}



}
