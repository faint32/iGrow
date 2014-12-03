/**
* @FileName Event.java
* @Package com.fwchat.common.enums
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月13日 下午5:02:05
* @Version V1.0.1
*/
package com.igrow.mall.common.enums.wchat;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Wevent
 * @Description TODO【事件类型】
 * @Author brights
 * @Date 2014年8月13日 下午5:02:05
 */
@Alias("Ewevent")
public enum Wevent {
	
	SUBSCRIBE(0,"subscribe"),
	UNSUBSCRIBE(1,"unsubscribe"),
	SCAN(2,"scan"),
	LOCATION(3,"location"),
	CLICK(4,"click"),
	VIEW(5,"view"),
	SCANCODE_PUSH(6,"scancode_push"), //扫码推事件
	SCANCODE_WAITMSG(7,"scancode_waitmsg"), //扫码推事件且弹出“消息接收中”提示框
	PIC_SYSPHOTO(8,"pic_sysphoto"), //弹出系统拍照发图
	PIC_PHOTO_OR_ALBUM(9,"pic_photo_or_album"), //弹出拍照或者相册发图
	PIC_WEIXIN(10,"pic_weixin"), //弹出微信相册发图器
	LOCATION_SELECT(11,"pic_weixin"), //弹出地理位置选择器
	CARD_PASS_CHECK(12,"card_pass_check"), //生成的卡券通过审核时，审核通过事件推送
	CARD_NOT_PASS_CHECK(13,"card_not_pass_check"), //生成的卡券通过审核时，审核未通过事件推送
	USER_GET_CARD(14,"user_get_card"), //用户在领取卡券时，领取卡券事件推送
	USER_DEL_CARD(14,"user_del_card"), //用户在领取卡券时，领取卡券事件推送
	TEMPLATE_SEND_JOB_FINISH(15,"templatesendjobfinish"), //在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知
	;
	
		private int value;
		private String desc;
		
		private Wevent(int value,String desc){
			this.value=value;
			this.desc=desc;
		}

		/**
		 * @return the value
		 */
		public int getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * @return the desc
		 */
		public String getDesc() {
			return desc;
		}

		/**
		 * @param desc the desc to set
		 */
		public void setDesc(String desc) {
			this.desc = desc;
		}
}
