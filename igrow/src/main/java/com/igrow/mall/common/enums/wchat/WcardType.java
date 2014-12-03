/**
* @FileName WcardType.java
* @Package com.igrow.mall.common.enums.wchat
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月26日 下午2:51:41
* @Version V1.0.1
*/
package com.igrow.mall.common.enums.wchat;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName WcardType
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年10月26日 下午2:51:41
 */
@Alias("EwcardType")
public enum WcardType {
	
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
	
	
	GENERAL_COUPON(0,"general_coupon","通用券"),
	GROUPON(1,"groupon","团购券"),
	DISCOUNT(2,"discount","折扣券"),
	GIFT(3,"gift","礼品券"),
	CASH(4,"cash","代金券"),
	MEMBER_CARD(5,"member_card","会员卡"),
	SCENIC_TICKET(6,"scenic_ticket","门票"),
	MOVIE_TICKET(7,"movie_ticket","电影票"),
	BOARDING_PASS(8,"boarding_pass","飞机票"),
	LUCKY_MONEY(9,"lucky_money","红包");
	
	
	private int value;
	private String desc;
	private String name;
	
	private WcardType(int value,String name,String desc){
		this.value=value;
		this.name=name;
		this.desc=desc;
	}
	
	public static WcardType nameOf(String name){
		for(WcardType wct : WcardType.values()){
			if(wct.getName().equalsIgnoreCase(name)){
				return wct;
			}
		}
		return null;
	}
	
	public static WcardType valueOf(Integer value){
		for(WcardType wct : WcardType.values()){
			if(value != null){
				if(value.intValue() == wct.getValue()){
					return wct;
				}
			}
		}
		return null;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


}
