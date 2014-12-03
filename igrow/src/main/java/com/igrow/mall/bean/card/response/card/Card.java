/**
* @FileName Card.java
* @Package com.igrow.mall.bean.card.response.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午1:10:16
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.response.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.igrow.mall.bean.card.response.card.BoardingPassInfo;
import com.igrow.mall.bean.card.response.card.CashInfo;
import com.igrow.mall.bean.card.response.card.DiscountInfo;
import com.igrow.mall.bean.card.response.card.GeneralCouponInfo;
import com.igrow.mall.bean.card.response.card.GiftInfo;
import com.igrow.mall.bean.card.response.card.GrouponInfo;
import com.igrow.mall.bean.card.response.card.LuckyMoneyInfo;
import com.igrow.mall.bean.card.response.card.MemberCardInfo;
import com.igrow.mall.bean.card.response.card.MovieTicketInfo;
import com.igrow.mall.bean.card.response.card.ScenicTicketInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName Card
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月22日 下午1:10:16
 */
public class Card implements Serializable {
	private static final long serialVersionUID = -8770442873453710298L;
	
	/*卡券类型。
	通用券：GENERAL_COUPON;
	团购券：GROUPON;
	折扣券：DISCOUNT;
	礼品券：GIFT;
	代金券：CASH;
	会员卡：MEMBER_CARD;
	门票：SCENIC_TICKET；
	电影票：MOVIE_TICKET；
	飞机票：BOARDING_PASS；
	红包: LUCKY_MONEY；*/
	@XStreamAlias("card_type")
	@JsonProperty("card_type")
	private String cardType;
	
	@XStreamAlias("general_coupon")
	@JsonProperty("general_coupon")
	private GeneralCouponInfo generalCouponInfo; //通用券
	
	@XStreamAlias("groupon")
	@JsonProperty("groupon")
	private GrouponInfo grouponInfo; //团购券
	
	@XStreamAlias("discount")
	@JsonProperty("discount")
	private DiscountInfo discountInfo; //折扣券
	
	@XStreamAlias("gift")
	@JsonProperty("gift")
	private GiftInfo giftInfo; //礼品券
	
	@XStreamAlias("cash")
	@JsonProperty("cash")
	private CashInfo cash;  //代金券
	
	@XStreamAlias("member_card")
	@JsonProperty("member_card")
	private MemberCardInfo memberCardInfo; //会员卡
	
	@XStreamAlias("scenic_ticket")
	@JsonProperty("scenic_ticket")
	private ScenicTicketInfo scenicTicketInfo; //门票
	
	@XStreamAlias("movie_ticket")
	@JsonProperty("movie_ticket")
	private MovieTicketInfo movieTicketInfo; //电影票
	
	@XStreamAlias("boarding_pass")
	@JsonProperty("boarding_pass")
	private BoardingPassInfo boardingPassInfo;  //飞机票
	
	@XStreamAlias("lucky_money")
	@JsonProperty("lucky_money")
	private LuckyMoneyInfo luckyMoneyInfo;  //红包

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @return the generalCouponInfo
	 */
	public GeneralCouponInfo getGeneralCouponInfo() {
		return generalCouponInfo;
	}

	/**
	 * @return the grouponInfo
	 */
	public GrouponInfo getGrouponInfo() {
		return grouponInfo;
	}

	/**
	 * @return the discountInfo
	 */
	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	/**
	 * @return the giftInfo
	 */
	public GiftInfo getGiftInfo() {
		return giftInfo;
	}

	/**
	 * @return the cash
	 */
	public CashInfo getCash() {
		return cash;
	}

	/**
	 * @return the memberCardInfo
	 */
	public MemberCardInfo getMemberCardInfo() {
		return memberCardInfo;
	}

	/**
	 * @return the scenicTicketInfo
	 */
	public ScenicTicketInfo getScenicTicketInfo() {
		return scenicTicketInfo;
	}

	/**
	 * @return the movieTicketInfo
	 */
	public MovieTicketInfo getMovieTicketInfo() {
		return movieTicketInfo;
	}

	/**
	 * @return the boardingPassInfo
	 */
	public BoardingPassInfo getBoardingPassInfo() {
		return boardingPassInfo;
	}

	/**
	 * @return the luckyMoneyInfo
	 */
	public LuckyMoneyInfo getLuckyMoneyInfo() {
		return luckyMoneyInfo;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @param generalCouponInfo the generalCouponInfo to set
	 */
	public void setGeneralCouponInfo(GeneralCouponInfo generalCouponInfo) {
		this.generalCouponInfo = generalCouponInfo;
	}

	/**
	 * @param grouponInfo the grouponInfo to set
	 */
	public void setGrouponInfo(GrouponInfo grouponInfo) {
		this.grouponInfo = grouponInfo;
	}

	/**
	 * @param discountInfo the discountInfo to set
	 */
	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}

	/**
	 * @param giftInfo the giftInfo to set
	 */
	public void setGiftInfo(GiftInfo giftInfo) {
		this.giftInfo = giftInfo;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(CashInfo cash) {
		this.cash = cash;
	}

	/**
	 * @param memberCardInfo the memberCardInfo to set
	 */
	public void setMemberCardInfo(MemberCardInfo memberCardInfo) {
		this.memberCardInfo = memberCardInfo;
	}

	/**
	 * @param scenicTicketInfo the scenicTicketInfo to set
	 */
	public void setScenicTicketInfo(ScenicTicketInfo scenicTicketInfo) {
		this.scenicTicketInfo = scenicTicketInfo;
	}

	/**
	 * @param movieTicketInfo the movieTicketInfo to set
	 */
	public void setMovieTicketInfo(MovieTicketInfo movieTicketInfo) {
		this.movieTicketInfo = movieTicketInfo;
	}

	/**
	 * @param boardingPassInfo the boardingPassInfo to set
	 */
	public void setBoardingPassInfo(BoardingPassInfo boardingPassInfo) {
		this.boardingPassInfo = boardingPassInfo;
	}

	/**
	 * @param luckyMoneyInfo the luckyMoneyInfo to set
	 */
	public void setLuckyMoneyInfo(LuckyMoneyInfo luckyMoneyInfo) {
		this.luckyMoneyInfo = luckyMoneyInfo;
	}

}
