/**
* @FileName WchatBean.java
* @Package com.fwchat.bean
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月13日 下午4:02:48
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatRequestBean
 * @Description TODO【wchat'请求bean】
 * @Author brights
 * @Date 2014年8月13日 下午4:02:48
 */
@XStreamAlias("xml") 
public class WchatRequestBean implements Serializable {
	private static final long serialVersionUID = 5710816977312005600L;

	@XStreamAlias("ToUserName")
	private String toUserName; //开发者微信号 
	
	@XStreamAlias("FromUserName")
	private String fromUserName;  //发送方帐号（一个OpenID） 
	
	@XStreamAlias("CreateTime")
	private Long createTime;  //消息创建时间 （整型） 
	
	@XStreamAlias("MsgType")
	private String msgType;  //text,image,voice,video,location,link,event
	
	@XStreamAlias("Content")
	private String content;  //文本消息内容 
	
	@XStreamAlias("MsgId")
	private String msgId;  //消息id，64位整型 
	
	@XStreamAlias("PicUrl")
	private String picUrl;  //图片链接 
	
	@XStreamAlias("MediaId")
	private String mediaId;  //图片消息媒体id， 语音消息媒体id，视频消息媒体id,可以调用多媒体文件下载接口拉取数据
	
	@XStreamAlias("Format")
	private String format;  //语音格式，如amr，speex等
	
	@XStreamAlias("ThumbMediaId")
	private String thumbMediaId;  //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。 
	
	@XStreamAlias("Location_X")
	private String locationX;  // 	地理位置维度 
	
	@XStreamAlias("Location_Y")
	private String locationY;  //地理位置经度 
	
	@XStreamAlias("Scale")
	private String scale;  // 	地图缩放大小 
	
	@XStreamAlias("Label")
	private String label;  //地理位置信息 
	
	@XStreamAlias("Title")
	private String title;  //消息标题 
	
	@XStreamAlias("Description")
	private String description;  //消息描述 
	
	@XStreamAlias("Url")
	private String url;  //消息链接 
	
	@XStreamAlias("Event")
	private String event;  //事件类型，subscribe(订阅)、unsubscribe(取消订阅) ,SCAN,LOCATION,CLICK,VIEW
	
	@XStreamAlias("EventKey")
	private String eventKey;  //事件KEY值，qrscene_为前缀，后面为二维码的参数值 , 	事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id 
	
	@XStreamAlias("Ticket")
	private String ticket;  //二维码的ticket，可用来换取二维码图片
	
	@XStreamAlias("Latitude")
	private String latitude;  //地理位置纬度 
	
	@XStreamAlias("Longitude")
	private String longitude;  //地理位置经度 
	
	@XStreamAlias("Precision")
	private String precision;  //地理位置精度 
	
	@XStreamAlias("Recognition")
	private String recognition;  //语音识别结果，UTF8编码 
	
	@XStreamAlias("CardId")
	private String cardId;  //卡券ID (领取卡券事件推送,删除卡券事件推送,卡券通过审核,卡券未通过审核)
	
	@XStreamAlias("FriendUserName")
	private String friendUserName;  //（领取卡券事件推送）赠送方账号（一个OpenID），"IsGiveByFriend”为1 时填写该参数。
	
	@XStreamAlias("IsGiveByFriend")
	private Integer isGiveByFriend;  //（领取卡券事件推送）是否为转赠，1 代表是，0 代表否
	
	@XStreamAlias("UserCardCode")
	private String userCardCode;  //1-（领取卡券事件推送）领取code 序列号。自定义code 及非自定义code的卡券被领取后都支持事件推送。2-（删除卡券事件推送）删除 -商户自定义code 值。非自定code 推送为空串
	
	@XStreamAlias("Status")
	private String status;   //模版消息发送状态  success（成功），failed:user block（用户设置拒绝接收公众号消息），送达由于其他原因失败时
	
	@XStreamAlias("MsgID")
	private String msgID;   //模版消息ID  failed: system failed

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * @return the createTime
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the thumbMediaId
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	/**
	 * @param thumbMediaId the thumbMediaId to set
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * @return the locationX
	 */
	public String getLocationX() {
		return locationX;
	}

	/**
	 * @param locationX the locationX to set
	 */
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	/**
	 * @return the locationY
	 */
	public String getLocationY() {
		return locationY;
	}

	/**
	 * @param locationY the locationY to set
	 */
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsgID() {
		return msgID;
	}

	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @return the friendUserName
	 */
	public String getFriendUserName() {
		return friendUserName;
	}

	/**
	 * @return the isGiveByFriend
	 */
	public Integer getIsGiveByFriend() {
		return isGiveByFriend;
	}

	/**
	 * @return the userCardCode
	 */
	public String getUserCardCode() {
		return userCardCode;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @param friendUserName the friendUserName to set
	 */
	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}

	/**
	 * @param isGiveByFriend the isGiveByFriend to set
	 */
	public void setIsGiveByFriend(Integer isGiveByFriend) {
		this.isGiveByFriend = isGiveByFriend;
	}

	/**
	 * @param userCardCode the userCardCode to set
	 */
	public void setUserCardCode(String userCardCode) {
		this.userCardCode = userCardCode;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the precision
	 */
	public String getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(String precision) {
		this.precision = precision;
	}

	/**
	 * @return the recognition
	 */
	public String getRecognition() {
		return recognition;
	}

	/**
	 * @param recognition the recognition to set
	 */
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	
	
	
}
