/**
* @FileName WchatCardUpdateReq.java
* @Package com.igrow.mall.bean.card.request
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午1:45:30
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.request.card.BoardingPassInfoUpdate;
import com.igrow.mall.bean.card.request.card.MemberCardInfoUpdate;
import com.igrow.mall.bean.card.request.card.MovieTicketInfoUpdate;
import com.igrow.mall.bean.card.request.card.ScenicTicketInfoUpdate;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatCardUpdateReq
 * @Description TODO【更改卡券信息接口-请求】
 * @Author brights
 * @Date 2014年10月22日 下午1:45:30
 */
public class WchatCardUpdateReq implements Serializable {
	/*	支持更新特殊卡票（会员卡、飞机票、电影票、红包）中特定字段的信息。
		注：若卡券当前状态为审核失败或者审核成功，调用该接口更新信息后会重新送审，卡券状态变更
		为待审核。已被用户领取的卡券会实时更新票面信息。*/

	private static final long serialVersionUID = -5193748902670331455L;
	
	public final String  req_url = "https://api.weixin.qq.com/card/update?access_token=TOKEN"; //请求地址
	
	@XStreamAlias("card_id")
	@JsonProperty("card_id")
	private String cardId;  //卡券id
	
	
	@XStreamAlias("member_card")
	@JsonProperty("member_card")
	private MemberCardInfoUpdate memberCardInfo; //会员卡
	
	@XStreamAlias("scenic_ticket")
	@JsonProperty("scenic_ticket")
	private ScenicTicketInfoUpdate scenicTicketInfo; //门票
	
	@XStreamAlias("movie_ticket")
	@JsonProperty("movie_ticket")
	private MovieTicketInfoUpdate movieTicketInfo; //电影票
	
	@XStreamAlias("boarding_pass")
	@JsonProperty("boarding_pass")
	private BoardingPassInfoUpdate boardingPassInfo;  //飞机票

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the memberCardInfo
	 */
	public MemberCardInfoUpdate getMemberCardInfo() {
		return memberCardInfo;
	}

	/**
	 * @param memberCardInfo the memberCardInfo to set
	 */
	public void setMemberCardInfo(MemberCardInfoUpdate memberCardInfo) {
		this.memberCardInfo = memberCardInfo;
	}

	/**
	 * @return the scenicTicketInfo
	 */
	public ScenicTicketInfoUpdate getScenicTicketInfo() {
		return scenicTicketInfo;
	}

	/**
	 * @param scenicTicketInfo the scenicTicketInfo to set
	 */
	public void setScenicTicketInfo(ScenicTicketInfoUpdate scenicTicketInfo) {
		this.scenicTicketInfo = scenicTicketInfo;
	}

	/**
	 * @return the movieTicketInfo
	 */
	public MovieTicketInfoUpdate getMovieTicketInfo() {
		return movieTicketInfo;
	}

	/**
	 * @param movieTicketInfo the movieTicketInfo to set
	 */
	public void setMovieTicketInfo(MovieTicketInfoUpdate movieTicketInfo) {
		this.movieTicketInfo = movieTicketInfo;
	}

	/**
	 * @return the boardingPassInfo
	 */
	public BoardingPassInfoUpdate getBoardingPassInfo() {
		return boardingPassInfo;
	}

	/**
	 * @param boardingPassInfo the boardingPassInfo to set
	 */
	public void setBoardingPassInfo(BoardingPassInfoUpdate boardingPassInfo) {
		this.boardingPassInfo = boardingPassInfo;
	}
	
	
	
	

}
