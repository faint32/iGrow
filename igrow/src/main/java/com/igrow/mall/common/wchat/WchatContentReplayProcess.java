/**
* @FileName WchatUtil.java
* @Package com.fwchat.util
* @Description TODO【用一句话描述该文件做什么】
* @Author 
* @Date 2014年8月14日 下午2:47:00
* @Version V1.0.1
*/
package com.igrow.mall.common.wchat;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.igrow.mall.common.constant.WchatConstant;
import com.igrow.mall.common.enums.wchat.WmsgType;
import com.igrow.mall.common.wchat.WchatResponseBean.Article;
import com.igrow.mall.common.wchat.WchatResponseBean.TransInfo;

/**
 * @ClassName WchatContentReplayProcess
 * @Description TODO【微信内容回复处理】
 * @Author brights
 * @Date 2014年8月14日 下午2:47:00
 */
public class WchatContentReplayProcess {
	
	
	/**
	* @Title text
	* @Description TODO【文本消息】
	* @param wchatRequest
	* @param content
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String text(WchatRequestBean wchatRequest,String content){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis());
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TEXT.getDesc()+ XmlUtil.SUFFIX_CDATA);
		wchatResponse.setContent(XmlUtil.PREFIX_CDATA 
							+ content.replaceAll("N", "\n")  
				 + XmlUtil.SUFFIX_CDATA);
		return XmlUtil.toXml(wchatResponse);
	}
	
	/**
	* @Title text
	* @Description TODO【图文消息】
	* @param wchatRequest
	* @param content
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	public static String newsOfActive(WchatRequestBean wchatRequest,String content){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		if(StringUtils.isNotBlank(content)){
			JSONObject jsonObj = JSONObject.fromObject(content.trim());
			JSONObject items = (JSONObject) jsonObj.getJSONArray("item").get(0); //获取记录
			JSONArray multiiItems =items.getJSONArray("multi_item"); //获取子记录
			wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setCreateTime(items.getLong("create_time"));
			wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.NEWS.getDesc() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setArticleCount(multiiItems.size());
			List<Article> articles = new ArrayList<Article>();
			for(int i =0 ; i < multiiItems.size() ; i++){
				Article article = wchatResponse.new Article();
				JSONObject obj = (JSONObject) multiiItems.get(i); //获取记录
				article.setTitle(XmlUtil.PREFIX_CDATA + obj.getString("title") + XmlUtil.SUFFIX_CDATA);
				article.setDescription(XmlUtil.PREFIX_CDATA +  obj.getString("digest")  + XmlUtil.SUFFIX_CDATA);
				article.setPicUrl(XmlUtil.PREFIX_CDATA +  obj.getString("cover")  + XmlUtil.SUFFIX_CDATA);
				article.setUrl(XmlUtil.PREFIX_CDATA +  obj.getString("content_url")  + XmlUtil.SUFFIX_CDATA);
				articles.add(article);
			}
			wchatResponse.setArticles(articles);
			return XmlUtil.toXml(wchatResponse);
		}
		return null ; 
	}
	
	/**
	* @Title subscribe
	* @Description TODO【关注】
	* @param wchatRequest
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String subscribe(WchatRequestBean wchatRequest){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis());
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TEXT.getDesc()+ XmlUtil.SUFFIX_CDATA);
		wchatResponse.setContent(XmlUtil.PREFIX_CDATA 
												 + WchatConstant.subscribe_replay_words 
												 + XmlUtil.SUFFIX_CDATA);
		return XmlUtil.toXml(wchatResponse);
	}
	
	/**
	* @Title subscribe
	* @Description TODO【关注】
	* @param wchatRequest
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String subscribe(WchatRequestBean wchatRequest,String content){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis());
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TEXT.getDesc()+ XmlUtil.SUFFIX_CDATA);
		if(StringUtils.isBlank(content)){
			content = WchatConstant.subscribe_replay_words  ;
		}
		System.out.println(content);
		//content = content.replaceAll("N", "\n");
		wchatResponse.setContent(XmlUtil.PREFIX_CDATA 
												+ content.replaceAll("N", "\n")  
												 + XmlUtil.SUFFIX_CDATA);
		return XmlUtil.toXml(wchatResponse);
	}
	
	/**
	* @Title unsubscribe
	* @Description TODO【取消关注】
	* @param wchatRequest
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/ 
	public static String unsubscribe(WchatRequestBean wchatRequest){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis());
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TEXT.getDesc()+ XmlUtil.SUFFIX_CDATA);
		wchatResponse.setContent(XmlUtil.PREFIX_CDATA 
				 								 + "谢谢您的关注，欢迎再次关注！" 
												 + XmlUtil.SUFFIX_CDATA);
		return XmlUtil.toXml(wchatResponse);
	}
	
	
	/**
	* @Title newsOfProductList
	* @Description TODO【生成商品列表图文消息】
	* @param wchatRequest
	* @param content
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	/*public static String newsOfProductList(WchatRequestBean wchatRequest,String content,List<ProductShelvesInfo> products){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		if(products != null && products.size() >0){
			wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setCreateTime(System.currentTimeMillis());
			wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.NEWS.getDesc() + XmlUtil.SUFFIX_CDATA);
			int size = products.size(); 
			if(products.size() >9){
				size = 9;
			}
			wchatResponse.setArticleCount(size + 1);
			List<Article> articles = new ArrayList<Article>();
			for(int i =0 ; i < size; i++){
				Article article = wchatResponse.new Article();
				article.setTitle(XmlUtil.PREFIX_CDATA + products.get(i).getProductInfo().getName() + XmlUtil.SUFFIX_CDATA);
				article.setDescription(XmlUtil.PREFIX_CDATA +  products.get(i).getProductInfo().getName() + XmlUtil.SUFFIX_CDATA);
				article.setPicUrl(XmlUtil.PREFIX_CDATA + WchatConstant.H5_PRODUCT_IMAGE_URL +  products.get(i).getProductInfo().getRealImgUrl()  + XmlUtil.SUFFIX_CDATA);
				article.setUrl(XmlUtil.PREFIX_CDATA + WchatConstant.H5_PRODUCT_URL + products.get(i).getProductSn()+ XmlUtil.SUFFIX_CDATA);
				articles.add(article);
			}
				Article lastArticle = wchatResponse.new Article();
				lastArticle.setTitle(XmlUtil.PREFIX_CDATA + "更多..." + XmlUtil.SUFFIX_CDATA);
				lastArticle.setDescription(XmlUtil.PREFIX_CDATA +  "更多..." + XmlUtil.SUFFIX_CDATA);
				lastArticle.setPicUrl(XmlUtil.PREFIX_CDATA + "" + XmlUtil.SUFFIX_CDATA);
				lastArticle.setUrl(XmlUtil.PREFIX_CDATA +  WchatConstant.H5_PRODUCT_LIST_URL + products.get(0).getHotelInfo().getCode() + XmlUtil.SUFFIX_CDATA);
				articles.add(lastArticle);
			wchatResponse.setArticles(articles);
			return XmlUtil.toXml(wchatResponse);
		}
		return null ; 
	}*/
	
	
	/**
	* @Title newsOfProduct
	* @Description TODO【生成商品列表图文消息】
	* @param wchatRequest
	* @param content
	* @return 
	* @Return String 返回类型
	* @Throws 
	*/
	/*public static String newsOfProduct(WchatRequestBean wchatRequest,String content,ProductShelvesInfo product){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		if(product != null ){
			wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setCreateTime(System.currentTimeMillis());
			wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.NEWS.getDesc() + XmlUtil.SUFFIX_CDATA);
			wchatResponse.setArticleCount(1);
			List<Article> articles = new ArrayList<Article>();
			Article article = wchatResponse.new Article();
			article.setTitle(XmlUtil.PREFIX_CDATA + product.getProductInfo().getName() + XmlUtil.SUFFIX_CDATA);
			article.setDescription(XmlUtil.PREFIX_CDATA +  product.getProductInfo().getName() + XmlUtil.SUFFIX_CDATA);
			article.setPicUrl(XmlUtil.PREFIX_CDATA +  WchatConstant.H5_PRODUCT_IMAGE_URL +  product.getProductInfo().getRealImgUrl()  + XmlUtil.SUFFIX_CDATA);
			article.setUrl(XmlUtil.PREFIX_CDATA +   WchatConstant.H5_PRODUCT_URL + product.getProductSn() + XmlUtil.SUFFIX_CDATA);
			articles.add(article);
			wchatResponse.setArticles(articles);
			return XmlUtil.toXml(wchatResponse);
		}
		return null ; 
	}*/
	
	public static String transferCustomerService(WchatRequestBean wchatRequest,String account){
		WchatResponseBean wchatResponse = new WchatResponseBean();
		wchatResponse.setToUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getFromUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setFromUserName(XmlUtil.PREFIX_CDATA + wchatRequest.getToUserName() + XmlUtil.SUFFIX_CDATA);
		wchatResponse.setCreateTime(System.currentTimeMillis()/1000);
		wchatResponse.setMsgType(XmlUtil.PREFIX_CDATA + WmsgType.TRANSFER_CUSTOMER_SERVICE.getDesc()+ XmlUtil.SUFFIX_CDATA);
		TransInfo transInfo = wchatResponse.new TransInfo();
		transInfo.setKfAccount(account);
		wchatResponse.setTransInfo(transInfo);
		return XmlUtil.toXml(wchatResponse);
	}
	
	
	
	
	
	
}
