/**
* @FileName WchatCardBatchgetRes.java
* @Package com.igrow.mall.bean.card.response
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午12:58:44
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardBatchgetRes
 * @Description TODO【批量查询卡列表】
 * @Author brights
 * @Date 2014年10月22日 下午12:58:44
 */
public class WchatCardBatchgetRes extends BaseRes implements Serializable {
	private static final long serialVersionUID = -7115748556675098862L;
	
	
	@XStreamAlias("card_id_list")
	@JsonProperty("card_id_list")
	private String[] cardIdList; //卡id 列表
	
	@XStreamAlias("total_num")
	@JsonProperty("total_num")
	private Integer totalNum; //该商户名下card_id 总数
	

	/**
	 * @return the cardIdList
	 */
	public String[] getCardIdList() {
		return cardIdList;
	}

	/**
	 * @param cardIdList the cardIdList to set
	 */
	public void setCardIdList(String[] cardIdList) {
		this.cardIdList = cardIdList;
	}

	/**
	 * @return the totalNum
	 */
	public Integer getTotalNum() {
		return totalNum;
	}

	/**
	 * @param totalNum the totalNum to set
	 */
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

}
