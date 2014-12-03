/**
* @FileName InterfacesEnums.java
* @Package com.igrow.mall.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-10-18 下午5:35:09
* @Version V1.0.1
*/
package com.igrow.mall.common.enums;

import com.igrow.mall.common.constant.SystemConstants;

/**
 * @ClassName Intfs
 * @Description TODO【接口枚举】
 * @Author Brights
 * @Date 2013-10-18 下午5:35:09
 */
public enum Intfs {
	//会员用户
	VCODE(1,"","vcode","getsVcodeHandleImpl","获取验证码",2),
	REGISTER(2,"","register","registerHandleImpl","注册",2),
	LOGIN(3,"","login","loginHandleImpl","登录",2),
	EDITUSER(4,"","edituser","editAccountHandleImpl","修改账号",2),
	LOGOUT(5,"","logout","logoutHandleImpl","注销",-1),
	FEEDBACK(6,"","feedback","addMemberFeedbackHandleImpl","意见反馈",2),
	//会员收货地址
	ADDADDS(7,"","addadds","addAddressHandleImpl","添加收货地址",2),
	EDITADDS(8,"","editadds","editAddressHandleImpl","修改收货地址",2),
	DELADDS(9,"","deladds","deleteAddressHandleImpl","删除收货地址",2),
	ADDSLIST(10,"","addslist","findAddressListHandleImpl","收货地址列表",2),
	LASTADDS(11,"", "lastadds","defaultAddressHandleImpl","默认收货地址",2),
	//商品详情
	PRODUCTDETAILS(12,"","productdetails","getsProductDetailHandleImpl","商品详情",2),
	QRCODE(13,"","qrcode","getsProductDcodeHandleImpl","商品二维码",2),
	PRODUCTLIST(14,"","productlist","findProductListHandleImpl","商品列表",2),
	//商品扫描
	SCANNED(15,"","scanned","addScansHandleImpl","提交商品扫描",2),
	SCANLIST(16,"","scanlist","findScansListHandleImpl","扫描记录列表",2),
	DELSCAN(17,"","delscan","deleteScansHandleImpl","删除扫描记录",2),
	//商品收藏
	ADDCOLLECTION(18,"","addcollection","addFavoritesHandleImpl","加入收藏",2),
	COLLECTIONLIST(19,"","collectionlist","findFavoritesListHandleImpl","收藏记录列表",2),
	DELCOLLECTION(20,"","delcollection","deleteFavoritesHandleImpl","删除收藏记录",2),
	//订单
	SUBMITORDERS(21,"","submitorders","referOrderHandleImpl","提交订单",2),
	//直接下单接口
	DIRECTORDERS(22,"","directorders","directReferOrderHandleImpl","H5直接提交订单",2),
	ORDER(23,"","order","getsOrderDetailHandleImpl","订单详情",2),
	ORDERLIST(24,"","orderlist","findOrderListHandleImpl","订单记录列表",2),
	RECEIPT(25,"","receipt","receiptOrderHandleImpl","确认收货",2),
	LOGISTICS(26,"","logistics","findOrderLogisticListHandleImpl","查看物流",2),
	AFFTERMARKET(27,"","afftermarket","applyAftermarketHandleImpl","申请售后",2),
	SELLERINFO(28,"","sellerinfo","findSellerInfoHandleImpl","查询商户",2),
	SELFREFERORDERS(37,"","selfreferorders","selReferOrderHandleImpl","自助售卖提交订单",2),
	//订单,商品评价
	EVALUATE(29,"","evaluate","evaluateOrderHandleImpl","订单评价",2),
	GETEVALUATE(30,"","getevaluate","findOrderEvaluateListHandleImpl","获取订单评价列表",2),
	EVALUATELIST(31,"","evaluatelist","findProductEvaluateListHandleImpl","获取商品评价列表",2),
	//活动
	ACTIVITYLIST(32,"", "activitylist","findActiveListHandleImpl","活动列表",2),
	
	//提交合作申请
	ADDAPPLICATION(33,"","addapplication","addApplicationHandleImpl","提交合作申请",2),
	//商品扫描
	ADDSHARE(34,"","addshare","addShareHandleImpl","提交商品分享",2),
		
	//根据微信id获取用户编号
	GETMEMBERSN(35,"","getmembersn","getMemberSnHandleImpl","获取用户编号",2),
	//根据微信id获取用户是否中奖以及抽奖次数
	GETMEMBERWIN(36,"","getmemberwin","getMemberWinHandleImpl","获取用户是否中奖以及抽奖次数",2),
	//根据微信id获取用户是否中奖以及抽奖次数
	ADDACTIVELOTTERY(37,"","addactivelottery","addActiveLotteryHandleImpl","获取用户抽奖次数",2),
	
	
	//开锁
	OPENLOCK(38,"","openlock","openLockHandleImpl","开锁",2);
	
	private Intfs(int value,String code,String action,String impl,String desc,int status){
		this.value = value;
		this.code = code;
		this.action = action;
		this.impl = impl;
		this.desc = desc;
		this.status = status;
		
	}
	
	/**
	* @Title stringOf
	* @Description TODO【依据请求方法获取接口信息】
	* @param content
	* @return 
	* @Return Intfs 返回类型
	* @Throws 
	*/ 
	public static Intfs stringOf(String content){
		for(Intfs intf: Intfs.values()){
			StringBuffer sb = new StringBuffer();
			sb.append(SystemConstants.INTF_SERVICE_MAPPING_URL);
			sb.append(intf.getAction());
			sb.append(SystemConstants.INTF_ACTION_SUFFIX);
			if(content.contains(sb.toString())){
				return intf;
			}
		}
		return null;
	}
	
	/**
	* @Title valueOf
	* @Description TODO【依据value获取接口】
	* @param value
	* @return 
	* @Return Intfs 返回类型
	* @Throws 
	*/ 
	public static Intfs valueOf(int value){
		for(Intfs intf: Intfs.values()){
			if(value == intf.getValue()){
				return intf;
			}
		}
		return null;
	}
	
	private int value;
	private String code;
	private String action;
	private String impl;
	private String desc;
	private int status;//0-测试Demo，1-开发中，2-测试中，3-已完成
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImpl() {
		return impl;
	}
	public void setImpl(String impl) {
		this.impl = impl;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


}
