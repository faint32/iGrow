/**
* @FileName WchatJsapiBean.java
* @Package com.igrow.mall.bean.card.jsapi.bean
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月24日 下午2:05:33
* @Version V1.0.1
*/
package com.igrow.mall.bean.card.jsapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.igrow.mall.bean.card.jsapi.batchadd.CardExtInfo;
import com.igrow.mall.bean.card.jsapi.batchadd.CardInfo;
import com.igrow.mall.bean.card.jsapi.req.WchatBatchAddCardReq;
import com.igrow.mall.bean.card.jsapi.sign.WchatCardJsAPISign;
import com.igrow.mall.common.constant.WchatConstant;


/**
 * @ClassName WchatJsapiBean
 * @Description TODO【WchatJsapiBean】
 * @Author brights
 * @Date 2014年10月24日 下午2:05:33
 */
public class WchatJsapiBean {
	  private static ObjectMapper objectMapper = new  ObjectMapper();  
	
	/**
	* @Title getWchatBatchAddCardReqData
	* @Description TODO【这里用一句话描述这个方法的作用】
	* @param cardId
	* @param code
	* @param openid
	* @param balance
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static  String getWchatBatchAddCardReqData(String cardId,String code,String openid,String balance){
		try {
				WchatBatchAddCardReq  req = getWchatBatchAddCardReq(cardId,code,openid,balance);
				//序列化，忽略空值
				objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
				String requestData =objectMapper.writeValueAsString(req);
				return requestData;
			} catch (JsonGenerationException  e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	* @Title getWchatBatchAddCardReq
	* @Description TODO【获取签名】
	* @param cardId
	* @param code
	* @param openid
	* @param balance
	* @return 
	* @Return WchatBatchAddCardReq 返回类型
	* @Throws 
	*/ 
	public static WchatBatchAddCardReq getWchatBatchAddCardReq(String cardId,String code,String openid,String balance){
		WchatBatchAddCardReq req = new WchatBatchAddCardReq();
		
		List<CardInfo> cards = new ArrayList<CardInfo>();
		CardInfo card = new CardInfo();
		card.setCardId(cardId);
		CardExtInfo cardExt = new CardExtInfo();
		if(StringUtils.isNotBlank(balance)){
			cardExt.setBalance(Long.parseLong(balance));
		}
		if(StringUtils.isNotBlank(code)){
			cardExt.setCode(code);
		}
		if(StringUtils.isNotBlank(openid)){
			cardExt.setOpenid(openid);
		}
		cardExt.setTimestamp(System.currentTimeMillis()/1000);
		System.out.println("timestamp:"+cardExt.getTimestamp());
		cardExt.setSignature(getWchatBatchAddCardSignature(cardExt.getTimestamp(),cardId));
		System.out.println("signature:"+cardExt.getSignature());
		card.setCardExt(cardExt);
		cards.add(card);
		
		req.setCards(cards);
       return req;		
	}
	
	/**
	* @Title getWchatBatchAddCardSignature
	* @Description TODO【签名字符串生成】
	* @param timestamp
	* @param cardId
	* @param code
	* @param openid
	* @param balance
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String getWchatBatchAddCardSignature(Long timestamp,String cardId){
	/*	Date now = new Date();
		//String cardId1 = "pVE3-sssq8fhZrLVzw5C83ragmjI";
		Long timestamp1 = now.getTime()/1000;
		System.out.println("timestamp1:"+ timestamp1.toString());*/
		ArrayList<String> signParams = new ArrayList<String>();
		signParams.add(cardId);
		signParams.add(timestamp.toString());
		signParams.add(WchatConstant.wchat_appsecret);
		return WchatCardJsAPISign.getSignatureStr(signParams);
	}
	
	
	public static String getWchatChooseCardSignature(Long timestamp){
		//String appId = "wx8a865f88c23ec791";
	   	Integer	 locationId = 271720134;
	   	//String	signType = "SHA1";
	   	//String	cardSign = "";
	   	String	cardId2 = "";
	   	String	cardType = "";
		//Long timestamp2 = now.getTime()/1000;
	   	System.out.println("timestamp2:"+ timestamp.toString());
	   	String	nonceStr= "123123";
	   	ArrayList<String> signParams = new ArrayList<String>();
		signParams.add(WchatConstant.wchat_appid);
	   	signParams.add(WchatConstant.wchat_appsecret);
		signParams.add(locationId.toString());
		signParams.add(timestamp.toString());
		signParams.add(nonceStr);
		signParams.add(cardId2);
		signParams.add(cardType);
		return WchatCardJsAPISign.getSignatureStr(signParams);
	}
	
	public static void main(String[] args) {
		Date now = new Date();
		/* 领取卡券*/
/*		String cardId1 = "pVE3-sssq8fhZrLVzw5C83ragmjI";
		Long timestamp1 = now.getTime()/1000;
		System.out.println("timestamp1:"+ timestamp1.toString());
		ArrayList<String> signParams = new ArrayList<String>();
		signParams.add(cardId1);
		signParams.add(timestamp1.toString());
		signParams.add(WchatConstant.wchat_appsecret);
		String signature = WchatCardJsAPISign.getSignatureStr(signParams);
		System.out.println("signature2:"+signature);*/
		
		/* 卡券列表*/
		//String appId = "wx8a865f88c23ec791";
	   	Integer	 locationId = 271720134;
	   	//String	signType = "SHA1";
	   	//String	cardSign = "";
	   	String	cardId2 = "";
	   	String	cardType = "";
		Long timestamp2 = now.getTime()/1000;
	   	System.out.println("timestamp2:"+ timestamp2.toString());
	   	String	nonceStr= "123123";
	   	ArrayList<String> signParams = new ArrayList<String>();
		signParams.add(WchatConstant.wchat_appid);
	   	signParams.add(WchatConstant.wchat_appsecret);
		signParams.add(locationId.toString());
		signParams.add(timestamp2.toString());
		signParams.add(nonceStr);
		signParams.add(cardId2);
		signParams.add(cardType);
		String signature = WchatCardJsAPISign.getSignatureStr(signParams);
		System.out.println("signature2:"+signature);
	   	
	   	
	   	
	   	
	}

}
