/**
* @FileName DateInfo.java
* @Package com.igrow.mall.bean.card.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 上午10:16:18
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName DateInfo
 * @Description TODO【使用日期，有效期的信息】
 * @Author brights
 * @Date 2014年10月22日 上午10:16:18
 */
@XStreamAlias("date_info")
public class DateInfo implements Serializable {
	private static final long serialVersionUID = 8986421625841368693L;
	
	@XStreamAlias("type")
	@JsonProperty("type")
	private Integer type;   // 1：固定日期区间，2：固定时长（自领取后按天算）
	
	@XStreamAlias("begin_timestamp")
	@JsonProperty("begin_timestamp")
	private Long beginTimestamp;   // 固定日期区间专用，表示起用时间。从1970 年1 月1 日00:00:00 至起用时间的秒数，最终需转换为字符串形态传入，下同。（单位为秒）
	
	@XStreamAlias("end_timestamp")
	@JsonProperty("end_timestamp")
	private Long endTimestamp;   //固定日期区间专用，表示结束时间。（单位为秒）
	
	@XStreamAlias("fixed_term")
	@JsonProperty("fixed_term")
	private Integer fixedTerm;   //固定时长专用，表示自领取后多少天内有效。（单位为天）
	
	@XStreamAlias("fixed_begin_term")
	@JsonProperty("fixed_begin_term")
	private Integer fixedBeginTerm;   // 固定时长专用，表示自领取后多少天开始生效。（单位为天）

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the beginTimestamp
	 */
	public Long getBeginTimestamp() {
		return beginTimestamp;
	}

	/**
	 * @param beginTimestamp the beginTimestamp to set
	 */
	public void setBeginTimestamp(Long beginTimestamp) {
		this.beginTimestamp = beginTimestamp;
	}

	/**
	 * @return the endTimestamp
	 */
	public Long getEndTimestamp() {
		return endTimestamp;
	}

	/**
	 * @param endTimestamp the endTimestamp to set
	 */
	public void setEndTimestamp(Long endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	/**
	 * @return the fixedTerm
	 */
	public Integer getFixedTerm() {
		return fixedTerm;
	}

	/**
	 * @param fixedTerm the fixedTerm to set
	 */
	public void setFixedTerm(Integer fixedTerm) {
		this.fixedTerm = fixedTerm;
	}

	/**
	 * @return the fixedBeginTerm
	 */
	public Integer getFixedBeginTerm() {
		return fixedBeginTerm;
	}

	/**
	 * @param fixedBeginTerm the fixedBeginTerm to set
	 */
	public void setFixedBeginTerm(Integer fixedBeginTerm) {
		this.fixedBeginTerm = fixedBeginTerm;
	}
	
	
	

}
