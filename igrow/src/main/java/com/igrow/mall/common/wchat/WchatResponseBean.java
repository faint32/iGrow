/**
* @FileName WchatResponseBean.java
* @Package com.fwchat.bean
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月14日 下午1:27:30
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName WchatResponseBean
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author brights
 * @Date 2014年8月14日 下午1:27:30
 */
@XStreamAlias("xml") 
public class WchatResponseBean implements Serializable {
	private static final long serialVersionUID = 8064094916767527484L;
	
	@XStreamAlias("ToUserName")
	private String toUserName; //接收方帐号（收到的OpenID）
	
	@XStreamAlias("FromUserName")
	private String fromUserName;  //开发者微信号 
	
	@XStreamAlias("CreateTime")
	private Long createTime;  //消息创建时间 （整型） 
	
	@XStreamAlias("MsgType")
	private String msgType;  //text,image,voice,video,location,link,event,news
	
	@XStreamAlias("Content")
	private String content;  //文本消息内容 
	
	@XStreamAlias("ArticleCount")
	private Integer articleCount; //图文消息个数，限制为10条以内 
	
	@XStreamAlias("TransInfo") 
	private TransInfo transInfo;  //转发
	
	@XStreamAlias("Articles")
	private List<Article> articles;  //多图文
	
	@XStreamAlias("CardId")
	private String cardId;  //卡券ID (领取卡券事件推送,删除卡券事件推送,卡券通过审核,卡券未通过审核)
	
	@XStreamAlias("FriendUserName")
	private String friendUserName;  //（领取卡券事件推送）赠送方账号（一个OpenID），"IsGiveByFriend”为1 时填写该参数。
	
	@XStreamAlias("IsGiveByFriend")
	private String isGiveByFriend;  //（领取卡券事件推送）是否为转赠，1 代表是，0 代表否
	
	@XStreamAlias("UserCardCode")
	private String userCardCode;  //1-（领取卡券事件推送）领取code 序列号。自定义code 及非自定义code的卡券被领取后都支持事件推送。2-（删除卡券事件推送）删除 -商户自定义code 值。非自定code 推送为空串
	
	@XStreamAlias("TransInfo") 
	public class TransInfo implements Serializable{
		private static final long serialVersionUID = 1947853477875970107L;
		
		@XStreamAlias("KfAccount")
		private String kfAccount;  //客服账户

		/**
		 * @return the kfAccount
		 */
		public String getKfAccount() {
			return kfAccount;
		}

		/**
		 * @param kfAccount the kfAccount to set
		 */
		public void setKfAccount(String kfAccount) {
			this.kfAccount = kfAccount;
		}
		
	}
	
	@XStreamAlias("item") 
	public class Article implements Serializable{
		private static final long serialVersionUID = 133648699148713746L;
		
		@XStreamAlias("Title")
		private String title;  //标题
		
		@XStreamAlias("Description")
		private String description;  //图文消息描述 
		
		@XStreamAlias("PicUrl")
		private String picUrl;  //图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 
		
		@XStreamAlias("Url")
		private String url;  //点击图文消息跳转链接 

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
	

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

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

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	/**
	 * @return the transInfo
	 */
	public TransInfo getTransInfo() {
		return transInfo;
	}

	/**
	 * @param transInfo the transInfo to set
	 */
	public void setTransInfo(TransInfo transInfo) {
		this.transInfo = transInfo;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getFriendUserName() {
		return friendUserName;
	}

	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}

	public String getIsGiveByFriend() {
		return isGiveByFriend;
	}

	public void setIsGiveByFriend(String isGiveByFriend) {
		this.isGiveByFriend = isGiveByFriend;
	}

	public String getUserCardCode() {
		return userCardCode;
	}

	public void setUserCardCode(String userCardCode) {
		this.userCardCode = userCardCode;
	}

}
