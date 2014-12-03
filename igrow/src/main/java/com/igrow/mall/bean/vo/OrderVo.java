/**
* @FileName OrderVo.java
* @Package com.igrow.mall.bean.vo
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2013-12-1 上午10:36:10
* @Version V1.0.1
*/
package com.igrow.mall.bean.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName OrderVo
 * @Description TODO【订单数据视图】
 * @Author Brights
 * @Date 2013-12-1 上午10:36:10
 */
public class OrderVo implements Serializable {
	private static final long serialVersionUID = 7646497058541624757L;
	@XStreamAlias("oid")
	private String orderSn;
	@XStreamAlias("aid")
	private String addressSn;
	@XStreamAlias("contact")
	private String memberName;
	@XStreamAlias("phone")
	private String mobile;
	@XStreamAlias("city")
	private String areaSn;
	@XStreamAlias("road")
	private String adress;
	@XStreamAlias("itype")
	private String invoiceType;
	@XStreamAlias("itype")
	private String invoiceTopType;
	@XStreamAlias("invoice")
	private String invoiceTopName;
	@XStreamAlias("oship")
	private String deliveryMode;
	@XStreamAlias("pid")
	private String productSn;
	@XStreamAlias("pname")
	private String productName;
	@XStreamAlias("price")
	private String productPrice;
	@XStreamAlias("img")
	private String productImage;
	@XStreamAlias("ship")
	private String productdeliveryModes;
	@XStreamAlias("specifications")
	private String specification;
	@XStreamAlias("propertys")
	private String property;
	@XStreamAlias("hname")
	private String hotelName;
	@XStreamAlias("hadds")
	private String hotelAddress;
	@XStreamAlias("amount")
	private String count;
	@XStreamAlias("total")
	private String totalAmount;
	@XStreamAlias("ostatus")
	private String orderStatus;
	@XStreamAlias("time")
	private String orderTime;
	@XStreamAlias("paytype")
	private int payType; //0-线上支付，1-线下支付，2线上和线下
	//支付包支付key
	@XStreamAlias("partner")
	private String alipayParentid; //合作商ID
	@XStreamAlias("key")
	private String alipayKey; //支付宝key MD5加密用
	@XStreamAlias("seller") 
	private String alipayAccountId; //支付宝账号ID
	@XStreamAlias("account")
	private String alipayAccount; //支付宝账号
	@XStreamAlias("pubkey")
	private String publicKey; //公钥
	@XStreamAlias("prikey")
	private String privateKey; //私钥 
	//微信支付key
	@XStreamAlias("appid")
	private String appId; //在开放平台查看，标识申请的应用
	@XStreamAlias("appsecret")
	private String appSecret; //appSecret 是API 使用时的登录密码
	@XStreamAlias("partnerid")
	private String partnerId; //财付通商户身份的标识
	@XStreamAlias("partnerkey")
	private String partnerKey; //财付通商户权限密钥Key
	@XStreamAlias("paysignkey")
	private String paySignKey;//appKey
	@XStreamAlias("accesstoken")
	private String accessToken;//access_token
	@XStreamAlias("notify_url")
	private String paymentNotifyUrl;//支付回调地址
	
	@XStreamAlias("reduce")
	private String reduceCost; //优惠金额
	

	
	/**
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * @return the addressSn
	 */
	public String getAddressSn() {
		return addressSn;
	}
	/**
	 * @param addressSn the addressSn to set
	 */
	public void setAddressSn(String addressSn) {
		this.addressSn = addressSn;
	}
	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the areaSn
	 */
	public String getAreaSn() {
		return areaSn;
	}
	/**
	 * @param areaSn the areaSn to set
	 */
	public void setAreaSn(String areaSn) {
		this.areaSn = areaSn;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the invoiceType
	 */
	public String getInvoiceType() {
		return invoiceType;
	}
	/**
	 * @param invoiceType the invoiceType to set
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	/**
	 * @return the invoiceTopType
	 */
	public String getInvoiceTopType() {
		return invoiceTopType;
	}
	/**
	 * @param invoiceTopType the invoiceTopType to set
	 */
	public void setInvoiceTopType(String invoiceTopType) {
		this.invoiceTopType = invoiceTopType;
	}
	/**
	 * @return the invoiceTopName
	 */
	public String getInvoiceTopName() {
		return invoiceTopName;
	}
	/**
	 * @param invoiceTopName the invoiceTopName to set
	 */
	public void setInvoiceTopName(String invoiceTopName) {
		this.invoiceTopName = invoiceTopName;
	}
	/**
	 * @return the deliveryMode
	 */
	public String getDeliveryMode() {
		return deliveryMode;
	}
	/**
	 * @param deliveryMode the deliveryMode to set
	 */
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	/**
	 * @return the productSn
	 */
	public String getProductSn() {
		return productSn;
	}
	/**
	 * @param productSn the productSn to set
	 */
	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	public String getAlipayParentid() {
		return alipayParentid;
	}
	public void setAlipayParentid(String alipayParentid) {
		this.alipayParentid = alipayParentid;
	}
	public String getAlipayKey() {
		return alipayKey;
	}
	public void setAlipayKey(String alipayKey) {
		this.alipayKey = alipayKey;
	}
	public String getAlipayAccountId() {
		return alipayAccountId;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @return the reduceCost
	 */
	public String getReduceCost() {
		return reduceCost;
	}
	/**
	 * @param reduceCost the reduceCost to set
	 */
	public void setReduceCost(String reduceCost) {
		this.reduceCost = reduceCost;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getPaymentNotifyUrl() {
		return paymentNotifyUrl;
	}
	public void setPaymentNotifyUrl(String paymentNotifyUrl) {
		this.paymentNotifyUrl = paymentNotifyUrl;
	}
	public void setAlipayAccountId(String alipayAccountId) {
		this.alipayAccountId = alipayAccountId;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productPrice
	 */
	public String getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productImage
	 */
	public String getProductImage() {
		return productImage;
	}
	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	/**
	 * @return the productdeliveryModes
	 */
	public String getProductdeliveryModes() {
		return productdeliveryModes;
	}
	/**
	 * @param productdeliveryModes the productdeliveryModes to set
	 */
	public void setProductdeliveryModes(String productdeliveryModes) {
		this.productdeliveryModes = productdeliveryModes;
	}
	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}
	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	/**
	 * @return the hotelAddress
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}
	/**
	 * @param hotelAddress the hotelAddress to set
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the orderTime
	 */
	public String getOrderTime() {
		return orderTime;
	}
	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * @param appSecret the appSecret to set
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/**
	 * @return the partnerId
	 */
	public String getPartnerId() {
		return partnerId;
	}
	/**
	 * @param partnerId the partnerId to set
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	/**
	 * @return the partnerKey
	 */
	public String getPartnerKey() {
		return partnerKey;
	}
	/**
	 * @param partnerKey the partnerKey to set
	 */
	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}
	/**
	 * @return the paySignKey
	 */
	public String getPaySignKey() {
		return paySignKey;
	}
	/**
	 * @param paySignKey the paySignKey to set
	 */
	public void setPaySignKey(String paySignKey) {
		this.paySignKey = paySignKey;
	}
	
	
	

}
