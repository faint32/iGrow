/**
* @FileName WchatContentServiceImpl.java
* @Package com.fwchat.service.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月14日 下午2:28:28
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.impl;

import java.util.Date;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.card.request.WchatCardGetReq;
import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.entity.WchatCardInfo;
import com.igrow.mall.bean.entity.WchatOctConfInfo;
import com.igrow.mall.bean.entity.WchatOctCustomSendDetail;
import com.igrow.mall.bean.entity.WchatOctMenuInfo;
import com.igrow.mall.common.constant.WchatConfConstant;
import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.enums.wchat.WcardType;
import com.igrow.mall.common.wchat.WchatContentReplayProcess;
import com.igrow.mall.common.wchat.WchatRequestBean;
import com.igrow.mall.service.admin.intf.WchatCardInfoService;
import com.igrow.mall.service.admin.intf.WchatCardMemberService;
import com.igrow.mall.service.admin.intf.WchatOctConfService;
import com.igrow.mall.service.admin.intf.WchatOctCustomSendService;
import com.igrow.mall.service.admin.intf.WchatOctMenuService;
import com.igrow.mall.service.wchat.card.intf.WchatCardProcessService;
import com.igrow.mall.service.wchat.intf.WchatContentService;


/**
 * @ClassName WchatContentServiceImpl
 * @Description TODO【内容服务类接口实现】
 * @Author brights
 * @Date 2014年8月14日 下午2:28:28
 */
@Service("wchatContentServiceImpl")
public class WchatContentServiceImpl implements WchatContentService {
	
	@Resource(name = "wchatOctMenuServiceImpl")
	private WchatOctMenuService wchatOctMenuService;
	
	@Resource(name = "wchatOctConfServiceImpl")
	private WchatOctConfService wchatOctConfService;
	@Resource(name = "wchatOctCustomSendServiceImpl")
	private WchatOctCustomSendService wchatOctCustomSendService;
	@Resource(name = "wchatCardProcessServiceImpl")
	private WchatCardProcessService wchatCardProcessService;
	
	@Resource(name = "wchatCardInfoServiceImpl")
	private WchatCardInfoService 	wchatCardInfoService;
	@Resource(name = "wchatCardMemberServiceImpl")
	private WchatCardMemberService wchatCardMemberService;
	

	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	
	
	
	/**
	* @Title text
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#text()
	*/ 
	@Override
	public String text(WchatRequestBean wchatRequest) {
		WchatOctCustomSendDetail sendDetail = wchatOctCustomSendService.findLastBy(wchatRequest.getFromUserName());
		if(sendDetail != null){
			Date limitDate = DateUtils.addMinutes(sendDetail.getCreateDate(), 60); //60分钟内容有效
			WchatOctConfInfo  kfAccount = wchatOctConfService.findBySn(WchatConfConstant.default_kf_account_sn);
			System.out.println(""+kfAccount.getValue());
			if(limitDate.after(new Date())){
				//SupplierDesignerInfo supplierDesigner = supplierDesignerWs.find(sendDetail.getSupplierDesignerId());
				/*if(supplierDesigner  != null ){ 
					//设计状态处理
					if(supplierDesigner.getWchatKfStatus().endsWith("0")){ //离线
						//转发1克拉客服
						System.out.println("离线转发1克拉客服11");
						return WchatContentReplayProcess.transferCustomerService(wchatRequest, kfAccount.getValue()); //默认客服
					}else{
						if(supplierDesigner.getWchatKfAutoAccept() > supplierDesigner.getWchatKfAcceptedCase()){ //在线空闲
							System.out.println("转发设计师");
							return WchatContentReplayProcess.transferCustomerService(wchatRequest, supplierDesigner.getWchatKfAccount()); //转发设计师
						}else{//在线繁忙
							//转发1克拉客服
							System.out.println("繁忙转发1克拉客服");
							return WchatContentReplayProcess.transferCustomerService(wchatRequest, kfAccount.getValue()); //默认客服
						} 
					}
				}else{
					//转发1克拉客服
					System.out.println("繁忙转发1克拉客服");
					return WchatContentReplayProcess.transferCustomerService(wchatRequest, kfAccount.getValue()); //默认客服。
				}*/
			}else{
				//转发1克拉客服
				System.out.println("超出60分钟,转发到1克拉客服");
				return WchatContentReplayProcess.transferCustomerService(wchatRequest, kfAccount.getValue()); //默认客服
			}
		}
		System.out.println("系统自动回复文字");
		WchatOctConfInfo wchatOctConf = wchatOctConfService.findBySn(WchatConfConstant.subscribe_repaly_words_sn);
		String content =  wchatOctConf.getValue();
		return WchatContentReplayProcess.text(wchatRequest,content);
	}

