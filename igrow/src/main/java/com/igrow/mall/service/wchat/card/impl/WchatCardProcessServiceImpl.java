/**
* @FileName WchatCardProcessServiceImpl.java
* @Package com.igrow.mall.service.wchat.card.impl
* @Description TODO【用一句话描述该文件做什么】
* @Author brights
* @Date 2014年10月22日 下午4:00:24
* @Version V1.0.1
*/
package com.igrow.mall.service.wchat.card.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.stereotype.Service;

import com.igrow.mall.bean.card.request.WchatCardBatchgetReq;
import com.igrow.mall.bean.card.request.WchatCardCreateReq;
import com.igrow.mall.bean.card.request.WchatCardDeleteReq;
import com.igrow.mall.bean.card.request.WchatCardGetReq;
import com.igrow.mall.bean.card.request.WchatCardGetcolorsReq;
import com.igrow.mall.bean.card.request.WchatCardUpdateReq;
import com.igrow.mall.bean.card.response.WchatCardBatchgetRes;
import com.igrow.mall.bean.card.response.WchatCardCreateRes;
import com.igrow.mall.bean.card.response.WchatCardDeleteRes;
import com.igrow.mall.bean.card.response.WchatCardGetRes;
import com.igrow.mall.bean.card.response.WchatCardGetcolorsRes;
import com.igrow.mall.bean.card.response.WchatCardUpdateRes;
import com.igrow.mall.bean.card.response.color.Color;
import com.igrow.mall.common.httpClient.HttpsRequestHandler;
import com.igrow.mall.common.wchat.WchatCore;
import com.igrow.mall.service.wchat.card.intf.WchatCardProcessService;
import com.igrow.mall.service.wchat.intf.WchatAccessTokenProcess;

/**
 * @ClassName WchatCardProcessServiceImpl
 * @Description TODO【微信卡券处理服务接口】
 * @Author brights
 * @Date 2014年10月22日 下午4:00:24
 */
@Service("wchatCardProcessServiceImpl")
public class WchatCardProcessServiceImpl implements WchatCardProcessService {
	  private ObjectMapper objectMapper = new  ObjectMapper();  
		@Resource(name = "wchatAccessTokenProcessImpl")
		private WchatAccessTokenProcess wchatAccessTokenProcess;
	/**
	 * @Title create
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#create(com.igrow.mall.bean.card.request.WchatCardCreateReq)
	 */
	@Override
	public WchatCardCreateRes create(WchatCardCreateReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
	
			System.out.println(responseData);
			WchatCardCreateRes res = objectMapper.readValue(responseData, WchatCardCreateRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
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
	 * @Title delete
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#delete(com.igrow.mall.bean.card.request.WchatCardDeleteReq)
	 */
	@Override
	public WchatCardDeleteRes delete(WchatCardDeleteReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardDeleteRes res = objectMapper.readValue(responseData, WchatCardDeleteRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
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
	 * @Title update
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#update(com.igrow.mall.bean.card.request.WchatCardUpdateReq)
	 */
	@Override
	public WchatCardUpdateRes update(WchatCardUpdateReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardUpdateRes res = objectMapper.readValue(responseData, WchatCardUpdateRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
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
	 * @Title getcolors
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#getcolors(com.igrow.mall.bean.card.request.WchatCardGetcolorsReq)
	 */
	@Override
	public WchatCardGetcolorsRes getcolors(WchatCardGetcolorsReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			//String requestData =objectMapper.writeValueAsString(req);
			//System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,"");
			System.out.println(responseData);
			WchatCardGetcolorsRes res = objectMapper.readValue(responseData, WchatCardGetcolorsRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				if(res.getColorList() != null && res.getColorList().size() > 0){
					for(Color color : res.getColorList()){
						System.out.println("color.name="+color.getName());
						System.out.println("color.value="+color.getValue());
					}
				}
				
				System.out.println("*********************************result***********************************************");
				return res;
			}
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
	 * @Title get
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#get(com.igrow.mall.bean.card.request.WchatCardGetReq)
	 */
	@Override
	public WchatCardGetRes get(WchatCardGetReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			System.out.println(requestUrl);
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardGetRes res = objectMapper.readValue(responseData, WchatCardGetRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("*********************************result***********************************************");
				return res;
			}
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
	 * @Title batchget
	 * @Description 
	 * @param req
	 * @return
	 * @see com.igrow.mall.service.wchat.card.intf.WchatCardProcessService#batchget(com.igrow.mall.bean.card.request.WchatCardBatchgetReq)
	 */
	@Override
	public WchatCardBatchgetRes batchget(WchatCardBatchgetReq req) {
		try {
			//获取请求地址
			String requestUrl = WchatCore.getTokenReqUrl(req.req_url,wchatAccessTokenProcess.getAccessToken());
			//生成请求POST数据
			//序列化，忽略空值
			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);  
			String requestData =objectMapper.writeValueAsString(req);
			System.out.println(requestData);
			//请求处理
			String responseData = HttpsRequestHandler.sendPost(requestUrl,requestData);
			System.out.println(responseData);
			WchatCardBatchgetRes res = objectMapper.readValue(responseData, WchatCardBatchgetRes.class);
			if(res != null){
				System.out.println("*********************************result***********************************************");
				System.out.println("errcode="+res.getErrcode());
				System.out.println("errmsg="+res.getErrmsg());
				System.out.println("totalNum="+res.getTotalNum());
				System.out.println("length="+res.getCardIdList().length );
				if(res.getCardIdList() != null && res.getCardIdList().length > 0){
					int i = 1;
					for(String id : res.getCardIdList()  ){
						System.out.println("cardID"+i+ "=" +id);
					}
				}
				System.out.println("*********************************result***********************************************");
				return res;
			}
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

}
