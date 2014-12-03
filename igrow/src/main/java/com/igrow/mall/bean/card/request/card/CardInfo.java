/**
* @FileName Card.java
* @Package com.igrow.mall.bean.card.request.card
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 上午10:40:01
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.request.card;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName Card
 * @Description TODO【卡券】
 * @Author brights
 * @Date 2014年10月24日 上午10:40:01
 */
@XStreamAlias("card")
public class CardInfo implements Serializable {
	private static final long serialVersionUID = -6303183639099814650L;
	
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
	private GeneralCouponInfoAdd generalCouponInfo; //通用券
	
	@XStreamAlias("groupon")
	@JsonProperty("groupon")
	private GrouponInfoAdd grouponInfo; //团购券
	
	@XStreamAlias("discount")
	@JsonProperty("discount")
	private DiscountInfoAdd discountInfo; //折扣券
	
	@XStreamAlias("gift")
	@JsonProperty("gift")
	private GiftInfoAdd giftInfo; //礼品券
	
	@XStreamAlias("cash")
	@JsonProperty("cash")
	private CashInfoAdd cash;  //代金券
	
	@XStreamAlias("member_card")
	@JsonProperty("member_card")
	private MemberCardInfoAdd memberCardInfo; //会员卡
	
	@XStreamAlias("scenic_ticket")
	@JsonProperty("scenic_ticket")
	private ScenicTicketInfoAdd scenicTicketInfo; //门票
	
	@XStreamAlias("movie_ticket")
	@JsonProperty("movie_ticket")
	private MovieTicketInfoAdd movieTicketInfo; //电影票
	
	@XStreamAlias("boarding_pass")
	@JsonProperty("boarding_pass")
	private BoardingPassInfoAdd boardingPassInfo;  //飞机票
	
	@XStreamAlias("lucky_money")
	@JsonProperty("lucky_money")
	private LuckyMoneyInfoAdd luckyMoneyInfo;  //红包

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the generalCouponInfo
	 */
	public GeneralCouponInfoAdd getGeneralCouponInfo() {
		return generalCouponInfo;
	}

	/**
	 * @param generalCouponInfo the generalCouponInfo to set
	 */
	public void setGeneralCouponInfo(GeneralCouponInfoAdd generalCouponInfo) {
		this.generalCouponInfo = generalCouponInfo;
	}

	/**
	 * @return the grouponInfo
	 */
	public GrouponInfoAdd getGrouponInfo() {
		return grouponInfo;
	}

	/**
	 * @param grouponInfo the grouponInfo to set
	 */
	public void setGrouponInfo(GrouponInfoAdd grouponInfo) {
		this.grouponInfo = grouponInfo;
	}

	/**
	 * @return the discountInfo
	 */
	public DiscountInfoAdd getDiscountInfo() {
		return discountInfo;
	}

	/**
	 * @param discountInfo the discountInfo to set
	 */
	public void setDiscountInfo(DiscountInfoAdd discountInfo) {
		this.discountInfo = discountInfo;
	}

	/**
	 * @return the giftInfo
	 */
	public GiftInfoAdd getGiftInfo() {
		return giftInfo;
	}

	/**
	 * @param giftInfo the giftInfo to set
	 */
	public void setGiftInfo(GiftInfoAdd giftInfo) {
		this.giftInfo = giftInfo;
	}

	/**
	 * @return the cash
	 */
	public CashInfoAdd getCash() {
		return cash;
	}

	/**
	 * @param cash the cash to set
	 */
	public void setCash(CashInfoAdd cash) {
		this.cash = cash;
	}

	/**
	 * @return the memberCardInfo
	 */
	public MemberCardInfoAdd getMemberCardInfo() {
		return memberCardInfo;
	}

	/**
	 * @param memberCardInfo the memberCardInfo to set
	 */
	public void setMemberCardInfo(MemberCardInfoAdd memberCardInfo) {
		this.memberCardInfo = memberCardInfo;
	}

	/**
	 * @return the scenicTicketInfo
	 */
	public ScenicTicketInfoAdd getScenicTicketInfo() {
		return scenicTicketInfo;
	}

	/**
	 * @param scenicTicketInfo the scenicTicketInfo to set
	 */
	public void setScenicTicketInfo(ScenicTicketInfoAdd scenicTicketInfo) {
		this.scenicTicketInfo = scenicTicketInfo;
	}

	/**
	 * @return the movieTicketInfo
	 */
	public MovieTicketInfoAdd getMovieTicketInfo() {
		return movieTicketInfo;
	}

	/**
	 * @param movieTicketInfo the movieTicketInfo to set
	 */
	public void setMovieTicketInfo(MovieTicketInfoAdd movieTicketInfo) {
		this.movieTicketInfo = movieTicketInfo;
	}

	/**
	 * @return the boardingPassInfo
	 */
	public BoardingPassInfoAdd getBoardingPassInfo() {
		return boardingPassInfo;
	}

	/**
	 * @param boardingPassInfo the boardingPassInfo to set
	 */
	public void setBoardingPassInfo(BoardingPassInfoAdd boardingPassInfo) {
		this.boardingPassInfo = boardingPassInfo;
	}

	/**
	 * @return the luckyMoneyInfo
	 */
	public LuckyMoneyInfoAdd getLuckyMoneyInfo() {
		return luckyMoneyInfo;
	}

	/**
	 * @param luckyMoneyInfo the luckyMoneyInfo to set
	 */
	public void setLuckyMoneyInfo(LuckyMoneyInfoAdd luckyMoneyInfo) {
		this.luckyMoneyInfo = luckyMoneyInfo;
	}
	

}
