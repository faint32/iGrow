package com.igrow.mall.bean.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
* @ClassName Setting
* @Description TODO【系统设置】
* @Author Brights
* @Date 2013-11-16 下午1:41:23
*/ 
@Configuration
public class Setting {
	@Value("${system.admin.name}")
	private String systemName;
	@Value("${system.mall.name}")
	private String systemMallname; //系统商城
	@Value("${system.phone}")
	private String systemPhone; //联系电话
	@Value("${system.mobile}")
	private String systemMobile; //联系电话
	@Value("${image.server.path}")
	private String imageServerPath; //图片服务器路径
	@Value("${email.from}")
	private String emailFrom;//平台邮件发送地址
	@Value("${email.to}")
	private String emailTo;//平台提醒邮件接收地址
	@Value("${delivery.url.template}")
	private String deliveryUrlTemplate; //快递请求URL
	@Value("${delivery.url.template.name}")
	private String deliveryUrlTemplateName; //快递请求URL模板
	@Value("${mobile.url.template}")
	private String mobileUrlTemplate; //快递请求URL
	@Value("${mobile.url.template.name}")
	private String mobileUrlTemplateName; //快递请求URL模板
	@Value("${payment.log.url}")
	private String paymentLogUrl; //日志输出路径
	@Value("${payment.log.filename}")
	private String paymentLogFilename; //日志文件名
	@Value("${payment.log.status}")
	private boolean paymentLogStatus; //是否启用日志
	@Value("${system.sms.signature}")
	private String systemSmsSignature;//系统短信签名
	@Value("${system.mall.url}")
	private String systemMallUrl;//系统短信签名
	@Value("${system.login.sms.vcode}")
	private String systemLoginSmsVcode;//登录短信验证码
	@Value("${sms.supplier}")
	private String smsSupplier; //短信供应商
	@Value("${system.realUrl}")
	private String sysRealUrl; //项目ip
	@Value("${order.sn.prefix}")
	private String orderSnPrefix; //订单号前缀
	@Value("${image.real.path}")
	private String imgRealUrl; //图片真实路径
	@Value("${image.temp.path}")
	private String imgTempUrl; //图片上传的临时路径
	
	@Value("${alipay.partner}")
	private String alipayPartner; //支付宝合作ID
	@Value("${alipay.key}")
	private String alipayKey; //支付宝KEY
	@Value("${alipay.email}")
	private String alipayEmail; //支付宝账户ID地址邮件地址
	@Value("${alipay.account.name}")
	private String alipayAccountName; //支付宝账户名称
	
	
	
	public String getSystemMallname() {
		return systemMallname;
	}
	public String getImageServerPath() {
		return imageServerPath;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setSystemMallname(String systemMallname) {
		this.systemMallname = systemMallname;
	}
	public void setImageServerPath(String imageServerPath) {
		this.imageServerPath = imageServerPath;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	/**
	 * @return the emailTo
	 */
	public String getEmailTo() {
		return emailTo;
	}
	/**
	 * @return the systemMobile
	 */
	public String getSystemMobile() {
		return systemMobile;
	}
	/**
	 * @param systemMobile the systemMobile to set
	 */
	public void setSystemMobile(String systemMobile) {
		this.systemMobile = systemMobile;
	}
	/**
	 * @param emailTo the emailTo to set
	 */
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getDeliveryUrlTemplateName() {
		return deliveryUrlTemplateName;
	}
	public void setDeliveryUrlTemplateName(String deliveryUrlTemplateName) {
		this.deliveryUrlTemplateName = deliveryUrlTemplateName;
	}
	public String getDeliveryUrlTemplate() {
		return deliveryUrlTemplate;
	}
	public void setDeliveryUrlTemplate(String deliveryUrlTemplate) {
		this.deliveryUrlTemplate = deliveryUrlTemplate;
	}
	/**
	 * @return the mobileUrlTemplateName
	 */
	public String getMobileUrlTemplateName() {
		return mobileUrlTemplateName;
	}
	/**
	 * @param mobileUrlTemplateName the mobileUrlTemplateName to set
	 */
	public void setMobileUrlTemplateName(String mobileUrlTemplateName) {
		this.mobileUrlTemplateName = mobileUrlTemplateName;
	}
	/**
	 * @return the mobileUrlTemplate
	 */
	public String getMobileUrlTemplate() {
		return mobileUrlTemplate;
	}
	/**
	 * @param mobileUrlTemplate the mobileUrlTemplate to set
	 */
	public void setMobileUrlTemplate(String mobileUrlTemplate) {
		this.mobileUrlTemplate = mobileUrlTemplate;
	}
	public String getPaymentLogUrl() {
		return paymentLogUrl;
	}
	public void setPaymentLogUrl(String paymentLogUrl) {
		this.paymentLogUrl = paymentLogUrl;
	}
	public String getPaymentLogFilename() {
		return paymentLogFilename;
	}
	public void setPaymentLogFilename(String paymentLogFilename) {
		this.paymentLogFilename = paymentLogFilename;
	}
	public boolean isPaymentLogStatus() {
		return paymentLogStatus;
	}
	public void setPaymentLogStatus(boolean paymentLogStatus) {
		this.paymentLogStatus = paymentLogStatus;
	}
	public String getSystemSmsSignature() {
		return systemSmsSignature;
	}
	public String getSystemLoginSmsVcode() {
		return systemLoginSmsVcode;
	}
	public void setSystemLoginSmsVcode(String systemLoginSmsVcode) {
		this.systemLoginSmsVcode = systemLoginSmsVcode;
	}
	public String getSmsSupplier() {
		return smsSupplier;
	}
	public void setSmsSupplier(String smsSupplier) {
		this.smsSupplier = smsSupplier;
	}
	public String getSystemMallUrl() {
		return systemMallUrl;
	}
	public void setSystemMallUrl(String systemMallUrl) {
		this.systemMallUrl = systemMallUrl;
	}
	public String getOrderSnPrefix() {
		return orderSnPrefix;
	}
	public void setOrderSnPrefix(String orderSnPrefix) {
		this.orderSnPrefix = orderSnPrefix;
	}
	public void setSystemSmsSignature(String systemSmsSignature) {
		this.systemSmsSignature = systemSmsSignature;
	}
	public String getSystemPhone() {
		return systemPhone;
	}
	public void setSystemPhone(String systemPhone) {
		this.systemPhone = systemPhone;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getSysRealUrl() {
		return sysRealUrl;
	}
	public void setSysRealUrl(String smsRealUrl) {
		this.sysRealUrl = smsRealUrl;
	}
	public String getImgRealUrl() {
		return imgRealUrl;
	}
	public void setImgRealUrl(String imgRealUrl) {
		this.imgRealUrl = imgRealUrl;
	}
	public String getImgTempUrl() {
		return imgTempUrl;
	}
	public void setImgTempUrl(String imgTempUrl) {
		this.imgTempUrl = imgTempUrl;
	}
	public String getAlipayPartner() {
		return alipayPartner;
	}
	public String getAlipayKey() {
		return alipayKey;
	}
	public String getAlipayEmail() {
		return alipayEmail;
	}
	public String getAlipayAccountName() {
		return alipayAccountName;
	}
	public void setAlipayPartner(String alipayPartner) {
		this.alipayPartner = alipayPartner;
	}
	public void setAlipayKey(String alipayKey) {
		this.alipayKey = alipayKey;
	}
	public void setAlipayEmail(String alipayEmail) {
		this.alipayEmail = alipayEmail;
	}
	public void setAlipayAccountName(String alipayAccountName) {
		this.alipayAccountName = alipayAccountName;
	}
	
	
	
}