	/**
	* @Title image
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#image()
	*/ 
	@Override
	public String image(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title voice
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#voice()
	*/ 
	@Override
	public String voice(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title video
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#video()
	*/ 
	@Override
	public String video(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title link
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#link()
	*/ 
	@Override
	public String link(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title locationMt
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#locationMt()
	*/ 
	@Override
	public String locationMt(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title subscribe
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#subscribe()
	*/ 
	@Override
	public String subscribe(WchatRequestBean wchatRequest) {
		if(StringUtils.isNotBlank(wchatRequest.getEventKey())){
			String eventKey = wchatRequest.getEventKey();
			System.out.println("eventKey=" + eventKey);
			String sceneId  = StringUtils.removeStartIgnoreCase(eventKey, WchatConstant.PREFIX_QRSCENE);
			System.out.println("sceneId=" + sceneId);
			if(StringUtils.isNotBlank(sceneId) && sceneId.length() >2){ //带参数的二微码关注
				/*if(sceneId.startsWith("1")){ //酒店商品列表
					HotelInfo hotel = new HotelInfo();
					hotel.setId(StringUtils.removeStartIgnoreCase(sceneId, "1"));
					HashMap values = new HashMap();
					values.put("hotelInfo", hotel);
					values.put("isAudit", AuditStatus.PASSED);
					values.put("status", 1);
					Pager pager = new Pager();
					pager.setOrder(Order.desc);
					pager.setOrderBy("pp.id");
					pager.setPageNumber(1);
					List<ProductShelvesInfo> productShelvesInfos = productShelvesWs.findListByPager(pager, values);
					if(productShelvesInfos != null && productShelvesInfos.size() > 0){
						return WchatContentReplayProcess.newsOfProductList(wchatRequest, "", productShelvesInfos);
					}
				}else if(sceneId.startsWith("2")){ //商品详情
					ProductShelvesInfo productShelvesInfo = productShelvesWs.find(StringUtils.removeStartIgnoreCase(sceneId, "2"));
					if(productShelvesInfo != null){
						return WchatContentReplayProcess.newsOfProduct(wchatRequest, "", productShelvesInfo);
					}
				}*/
			}
		}
		WchatOctConfInfo wchatOctConf = wchatOctConfService.findBySn(WchatConfConstant.subscribe_repaly_words_sn);
		return WchatContentReplayProcess.subscribe(wchatRequest,wchatOctConf.getValue());
	}

	/**
	* @Title unsubscribe
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#unsubscribe()
	*/ 
	@Override
	public String unsubscribe(WchatRequestBean wchatRequest) {
		return WchatContentReplayProcess.unsubscribe(wchatRequest);
	}

	/**
	* @Title scan
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#scan()
	*/ 
	@Override
	public String scan(WchatRequestBean wchatRequest) {
		if(StringUtils.isNotBlank(wchatRequest.getEventKey())){
			String sceneId = wchatRequest.getEventKey();
			System.out.println("sceneId=" + sceneId);
			if(StringUtils.isNotBlank(sceneId) && sceneId.length() >1){ //带参数的二微码已关注，扫描
				/*if(sceneId.startsWith("1")){ //酒店商品列表
					HotelInfo hotel = new HotelInfo();
					hotel.setId(StringUtils.removeStartIgnoreCase(sceneId, "1"));
					HashMap values = new HashMap();
					values.put("hotelInfo", hotel);
					values.put("isAudit", AuditStatus.PASSED);
					values.put("status", 1);
					Pager pager = new Pager();
					pager.setOrder(Order.desc);
					pager.setOrderBy("pp.id");
					pager.setPageNumber(1);
					List<ProductShelvesInfo> productShelvesInfos = productShelvesWs.findListByPager(pager, values);
					if(productShelvesInfos != null && productShelvesInfos.size() > 0){
						return WchatContentReplayProcess.newsOfProductList(wchatRequest, "", productShelvesInfos);
					}
				}else if(sceneId.startsWith("2")){ //商品详情
					ProductShelvesInfo productShelvesInfo = productShelvesWs.find(StringUtils.removeStartIgnoreCase(sceneId, "2"));
					if(productShelvesInfo != null){
						return WchatContentReplayProcess.newsOfProduct(wchatRequest, "", productShelvesInfo);
					}
				}*/
			}
		}
		return this.text(wchatRequest);
	}

	/**
	* @Title locationEn
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#locationEn()
	*/ 
	@Override
	public String locationEn(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title click
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#click()
	*/ 
	@Override
	public String click(WchatRequestBean wchatRequest) {
		if(wchatRequest != null && StringUtils.isNotBlank(wchatRequest.getEventKey())){
			System.out.println("key="+wchatRequest.getEventKey());
			WchatOctMenuInfo menu = 	wchatOctMenuService.findByKey(wchatRequest.getEventKey());
			if(menu != null && StringUtils.isNotBlank(menu.getSrcData())){
				return WchatContentReplayProcess.newsOfActive(wchatRequest, menu.getSrcData());
			}else{
				WchatOctConfInfo  kfAccount = wchatOctConfService.findBySn(wchatRequest.getEventKey());
				return WchatContentReplayProcess.text(wchatRequest, kfAccount.getValue());
			}
		}
		return null;
	}

	/**
	* @Title view
	* @Description 
	* @return
	* @see com.fwchat.service.intf.WchatContentService#view()
	*/ 
	@Override
	public String view(WchatRequestBean wchatRequest) {
		return this.text(wchatRequest);
	}

	/**
	* @Title cardPassCheck
	* @Description 
	* @param wchat
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatContentService#cardPassCheck(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public String cardPassCheck(WchatRequestBean wchatRequest) {
		WchatCardGetReq req = new WchatCardGetReq();
		req.setCardId(wchatRequest.getCardId());
		WchatCardGetRes res = wchatCardProcessService.get(req);
		if(res != null){
			wchatCardInfoService.cardPassCheck(res);
		}
		return null;
	}

	/**
	* @Title cardNotPassCheck
	* @Description 
	* @param wchat
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatContentService#cardNotPassCheck(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public String cardNotPassCheck(WchatRequestBean wchatRequest) {
		WchatCardGetReq req = new WchatCardGetReq();
		req.setCardId(wchatRequest.getCardId());
		WchatCardGetRes res = wchatCardProcessService.get(req);
		if(res != null){
			wchatCardInfoService.cardNotPassCheck(res);
		}
		return null;
	}

	/**
	* @Title userGetCard
	* @Description 
	* @param wchat
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatContentService#userGetCard(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public String userGetCard(WchatRequestBean wchatRequest) {
		String content = WchatConfConstant.card_user_get_content;
		String contenTemplateSn = "";
		if(wchatRequest.getIsGiveByFriend() != null){
			if(wchatRequest.getIsGiveByFriend().intValue() == 1){ //转赠
				content = WchatConfConstant.card_user_get_is_give_content;
				contenTemplateSn = WchatConfConstant.card_user_get_is_give;
			}else if(wchatRequest.getIsGiveByFriend().intValue() == 0){
				content = WchatConfConstant.card_user_get_content;
				contenTemplateSn = WchatConfConstant.card_user_get;
			}
		}
		WchatCardInfo cardInfo = wchatCardInfoService.findByCardId(wchatRequest.getCardId());
		if(cardInfo != null){
			WchatOctConfInfo wchatOctConf = wchatOctConfService.findBySn(contenTemplateSn);
			if(wchatOctConf != null && StringUtils.isNotBlank( wchatOctConf.getValue()) ){
				content = wchatOctConf.getValue();
				content = content.replaceAll("TITLE", cardInfo.getCardTitle());
				content = content.replaceAll("CARD", WcardType.valueOf(cardInfo.getCardType()).getDesc());
			}
		}
		//wchatCardMemberService.userGetCard(wchatRequest);
		//异步处理领取用户卡券
		addAsyncUserGetCardProcessTask(wchatRequest);
		return WchatContentReplayProcess.text(wchatRequest,content);
	}
	
	/**
	* @Title addAsyncUserGetCardProcessTask
	* @Description TODO【添加异步卡券用户领取处理方法】
	* @param wchatRequest 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void addAsyncUserGetCardProcessTask(final WchatRequestBean wchatRequest) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					if(wchatRequest.getIsGiveByFriend()  != null){
						if(wchatRequest.getIsGiveByFriend() == 0){ //领取卡券
							wchatCardMemberService.userGetCard(wchatRequest);
						}else if(wchatRequest.getIsGiveByFriend() == 1){ //领取好友转赠卡券
							wchatCardMemberService.userGetCardGiveByFriend(wchatRequest);
						}
					}
					//获取卡券最新数据
					cardPassCheck(wchatRequest);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title userDelCard
	* @Description 
	* @param wchat
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatContentService#userDelCard(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public String userDelCard(WchatRequestBean wchatRequest) {
		//异步处理删除用户卡券
		addAsyncUserDelCardProcessTask(wchatRequest);
		String content = WchatConfConstant.card_user_delete_content;
		//获取模版
		WchatCardInfo cardInfo = wchatCardInfoService.findByCardId(wchatRequest.getCardId());
		if(cardInfo != null){
			WchatOctConfInfo wchatOctConf = wchatOctConfService.findBySn(WchatConfConstant.card_user_delete);
			if(wchatOctConf != null && StringUtils.isNotBlank( wchatOctConf.getValue()) ){
				content = wchatOctConf.getValue();
				content = content.replaceAll("TITLE", cardInfo.getCardTitle());
				content = content.replaceAll("CARD", WcardType.valueOf(cardInfo.getCardType()).getDesc());
			}
		}
		wchatCardMemberService.userDelCard(wchatRequest);
		return WchatContentReplayProcess.text(wchatRequest,content);
	}
	
	/**
	* @Title addAsyncUserDelCardProcessTask
	* @Description TODO【添加异步卡券用户删除处理方法】
	* @param wchatRequest 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void addAsyncUserDelCardProcessTask(final WchatRequestBean wchatRequest) {
		try {
			taskExecutor.execute(new Runnable() {
				public void run() {
					wchatCardMemberService.userDelCard(wchatRequest);
					//获取卡券最新数据
					cardPassCheck(wchatRequest);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title templateSendJobFinish
	* @Description 
	* @param wchat
	* @return
	* @see com.igrow.mall.service.wchat.intf.WchatContentService#templateSendJobFinish(com.igrow.mall.common.wchat.WchatRequestBean)
	*/ 
	@Override
	public String templateSendJobFinish(WchatRequestBean wchat) {
		return null;
	}

}
